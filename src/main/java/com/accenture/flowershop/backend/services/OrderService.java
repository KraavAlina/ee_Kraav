package com.accenture.flowershop.backend.services;

import com.accenture.flowershop.backend.access.FlowerAccess;
import com.accenture.flowershop.backend.access.OrderAccess;
import com.accenture.flowershop.backend.access.UserAccess;
import com.accenture.flowershop.backend.entity.FlowerEntity;
import com.accenture.flowershop.backend.entity.FlowersInOrderEntity;
import com.accenture.flowershop.backend.entity.OrderEntity;
import com.accenture.flowershop.backend.entity.UserEntity;
import com.accenture.flowershop.backend.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@Service
public class OrderService {
    private static final Logger LOG = Logger.getLogger(OrderEntity.class.getName());

    @Autowired
    private UserAccess userAccess;
    @Autowired
    private OrderAccess orderAccess;
    @Autowired
    private FlowerAccess flowerAccess;

    @PostConstruct
    public void init() {
        LOG.info("Order service on");
    }

    /* Оформление заказа.
    Вход: пользователь добавивший заказ, map (id выбранного цветка, количество этих цветов)
    Выход: заказ с пользователем и списком цветов
    * */
    public OrderEntity createOrder (UserEntity owner, Map<Long, String> receivedFlowers) {
        OrderEntity newOrderEntity = new OrderEntity(owner);
        FlowersInOrderEntity flowersInOrderEntity = null;
        BigDecimal fullPriceOrder = BigDecimal.ZERO;
        BigDecimal fullPriceFlower = BigDecimal.ZERO;
        BigDecimal fullDiscountPrice = BigDecimal.ZERO;

        Iterator it = receivedFlowers.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            FlowerEntity receivedFlower = flowerAccess.getById((Long)pair.getKey());

            // Расчет полной стоимости за каждый вид цветка и за весь заказ
            BigDecimal priceFlowers = receivedFlower.getPrice();
            int countReceivedFlowers = Integer.parseInt(pair.getValue().toString());
            fullPriceFlower = priceFlowers.multiply(new BigDecimal(countReceivedFlowers));
            fullPriceOrder = fullPriceOrder.add(fullPriceFlower);

            // Создание строки с цветком и заказом и добавление в список FO в заказе
            flowersInOrderEntity = new FlowersInOrderEntity(receivedFlower, Integer.parseInt(pair.getValue().toString()));
            newOrderEntity.addFlowers(flowersInOrderEntity);

            it.remove();
        }

        // Расчет стоимости с учетом скидки
        double ownerDiscount = owner.getDiscount();
        double discount = 1-ownerDiscount/100;
        fullDiscountPrice = fullPriceOrder.multiply(new BigDecimal(discount));

        newOrderEntity.setFullPrice(fullPriceOrder.setScale(2, RoundingMode.CEILING));
        newOrderEntity.setDiscountPrice(fullDiscountPrice.setScale(2, RoundingMode.CEILING));

        return newOrderEntity;
    }

    /* Сохранение заказа в списке заказов пользователя.
    Вход: заказ
    Выход: заказ с измененным статусом CREATED, положить данные в БД,
            null - если баланс пользователя меньше стоимости заказа
    * */
    public OrderEntity saveOrder (OrderEntity orderEntity) {
        UserEntity owner = orderEntity.getOwner();

        // Если баланс пользователя меньше, то заказ не сохраняется, возвращается null
        if (owner.getBalance().compareTo(orderEntity.getDiscountPrice()) == -1) {
            return null;
        }

        else {
            orderEntity.setStatus(OrderStatus.CREATED);

            // Изменение количества цветов на складе, в БД
            int changeCount;
            List<FlowersInOrderEntity> flowersOfOrder = orderEntity.getFlowersDate();
            for (FlowersInOrderEntity flowers : flowersOfOrder) {
                if (flowers.getOrder().equals(orderEntity)) {
                     changeCount = flowers.getFlower().getCount() - flowers.getCount();
                     flowers.getFlower().setCount(changeCount);
                     flowerAccess.update(flowers.getFlower());
                }
            }
            // Изменение данных пользователя
            owner.addOrder(orderEntity);
            userAccess.update(owner);

            // Добавление данных заказа в БД
            orderAccess.add(orderEntity);
            return orderEntity;
        }
    }

    /* Оплата заказа
    Вход: ID заказа
    Выход: заказ с измененным статусом PAID, изменным у пользователя балансом; null - если баланс пользователя
    меньше стоимости заказа
    * */
    public OrderEntity payOrder (String payIdOrder){
        OrderEntity orderEntity = orderAccess.getById(Long.parseLong(payIdOrder));
        UserEntity owner = orderEntity.getOwner();
        if (owner.getBalance().compareTo(orderEntity.getFullPrice()) == -1) {
            return null;
        }
        else {
            owner.setBalance(owner.getBalance().subtract(orderEntity.getDiscountPrice()));
            orderEntity.setStatus(OrderStatus.PAID);
            userAccess.update(owner);
            orderAccess.update(orderEntity);
        }
        return orderEntity;
    }

}

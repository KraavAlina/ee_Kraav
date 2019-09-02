package com.accenture.flowershop.webService;


import com.accenture.flowershop.backend.entity.FlowerEntity;
import com.accenture.flowershop.backend.services.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class FlowersStockWebServiceImpl implements FlowersStockWebService {

    @Autowired
    private FlowerService flowerService;

    @Override
    public void increaseFlowersStockSize(int count) {
        List<FlowerEntity> allFlowers = flowerService.getAllFlowers();

        for (FlowerEntity flower : allFlowers) {
            flower.setCount(flower.getCount() + count);
            flowerService.update(flower);
        }
    }
}



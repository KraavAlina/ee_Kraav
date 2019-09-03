package com.accenture.flowershop.backend.services;

import com.accenture.flowershop.backend.entity.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.jms.*;
import java.io.IOException;

@Service
public class JmsMessageService {
    private static final Logger LOG = LoggerFactory.getLogger(JmsMessageService.class);
    @Autowired
    private UserService userService;

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private Queue receiveUserDiscountXmlQueue;

    @Autowired
    private Queue sendNewUsersXmlQueue;

    @Autowired
    private XMLConverter xmlConverter;

    Session session;

    @PostConstruct
    public void init() {
        try {
            Connection connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            MessageConsumer consumer = session.createConsumer(receiveUserDiscountXmlQueue);
            connection.start();
            consumer.setMessageListener(
                    new MessageListener() {
                        //<user-entity><login>alex1</login><discount>20</discount></user-entity>
                        public void onMessage(Message message) {
                            try {
                                String text = ((TextMessage) message).getText();
                                UserEntity m = (UserEntity) xmlConverter.convertFromXMLStringToObject(text);

                                UserEntity user = userService.findByLogin(m.getLogin());
                                user.setDiscount(m.getDiscount());
                                userService.update(user);
                            } catch (JMSException | IOException e) {
                                LOG.error("Error receiving message");
                                e.printStackTrace();
                            }
                        }
                    });
            LOG.info("Jms Message Service on");
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }


    public void SendNewUserSql(UserEntity user) {
        TextMessage msg;
        try {
            msg = session.createTextMessage(xmlConverter.convertFromObjectToXMLString(user));

            MessageProducer producer = session.createProducer(sendNewUsersXmlQueue);
            producer.send(msg);
            producer.close();
        } catch (JMSException | IOException e) {
            LOG.error("Error sending message");
            e.printStackTrace();
        }
    }
}

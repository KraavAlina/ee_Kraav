package com.accenture.flowershop.backend.services;

import com.accenture.flowershop.backend.access.FlowerAccess;
import com.accenture.flowershop.backend.entity.FlowerEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@Service
public class FlowerService {
    private static final Logger LOG = Logger.getLogger(FlowerEntity.class.getName());

    @Autowired
    private FlowerAccess flowerAccess;

    @PostConstruct
    public void init() {
        LOG.info("Flower service on");
    }

//    public FlowerEntity findFlower(FlowerEntity flowerEntity) {
//        return flowerAccess.get(flowerEntity);
//    }

    public FlowerEntity findFlowerById(Long id){
        return flowerAccess.getById(id);
    }

    public List<FlowerEntity> getAllOrderedFlowers (List<Long> idOrderedFlowers){
        List<FlowerEntity> returnFlowerList = new ArrayList<>();
        for (Long idFlower : idOrderedFlowers){
            FlowerEntity findFlower = findFlowerById(idFlower);
            if (findFlower != null){
                returnFlowerList.add(findFlower);
            }
        }
        return returnFlowerList;
    }

    public List<FlowerEntity> getAllFlowers() {
       return flowerAccess.getAll();
    }
}

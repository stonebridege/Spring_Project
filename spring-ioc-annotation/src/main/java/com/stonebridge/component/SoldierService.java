package com.stonebridge.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SoldierService {

    private SoldierDao soldierDao;

    @Autowired
    public void setSoldierDao(SoldierDao soldierDao) {
        this.soldierDao = soldierDao;
    }

    public void getMessage() {
        soldierDao.getMessage();
    }
}

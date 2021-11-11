package com.stonebridge.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class SoldierController {

    private SoldierService soldierService;

    @Autowired
    public SoldierController(SoldierService soldierService) {
        this.soldierService = soldierService;
    }

    public void getMessage() {
        soldierService.getMessage();
    }
}

package com.stonebridge.proxy.impl;

import com.stonebridge.proxy.api.SoldierService;

public class SoldierServiceImpl implements SoldierService {
    @Override
    public int saveSoldier(String soldierName) {
        System.out.println("核心业务逻辑：保存到数据库……");
        return 1;
    }

    @Override
    public int removeSoldier(Integer soldierId) {
        System.out.println("核心业务逻辑：从数据库删除……");
        return 1;
    }

    @Override
    public int updateSoldier(Integer soldierId, String soldierName) {
        System.out.println("核心业务逻辑：更新……");
        return 1;
    }

    @Override
    public String getSoldierNameById(Integer soldierId) {
        System.out.println("核心业务逻辑：查询数据库……");
        return "good";
    }
}

package com.stonebridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TopService {
    // 这里我们只是为了测试事务传播行为，临时在Service中装配另一个Service
    // 实际开发时非常不建议这么做，因为这样会严重破坏项目的结构
    @Autowired
    private EmpService empService;

    @Transactional
    public void topTxMethod() {
        // 在外层方法中调用两个内层方法
        empService.updateEmpNameInner(700, "Trump");
        empService.updateEmpSalaryInner(800, 666.66);
    }
}

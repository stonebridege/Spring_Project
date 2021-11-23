package com.stonebridge.ssm.controller;

import com.stonebridge.ssm.entity.Emp;
import com.stonebridge.ssm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class EmpController {
    private EmpService empService;

    @Autowired
    public void setEmpService(EmpService empService) {
        this.empService = empService;
    }

    @RequestMapping("/get/all")
    public String getAll(Model model) {
        // 1、查询数据
        List<Emp> empList = empService.getAll();
        // 2.存入模型
        model.addAttribute("empList", empList);
        return "emp-list";
    }
}

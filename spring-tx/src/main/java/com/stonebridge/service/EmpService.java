package com.stonebridge.service;

import com.stonebridge.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmpService {
    private EmpDao empDao;

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void updateEmpNameInner(Integer empId, String empName) {
        empDao.updateEmpNameById(empId, empName);
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
    public void updateEmpSalaryInner(Integer empId, Double empSalary) {
        empDao.updateEmpSalaryById(empId, empSalary);
        System.out.println(10 / 0);
    }
}

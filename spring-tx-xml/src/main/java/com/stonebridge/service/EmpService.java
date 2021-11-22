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

    @Autowired
    private void setEmpDao(EmpDao empDao) {
        this.empDao = empDao;
    }

    // 为了便于核对数据库操作结果，不要修改同一条记录
    // 修改员工姓名的一组参数 (empId4EditName,newName)
    // 修改员工工资的一组参数 (empId4EditSalary,newSalary)
    public void updateTwice(Integer empId4EditName, String newName, Integer empId4EditSalary, Double newSalary) {
        // 为了测试事务是否生效，执行两个数据库操作，看它们是否会在某一个失败时一起回滚
        empDao.updateEmpNameById(empId4EditName, newName);
//        int a = 10 / 0;
        empDao.updateEmpSalaryById(empId4EditSalary, newSalary);
    }

    public String getEmpName(Integer empId) {
        return empDao.selectEmpNameById(empId);
    }

    public void updateEmpName(Integer empId, String empName) {
        empDao.updateEmpNameById(empId, empName);
    }

    public void updateEmpNameInner(Integer empId, String empName) {
        empDao.updateEmpNameById(empId, empName);
    }

    public void updateEmpSalaryInner(Integer empId, Double empSalary) {
        empDao.updateEmpSalaryById(empId, empSalary);
        System.out.println(10 / 0);
    }
}

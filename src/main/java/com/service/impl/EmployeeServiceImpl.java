package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.po.Employee;
import com.mapper.EmployeeMapper;
import com.service.EmployeeService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Tptogiar
 * @since 2022-01-28
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    @Override
    public PageInfo<Employee> getEmps(Integer current, Integer size) {
//        Page<Employee> employeePage = new Page<>(current, size);
//        List<Employee> employees = employeeMapper.selectPage(employeePage, null);
//        employeePage.setRecords(employees);
//        return employeePage;
        PageHelper.startPage(current,size);
        List<Employee> employees = employeeMapper.selectList(null);
        PageInfo<Employee> employeePageInfo = new PageInfo<>(employees);
        return employeePageInfo;
    }
}

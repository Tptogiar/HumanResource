package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
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

    @Override
    public boolean isUsernameExist(String username) {
        Integer count = employeeMapper.selectCount(new EntityWrapper<Employee>().eq("emp_name", username));
        return count!=0;
    }


    @Override
    public Employee getEmp(Integer id) {
        return employeeMapper.selectByEmpIdWithDept(id);
    }

    @Override
    public boolean deleteEmp(Integer id) {
        Integer integer = employeeMapper.deleteById(id);
        return integer==1;
    }

    @Override
    public boolean deleteBatch(List<Integer> del_ids) {
        Integer integer = employeeMapper.deleteBatchIds(del_ids);
        return integer!=0;
    }


}

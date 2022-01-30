package com.service;

import com.github.pagehelper.PageInfo;
import com.pojo.po.Employee;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tptogiar
 * @since 2022-01-28
 */

public interface EmployeeService extends IService<Employee> {

    PageInfo<Employee> getEmps(Integer current, Integer size);

    boolean isUsernameExist(String username);

    Employee getEmp(Integer id);
}

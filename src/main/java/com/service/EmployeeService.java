package com.service;

import com.baomidou.mybatisplus.plugins.Page;
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

    Page<Employee> getEmps(Integer current, Integer size);
}

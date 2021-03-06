package com.mapper;

import com.pojo.po.Employee;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Tptogiar
 * @since 2022-01-28
 */
public interface EmployeeMapper extends BaseMapper<Employee> {

    public Employee selectByEmpIdWithDept(Integer id);

}

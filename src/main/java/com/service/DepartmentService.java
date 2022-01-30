package com.service;

import com.pojo.po.Department;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Tptogiar
 * @since 2022-01-28
 */
public interface DepartmentService extends IService<Department> {

    List<Department> getDepts();
}

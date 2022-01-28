package com.mapper;

import com.pojo.po.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class DepartmentMapperTest {


    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void testInsert() {
        Integer insert = departmentMapper.insert(new Department(null, "开发部"));
        System.out.println(insert);
    }

    @Test
    public void testSelect() {
        Department department = departmentMapper.selectById(20);
        System.out.println(department);
    }
}
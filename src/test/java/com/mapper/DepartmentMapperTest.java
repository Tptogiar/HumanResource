package com.mapper;

import com.beans.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class DepartmentMapperTest {


    @Autowired
    DepartmentMapper departmentMapper;

    @Test
    public void test() {
        Integer test = departmentMapper.insert(new Department(null, "test"));
    }





}
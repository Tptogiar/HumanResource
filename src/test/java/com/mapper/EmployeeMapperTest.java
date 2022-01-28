package com.mapper;

import com.baomidou.mybatisplus.spring.MybatisSqlSessionFactoryBean;
import com.pojo.po.Employee;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.UUID;

import static org.junit.Assert.*;




@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:config/applicationContext.xml")
public class EmployeeMapperTest {


    @Autowired
    MybatisSqlSessionFactoryBean sqlSessionFactory;


    @Autowired
    private EmployeeMapper employeeMapper;


    @Test
    public void testInsert() {
        Employee tptogiar = new Employee(null, "Tptogiar", "1", "252@qq.com", 20);
        Integer insert = employeeMapper.insert(tptogiar);
        System.out.println(insert);
    }

    @Test
    public void testSelect() {
        Employee employee = employeeMapper.selectById(3);
        System.out.println(employee);
        Employee employee1 = employeeMapper.selectByEmpIdWithDept(3);
        System.out.println(employee1);
    }


    @Test
    public void testBatch() throws Exception {
        SqlSessionFactory sqlSessionFactory = this.sqlSessionFactory.getObject();
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 20; i++) {
            String name = UUID.randomUUID().toString().substring(0, 4);
            Employee employee = new Employee(null, name, "1", name + "@qq.com", 20);
            mapper.insert(employee);
        }
        sqlSession.commit();
    }
}
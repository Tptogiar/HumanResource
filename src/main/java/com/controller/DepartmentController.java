package com.controller;


import com.pojo.po.Department;
import com.pojo.vo.Msg;
import com.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tptogiar
 * @since 2022-01-28
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {


    @Autowired
    DepartmentService departmentService;


    @GetMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> departments=departmentService.getDepts();
        Msg msg = Msg.success().addData("depts", departments);
        return msg;
    }




}


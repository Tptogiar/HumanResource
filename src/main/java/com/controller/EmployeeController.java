package com.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageInfo;
import com.pojo.po.Employee;
import com.pojo.vo.Msg;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Tptogiar
 * @since 2022-01-28
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/emps")
    @ResponseBody
    public Msg getEmps(
            @RequestParam(value = "page",defaultValue = "1") Integer page,
            @RequestParam(value = "per_page",defaultValue = "5")Integer size
    ){
        PageInfo<Employee> emps = employeeService.getEmps(page, size);
        Msg msg = Msg.success();
        return msg.addData("emps", emps);
    }


    @PostMapping("/emp")
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result){
        if (result.hasErrors()){
            Map<String, Object> failMsg = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                failMsg.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().addData("errorFields",failMsg);
        }

        employeeService.insert(employee);
        return Msg.success();
    }


    @GetMapping("/checkUsername")
    @ResponseBody
    public Msg checkUsername(@RequestParam("username")String username){
        String regx = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\u2E80-\u9FFF]{2,5})";
        if(!username.matches(regx)){
            return Msg.fail("用户名必须是6-16位数字和字母的组合或者2-5位中文");
        }
        //数据库用户名重复校验
        boolean exist = employeeService.isUsernameExist(username);
        if(! exist){
            return Msg.success();
        }else{
            return Msg.fail("用户名不可用");
        }
    }

    @GetMapping("/emp/{id}")
    @ResponseBody
    public Msg getEmp(@PathVariable("id")Integer id){
        Employee employee =employeeService.getEmp(id);
        if (employee==null){
            return Msg.fail();
        }
        return Msg.success().addData("emp",employee);
    }

    @PutMapping("/emp/{empId}")
    @ResponseBody
    public Msg updateEmp(@Valid Employee employee,BindingResult result){
        if (result.hasErrors()){
            Map<String, Object> failMsg = new HashMap<>();
            for (FieldError fieldError : result.getFieldErrors()) {
                failMsg.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            return Msg.fail().addData("errorFields",failMsg);
        }
        employeeService.update(employee,new EntityWrapper<Employee>().eq("emp_id",employee.getEmpId()));
        return Msg.success();
    }




}
package com.dailyCodeBuffer.department.controller;

import com.dailyCodeBuffer.department.entity.Department;
import com.dailyCodeBuffer.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.String;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {

        log.info("save department in controller");
        return departmentService.saveDepartment(department);
    }


    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Long id) {

        log.info("inside findDepartment in controller");
        return departmentService.findDepartmentById(id);
    }
}

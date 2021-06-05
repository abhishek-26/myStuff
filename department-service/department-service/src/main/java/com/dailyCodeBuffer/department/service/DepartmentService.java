package com.dailyCodeBuffer.department.service;

import com.dailyCodeBuffer.department.entity.Department;
import com.dailyCodeBuffer.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {

        log.info("inside save department in departmentService");
        return departmentRepository.save(department);
    }


    public Department findDepartmentById(Long id) {

        log.info("inside findDepartmentById in service");
        return departmentRepository.findById(id).get();
    }
}

package com.dailyCodeBuffer.user.service;

import com.dailyCodeBuffer.user.VO.Department;
import com.dailyCodeBuffer.user.VO.ResponseTemplateVO;
import com.dailyCodeBuffer.user.entity.User;
import com.dailyCodeBuffer.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.io.BufferedReader;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("inside save method of service layer");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("inside UserWithDepartment in service");

        User user = userRepository.findById(userId).get();
        Department department = restTemplate.getForObject(
                "http://localhost:8081/departments/"+ user.getDepartmentId(), Department.class );

        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);

        return responseTemplateVO;
    }


}

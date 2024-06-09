package com.test.springboot.controller;

import com.test.springboot.entity.Company;
import com.test.springboot.entity.JobHunting;
import com.test.springboot.service.JobHuntingService;
import com.test.springboot.service.ResumeService;
import com.test.springboot.service.UserService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CompanyResumeVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("cmy")
public class GetCompanyResumeController {

    @Resource
    UserService userService;
    @Resource
    JobHuntingService jobHuntingService;
    @Resource
    ResumeService resumeService;


    @RequestMapping("getAllCompanyIdResume")
    public DataResult fun(@RequestBody Company company){



        List<CompanyResumeVo> result;
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        System.out.println(company.getId());

        result = jobHuntingService.queryByCompanyId(company.getId());

        return new DataResult(true,"查询成功",result);
    }
}
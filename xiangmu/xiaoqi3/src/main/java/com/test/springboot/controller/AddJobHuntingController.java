package com.test.springboot.controller;

import com.test.springboot.entity.JobHunting;
import com.test.springboot.entity.Resume;
import com.test.springboot.service.CompanyService;
import com.test.springboot.service.JobHuntingService;
import com.test.springboot.utils.result.DataResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class AddJobHuntingController {

    @Resource
    JobHuntingService jobHuntingService;

    @RequestMapping("addJobHunting")
    public DataResult fun(@RequestBody JobHunting jobHunting){


        System.out.println(jobHunting.getDescription());
        System.out.println("111111111111111");
        jobHunting = jobHuntingService.insert(jobHunting);
        if(!jobHuntingService.searchhot(jobHunting.getCompId1(),jobHunting.getId())){
             jobHuntingService.sethot(jobHunting.getCompId1());
        }
        jobHuntingService.addhot(jobHunting.getCompId1());

        return new DataResult(true,"投递成功",jobHunting);
    }
}
package com.test.springboot.controller;

import com.test.springboot.entity.CompStaff;
import com.test.springboot.entity.Resume;
import com.test.springboot.service.CompStaffService;
import com.test.springboot.service.CompanyService;
import com.test.springboot.service.JobHuntingService;
import com.test.springboot.service.ResumeService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CompanyResumeVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("cmy")
public class CompanyResumeNotPassController {

    @Resource
    private CompStaffService compStaffService;
    @Resource
    private JobHuntingService jobHuntingService;
    @RequestMapping("disagreeResume")
    public DataResult add(@RequestBody CompanyResumeVo companyResumeVo){

        System.out.println(companyResumeVo.toString());

        String s = companyResumeVo.getId();
        Integer id = Integer.parseInt(s);


        //compStaffService.insert1(companyResumeVo);

        //System.out.println("sssssssssssssssssssssssssssssssssssssssss");

        //jobHuntingService delete
        jobHuntingService.deleteById(Integer.parseInt(companyResumeVo.getId()));


        return  new DataResult(true,"简历已退回·");
    }
}
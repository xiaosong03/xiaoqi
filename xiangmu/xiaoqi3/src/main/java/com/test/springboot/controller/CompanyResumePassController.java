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
public class CompanyResumePassController {

    @Resource
    private CompStaffService compStaffService;
    @Resource
    private JobHuntingService jobHuntingService;
    @RequestMapping("agreeResume")
    public DataResult add(@RequestBody CompanyResumeVo companyResumeVo){

        System.out.println(companyResumeVo.toString());

        //String s = companyResumeVo.getId();
        //Integer id = Integer.parseInt(s);

        //向comp staff add
//        CompStaff compStaff = new CompStaff();
//        compStaff.setCompId(companyResumeVo.getCompId());
//        compStaff.setJob(2);
//        compStaff.setNumber(companyResumeVo.getCompId());
//        compStaff.setUserId(companyResumeVo.getUserId());

        //compStaffService.insert2(companyResumeVo.getCompId(),companyResumeVo.getUserId());

        //
        Object j = compStaffService.queryById(companyResumeVo.getCompId()) ;
        if(j == null){
            int max_id = 0;

            compStaffService.insert2(companyResumeVo,max_id);

            jobHuntingService.deleteById(Integer.parseInt(companyResumeVo.getId()));

            return  new DataResult(true,"投递成功");
        }

        //compStaffService.insert1(companyResumeVo);
        int max_id = compStaffService.selectCompanyMaxIdByComId(companyResumeVo.getCompId()) +1;

        System.out.println(max_id);

        compStaffService.insert2(companyResumeVo,max_id);


        System.out.println("sssssssssssssssssssssssssssssssssssssssss");

        //jobHuntingService delete
        jobHuntingService.deleteById(Integer.parseInt(companyResumeVo.getId()));


        return  new DataResult(true,"投递成功");
    }
}
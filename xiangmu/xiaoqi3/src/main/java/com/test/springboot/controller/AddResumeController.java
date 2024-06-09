package com.test.springboot.controller;

import com.test.springboot.entity.Resume;
import com.test.springboot.entity.User;
import com.test.springboot.service.InstStaffService;
import com.test.springboot.service.ResumeService;
import com.test.springboot.utils.result.DataResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class AddResumeController {
    @Resource
    private ResumeService resumeService;

    @RequestMapping("insertResume")
    public DataResult add(@RequestBody Resume resume){

        Resume r = new Resume();
        r.setUserId(resume.getUserId());
        r.setDescription(resume.getDescription());

        Resume result = resumeService.insert(r);

        return new DataResult(true,"投递成功",result);
    }
}
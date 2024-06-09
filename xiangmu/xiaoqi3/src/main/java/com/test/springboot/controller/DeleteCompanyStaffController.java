package com.test.springboot.controller;

import com.test.springboot.service.CompStaffService;
import com.test.springboot.service.CompanyService;
import com.test.springboot.service.UserService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.StaffInfoVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("cmy")
public class DeleteCompanyStaffController {

    @Resource
    private UserService userService;
    @Resource
    private CompanyService companyService;
    @Resource
    private CompStaffService compStaffService;
    @RequestMapping("deleteStaff")
    public DataResult fun(@RequestBody StaffInfoVo staffInfoVo){



        int result = compStaffService.deleteByUserId(staffInfoVo);
        return new DataResult(true,"删除成功");
    }
}

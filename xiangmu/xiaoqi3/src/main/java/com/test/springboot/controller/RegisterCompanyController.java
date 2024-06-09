package com.test.springboot.controller;

import com.test.springboot.entity.Company;
import com.test.springboot.service.CompStaffService;
import com.test.springboot.service.UserService;
import com.test.springboot.service.CompanyService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CompanyVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("cmy")
public class RegisterCompanyController {
    @Resource
    private UserService userService;
    @Resource
    private CompanyService companyService;
    @Resource
    private CompStaffService compStaffService;
    @RequestMapping("registComy")
    public DataResult fun(@RequestBody Company company){
        System.out.println("=------------==================");
        System.out.println(company.toString());

        company.setManager(company.getRegistrant());
        company.setLastNum(company.getRegistrant());

        Company result = null;

        Company ans = companyService.queryByRegistrantId(company);
        if(ans == null){
            result = companyService.insert(company);
        }else{
            DataResult s = new DataResult<>();
            s.setMessage("用户的公司已存在");

            System.out.println(s.toString());

            return s;
        }




        return DataResult.successByData(result);
    }
}

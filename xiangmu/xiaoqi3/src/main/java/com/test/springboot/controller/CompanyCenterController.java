package com.test.springboot.controller;

import com.test.springboot.entity.Company;
import com.test.springboot.entity.User;
import com.test.springboot.service.CompStaffService;
import com.test.springboot.service.CompanyService;
import com.test.springboot.service.UserService;
import com.test.springboot.utils.result.DataResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("info")
public class CompanyCenterController {
    @Resource
    private UserService userService;
    @Resource
    private CompanyService companyService;
    @Resource
    private CompStaffService compStaffService;
    @RequestMapping("getCmnyInfo")
    public DataResult fun(@RequestBody User user){
        System.out.println("-------------------------------");
        System.out.println(user.toString());
        DataResult s = new DataResult();
        Object u1 = null;
        Object u2 = null;
        u1 = companyService.isBossOrManager(user);
        if(u1==null){
            u2 =compStaffService.isStaff(user);
            if(u2 == null){
                s.setMessage("not boss not staff");
                s.setStat(false);
                s.setStat_emp(false);
                return s;
            }
            s.setMessage("is staff");
            s.setStat(false);//不是boss
            s.setStat_emp(true);// is staff
            return s;
        }
        s.setMessage("is boss");
        s.setStat(true);//不是boss
        s.setStat_emp(false);// is staff

        Company company = null;
        if(u1 != null){
            int comp_id = companyService.queryByUserId(user);

            company = companyService.queryById(comp_id);
            //System.out.println(company);
        }
        if(u2 != null){
            int comp_id = compStaffService.queryByUserId(user);

            company = companyService.queryById(comp_id);
            //System.out.println(company);
        }
        System.out.println(company);
        s.setDatas(company);

        return s;
    }
}

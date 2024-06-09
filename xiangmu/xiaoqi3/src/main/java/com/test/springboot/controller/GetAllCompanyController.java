package com.test.springboot.controller;

import com.test.springboot.entity.Company;
import com.test.springboot.service.CompanyService;
import com.test.springboot.service.CooperationService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CooperateInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("cmy")
public class GetAllCompanyController {
    @Resource
    CompanyService companyService;

    @RequestMapping("getCompanyList")
    public DataResult fun(){

        List<Company> result;
        result = companyService.queryAll();

        long count = 0;

        return DataResult.successByTotalData(result,count);
    }

}
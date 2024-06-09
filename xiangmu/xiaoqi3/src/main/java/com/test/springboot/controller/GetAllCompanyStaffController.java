package com.test.springboot.controller;

import com.test.springboot.service.CompStaffService;
import com.test.springboot.service.UserService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CompanyVo;
import com.test.springboot.vo.StaffInfoVo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("cmy")
public class GetAllCompanyStaffController {

    @Resource
    private UserService userService;
    //    @Resource
    //    private CompanyService companyService;
    @Resource
    private CompStaffService compStaffService;
    @RequestMapping("getAllStaff")
    public DataResult fun(@RequestBody CompanyVo companyVo){
        System.out.println("_____________________________________");
        System.out.println(companyVo.toString());

        Integer limit = companyVo.getLimit();
        Integer page = companyVo.getPage();
        companyVo.setPage((page-1)*limit);

        List<StaffInfoVo> staffInfoVos;

        staffInfoVos = compStaffService.getStaffInfoVos(companyVo);

        if(companyVo.getSelctName()=="" && companyVo.getSelectNu()==""){
            staffInfoVos = compStaffService.getStaffInfoVos(companyVo);
        }
        else if(companyVo.getSelctName()!="" && companyVo.getSelectNu()==""){
            staffInfoVos = compStaffService.getStaffInfoVos1(companyVo);
        }
        else if(companyVo.getSelctName()=="" && companyVo.getSelectNu()!=""){
            staffInfoVos = compStaffService.getStaffInfoVos2(companyVo);
        }
        else{
            staffInfoVos = compStaffService.getStaffInfoVos3(companyVo);
        }

        System.out.println(staffInfoVos.toString());

//        for(StaffInfoVo x :staffInfoVos){
//            x.setCompId(companyVo.getId());
//        }

        long count = 0;
        count = compStaffService.getStaffInfoVoCount(companyVo);
        //System.out.println(count);

        return DataResult.successByTotalData(staffInfoVos,count);
    }
}

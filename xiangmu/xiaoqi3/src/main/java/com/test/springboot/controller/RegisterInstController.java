package com.test.springboot.controller;

import com.test.springboot.entity.InstStaff;
import com.test.springboot.entity.Institution;
import com.test.springboot.entity.User;
import com.test.springboot.service.InstStaffService;
import com.test.springboot.service.InstitutionService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.InstStaffVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("inst")
public class RegisterInstController {
    @Resource
    private InstitutionService institutionService;
    @Resource
    private InstStaffService instStaffService;

    @RequestMapping("registerInst")
    public DataResult fun(@RequestParam("userId") Integer id, @RequestParam("name") String name, @RequestParam("description") String description){

        //System.out.println(id+"+"+name+"+"+description);

        Institution institution = null;
        DataResult dataResult = null;

        institution = institutionService.queryByRegistrantId(id);
        //System.out.println("=================");
        //System.out.println(institution);


        if(institution != null){
            dataResult.setMessage("用户已经注册了相关机构");
            dataResult.setStat(false);
            return dataResult;
        }
        //System.out.println("========+ffsafdsafsfsa=========");

        institution = new Institution();

        institution.setName(name);
        institution.setDescription(description);
        //System.out.println("========+123=========");
        institution.setLastNum(id);
        institution.setRegistrant(id);
        institution.setManager(id);


        //System.out.println("========++++++++++=========");
        //System.out.println(institution);

        institution = institutionService.insert(institution);

        InstStaff instStaff = new InstStaff();
        instStaff.setInstId(institution.getId());
        instStaff.setNumber(1);
        instStaff.setUserId(id);
        instStaff.setJob(1);

        instStaffService.insert(instStaff);

        institution.setLastNum(2);

        Institution result = institutionService.update(institution);

        return  DataResult.successByData(institution);
    }
}

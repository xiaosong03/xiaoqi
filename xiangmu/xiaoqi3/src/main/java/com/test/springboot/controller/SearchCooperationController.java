package com.test.springboot.controller;

import com.test.springboot.entity.Training;
import com.test.springboot.service.CooperationService;
import com.test.springboot.service.TrainingService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CooperateInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("inst")
public class SearchCooperationController {
    @Resource
    CooperationService cooperationService;
    @RequestMapping("searchCoop")
    public DataResult fun(@RequestParam("instId") Integer id, @RequestParam("searchInfo") String searchInfo){

        List<CooperateInfo> result;

        result = cooperationService.getSpecificCoopertationsByInstId(id,searchInfo);
        long count = 0;

        System.out.println(result.toString());

        return DataResult.successByTotalData(result,count);
    }
}

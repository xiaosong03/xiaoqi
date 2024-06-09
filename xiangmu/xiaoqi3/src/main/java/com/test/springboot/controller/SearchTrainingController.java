package com.test.springboot.controller;

import com.test.springboot.entity.Training;
import com.test.springboot.service.TrainingService;
import com.test.springboot.utils.result.DataResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("inst")
public class SearchTrainingController {
    @Resource
    TrainingService trainingService;
    @RequestMapping("searchTraining")
    public DataResult fun(@RequestParam("instId") Integer id,@RequestParam("searchInfo") String searchInfo){

        List<Training> trainings;

        trainings = trainingService.getSpecificTrainingsByInstId(id,searchInfo);
        long count = 0;

        System.out.println(trainings.toString());

        return DataResult.successByTotalData(trainings,count);
    }
}

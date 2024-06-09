package com.test.springboot.controller;

import com.test.springboot.entity.Training;
import com.test.springboot.service.TrainingService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.TrainVo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("inst")
public class GetTrainingListController {

    @Resource
    TrainingService trainingService;

    @RequestMapping("getTrainingList")
    public DataResult fun(@RequestParam("instId") Integer id){

        List<TrainVo> trainings;

        trainings = trainingService.getAllTrainingsByInstId(id);
        long count = 0;

        return DataResult.successByTotalData(trainings,count);
    }
}

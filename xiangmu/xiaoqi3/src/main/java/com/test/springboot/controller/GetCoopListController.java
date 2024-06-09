package com.test.springboot.controller;

import com.test.springboot.service.CooperationService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CooperateInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("inst")
public class GetCoopListController {

    @Resource
    CooperationService cooperationService;

    @RequestMapping("getCoopList")
    public DataResult fun(Integer instId){
      if(instId==null){
          return new DataResult(true);
      }
        List<CooperateInfo> result;
        result = cooperationService.queryAll(instId);

        long count = 0;

        return DataResult.successByTotalData(result,count);
    }


}

package com.test.springboot.controller;

import com.test.springboot.entity.InstStaff;
import com.test.springboot.entity.Training;
import com.test.springboot.service.InstStaffService;
import com.test.springboot.service.TrainingService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.InstStaffVo;
import com.test.springboot.vo.TrainingVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 培训计划表(Training)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
@RestController
@RequestMapping("training")
public class TrainingController {
    /**
     * 服务对象
     */
    @Resource
    private TrainingService trainingService;
    @Resource
    private InstStaffService instStaffService;
    /**
     * 分页查询
     *
     * @param training 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Training>> queryByPage(Training training, PageRequest pageRequest) {
        return ResponseEntity.ok(this.trainingService.queryByPage(training, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Training> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.trainingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param training 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Training> add(Training training) {
        return ResponseEntity.ok(this.trainingService.insert(training));
    }

    /**
     * 编辑数据
     *
     * @param training 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Training> edit(Training training) {
        return ResponseEntity.ok(this.trainingService.update(training));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.trainingService.deleteById(id));
    }
    @RequestMapping("getallinfo")

    public DataResult getalltraing(@RequestBody TrainingVo trainingVo){
        int page=trainingVo.getPage();
        int limit=trainingVo.getLimit();
        trainingVo.setPage((page-1)*limit);
        List<Training> trainings=trainingService.gettrain(trainingVo);
        List<Training>counts=trainingService.getcount(trainingVo);
        long count=counts.size();
        return DataResult.successByTotalData(trainings,count);
    }
    @RequestMapping("getfuze")
    public  DataResult getfuze(Integer trainingId){
        InstStaffVo instStaffVo=instStaffService.getfu(trainingId);
        return new DataResult(true,"查找成功",instStaffVo);
    }
    @RequestMapping("getzhixin")
    public  DataResult getzhi(Integer trainingId)
    {
        List<InstStaffVo> instStaffVo =instStaffService.getzhi(trainingId);
        return  new DataResult(true,"查找成功",instStaffVo);
    }
    @RequestMapping("getcan")
    public  DataResult getcan(Integer trainingId){
        return new DataResult(true,"查找成功",instStaffService.getcan(trainingId));
    }
    @RequestMapping("addtraing")
    public  DataResult addtrain(Integer userId,String desc,Integer instId,Integer isCoop,String link){

        //boolean m=trainingService.insert1(userId,desc,instId,isCoop);

        //通过userId查询到instStaffId
        InstStaffVo instStaff1=instStaffService.search(userId);
        int m=trainingService.insert2(instStaff1.getId(),desc,instId,isCoop,link);

        if(m!=0){
            return new DataResult(true,"增加成功");
        }else{

        }


        return new DataResult();
    }

}


package com.test.springboot.controller;

import com.test.springboot.entity.InstStaff;
import com.test.springboot.entity.InstStaffTraining;
import com.test.springboot.entity.Training;
import com.test.springboot.entity.UserTraining;
import com.test.springboot.service.InstStaffService;
import com.test.springboot.service.InstStaffTrainingService;
import com.test.springboot.service.TrainingService;
import com.test.springboot.service.UserTrainingService;
import com.test.springboot.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 机构职员_培训计划表(InstStaffTraining)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@RestController
@RequestMapping("instStaffTraining")
public class InstStaffTrainingController {
    /**
     * 服务对象
     */
    @Resource
    private InstStaffTrainingService instStaffTrainingService;
 @Resource
 private InstStaffService instStaffService;
 @Resource
 private TrainingService trainingService;
 @Resource
 private UserTrainingService userTrainingService;
    /**
     * 分页查询
     *
     * @param instStaffTraining 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<InstStaffTraining>> queryByPage(InstStaffTraining instStaffTraining, PageRequest pageRequest) {
        return ResponseEntity.ok(this.instStaffTrainingService.queryByPage(instStaffTraining, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<InstStaffTraining> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.instStaffTrainingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param instStaffTraining 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<InstStaffTraining> add(InstStaffTraining instStaffTraining) {
        return ResponseEntity.ok(this.instStaffTrainingService.insert(instStaffTraining));
    }

    /**
     * 编辑数据
     *
     * @param instStaffTraining 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<InstStaffTraining> edit(InstStaffTraining instStaffTraining) {
        return ResponseEntity.ok(this.instStaffTrainingService.update(instStaffTraining));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.instStaffTrainingService.deleteById(id));
    }
    @RequestMapping("trainging")
    public DataResult Traing(Integer userId, Integer trainingId){
        InstStaff instStaff=instStaffService.search2(userId);
        Training training=trainingService.search1(trainingId);
        int count=instStaffTrainingService.search(instStaff.getId(),trainingId);
        if(count==0){
      instStaffTrainingService.insert1(instStaff.getId(),training.getId());
        return new DataResult(true,"插入成功");}
        else {
            return new DataResult(false,"插入失败");
        }
    }
    @RequestMapping("userTraing")
    public  DataResult userTraing(Integer userId,Integer trainingId){
      int max=userTrainingService.selectmax();
      int n=userTrainingService.select1(userId,trainingId);


        if(n==0){
            int m=userTrainingService.addusertrain1(max+1,userId,trainingId);
        return  new DataResult(true,"增加成功");}
        else {
            return  new DataResult(false,"账号已存在");
        }
    }

}


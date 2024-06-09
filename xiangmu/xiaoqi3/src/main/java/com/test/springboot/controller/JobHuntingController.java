package com.test.springboot.controller;

import com.test.springboot.entity.JobHunting;
import com.test.springboot.service.JobHuntingService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.JobHuntingVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 求职信息表(JobHunting)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@RestController
@RequestMapping("jobHunting")
public class JobHuntingController {
    /**
     * 服务对象
     */
    @Resource
    private JobHuntingService jobHuntingService;

    /**
     * 分页查询
     *
     * @param jobHunting 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<JobHunting>> queryByPage(JobHunting jobHunting, PageRequest pageRequest) {
        return ResponseEntity.ok(this.jobHuntingService.queryByPage(jobHunting, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<JobHunting> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.jobHuntingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param jobHunting 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<JobHunting> add(JobHunting jobHunting) {
        return ResponseEntity.ok(this.jobHuntingService.insert(jobHunting));
    }

    /**
     * 编辑数据
     *
     * @param jobHunting 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<JobHunting> edit(JobHunting jobHunting) {
        return ResponseEntity.ok(this.jobHuntingService.update(jobHunting));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.jobHuntingService.deleteById(id));
    }
//    @RequestMapping("getalljob")
//    public DataResult jobhunt(@RequestBody JobHuntingVo jobHuntingVo){
//        int page=jobHuntingVo.getPage();
//        int limit=jobHuntingVo.getLimit();
//        jobHuntingVo.setPage((page-1)*limit);
//        List<JobHunting> jobbhunt=jobHuntingService.getalljob(jobHuntingVo);
//        List<JobHunting> counts=jobHuntingService.getcount(jobHuntingVo);
//        long count =counts.size();
//        return DataResult.successByTotalData(jobbhunt,count);
//
//    }
}


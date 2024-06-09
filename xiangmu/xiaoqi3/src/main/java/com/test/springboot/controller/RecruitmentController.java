package com.test.springboot.controller;

import com.test.springboot.entity.Recruitment;
import com.test.springboot.service.RecruitmentService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.RecuitmentVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 招聘信息表(Recruitment)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@RestController
@RequestMapping("recruitment")
public class RecruitmentController {
    /**
     * 服务对象
     */
    @Resource
    private RecruitmentService recruitmentService;

    /**
     * 分页查询
     *
     * @param recruitment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Recruitment>> queryByPage(Recruitment recruitment, PageRequest pageRequest) {
        return ResponseEntity.ok(this.recruitmentService.queryByPage(recruitment, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Recruitment> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.recruitmentService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param recruitment 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Recruitment> add(Recruitment recruitment) {
        return ResponseEntity.ok(this.recruitmentService.insert(recruitment));
    }

    /**
     * 编辑数据
     *
     * @param recruitment 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Recruitment> edit(Recruitment recruitment) {
        return ResponseEntity.ok(this.recruitmentService.update(recruitment));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.recruitmentService.deleteById(id));
    }
//    @RequestMapping("getallruitment")
//    public DataResult getallruit(@RequestBody RecuitmentVo recruitmentVo){
//        int page=recruitmentVo.getPage();
//        int limit=recruitmentVo.getLimit();
//        recruitmentVo.setPage((page-1)*limit);
//        List<Recruitment> recruit=recruitmentService.getrecruit(recruitmentVo);
//        List<Recruitment> counts=recruitmentService.getrecount(recruitmentVo);
//        long count =counts.size();
//        return DataResult.successByTotalData(recruit,count);
//    }
}


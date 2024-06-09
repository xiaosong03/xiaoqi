package com.test.springboot.controller;

import com.test.springboot.entity.UserTraining;
import com.test.springboot.service.UserTrainingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户_培训计划表(UserTraining)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
@RestController
@RequestMapping("userTraining")
public class UserTrainingController {
    /**
     * 服务对象
     */
    @Resource
    private UserTrainingService userTrainingService;

    /**
     * 分页查询
     *
     * @param userTraining 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<UserTraining>> queryByPage(UserTraining userTraining, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userTrainingService.queryByPage(userTraining, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<UserTraining> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userTrainingService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param userTraining 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<UserTraining> add(UserTraining userTraining) {
        return ResponseEntity.ok(this.userTrainingService.insert(userTraining));
    }

    /**
     * 编辑数据
     *
     * @param userTraining 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<UserTraining> edit(UserTraining userTraining) {
        return ResponseEntity.ok(this.userTrainingService.update(userTraining));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userTrainingService.deleteById(id));
    }

}


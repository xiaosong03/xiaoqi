package com.test.springboot.controller;

import com.test.springboot.entity.Cooperation;
import com.test.springboot.service.CooperationService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 校企合作表(Cooperation)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@RestController
@RequestMapping("cooperation")
public class CooperationController {
    /**
     * 服务对象
     */
    @Resource
    private CooperationService cooperationService;

    /**
     * 分页查询
     *
     * @param cooperation 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Cooperation>> queryByPage(Cooperation cooperation, PageRequest pageRequest) {
        return ResponseEntity.ok(this.cooperationService.queryByPage(cooperation, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Cooperation> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.cooperationService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param cooperation 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Cooperation> add(@RequestBody Cooperation cooperation) {
        return ResponseEntity.ok(this.cooperationService.insert(cooperation));
    }

    /**
     * 编辑数据
     *
     * @param cooperation 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Cooperation> edit(Cooperation cooperation) {
        return ResponseEntity.ok(this.cooperationService.update(cooperation));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.cooperationService.deleteById(id));
    }

}


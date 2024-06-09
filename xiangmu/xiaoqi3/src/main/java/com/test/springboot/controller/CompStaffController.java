package com.test.springboot.controller;

import com.test.springboot.entity.CompStaff;
import com.test.springboot.service.CompStaffService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 企业职员表(CompStaff)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:58:59
 */
@RestController
@RequestMapping("compStaff")
public class CompStaffController {
    /**
     * 服务对象
     */
    @Resource
    private CompStaffService compStaffService;

    /**
     * 分页查询
     *
     * @param compStaff 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<CompStaff>> queryByPage(CompStaff compStaff, PageRequest pageRequest) {
        return ResponseEntity.ok(this.compStaffService.queryByPage(compStaff, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<CompStaff> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.compStaffService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param compStaff 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<CompStaff> add(CompStaff compStaff) {
        return ResponseEntity.ok(this.compStaffService.insert(compStaff));
    }

    /**
     * 编辑数据
     *
     * @param compStaff 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<CompStaff> edit(CompStaff compStaff) {
        return ResponseEntity.ok(this.compStaffService.update(compStaff));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.compStaffService.deleteById(id));
    }

}


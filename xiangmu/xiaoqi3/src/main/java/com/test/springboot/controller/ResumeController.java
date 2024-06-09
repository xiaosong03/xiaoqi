package com.test.springboot.controller;

import com.test.springboot.entity.Resume;
import com.test.springboot.service.ResumeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 简历表(Resume)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@RestController
@RequestMapping("resume")
public class ResumeController {
    /**
     * 服务对象
     */
    @Resource
    private ResumeService resumeService;

    /**
     * 分页查询
     *
     * @param resume 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Resume>> queryByPage(Resume resume, PageRequest pageRequest) {
        return ResponseEntity.ok(this.resumeService.queryByPage(resume, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Resume> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.resumeService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param resume 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Resume> add(Resume resume) {
        return ResponseEntity.ok(this.resumeService.insert(resume));
    }

    /**
     * 编辑数据
     *
     * @param resume 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Resume> edit(Resume resume) {
        return ResponseEntity.ok(this.resumeService.update(resume));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.resumeService.deleteById(id));
    }

}


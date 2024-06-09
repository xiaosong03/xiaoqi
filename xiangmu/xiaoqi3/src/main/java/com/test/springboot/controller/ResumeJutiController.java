package com.test.springboot.controller;

import com.test.springboot.entity.Resume;
import com.test.springboot.entity.ResumeJuti;
import com.test.springboot.service.ResumeJutiService;
import com.test.springboot.service.ResumeService;
import com.test.springboot.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (ResumeJuti)表控制层
 *
 * @author makejava
 * @since 2024-06-03 10:23:07
 */
@RestController
@RequestMapping("resumeJuti")
public class ResumeJutiController {
    /**
     * 服务对象
     */
    @Resource
    private ResumeJutiService resumeJutiService;

    @Resource
    private ResumeService resumeService;

    /**
     * 分页查询
     *
     * @param resumeJuti 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<ResumeJuti>> queryByPage(ResumeJuti resumeJuti, PageRequest pageRequest) {
        return ResponseEntity.ok(this.resumeJutiService.queryByPage(resumeJuti, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @PostMapping("getinfo")
    public DataResult queryById(@RequestBody Resume resume) {
        ResumeJuti resumeJuti1=resumeJutiService.queryById(resume.getId());
        return new DataResult(true,"查找成功",resumeJuti1);
    }

    /**
     * 新增数据
     *
     * @param resumeJuti 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<ResumeJuti> add(ResumeJuti resumeJuti) {
        return ResponseEntity.ok(this.resumeJutiService.insert(resumeJuti));
    }

    /**
     * 编辑数据
     *
     * @param resumeJuti 实体
     * @return 编辑结果
     */
   @PostMapping("setinfo")
    public DataResult edit(@RequestBody ResumeJuti resumeJuti) {
       int res_id=resumeJuti.getResId();
       String des=resumeJuti.getDescription();
       Resume resume=resumeService.queryById(res_id);
       resume.setDescription(des);
       resumeService.update(resume);

      if(resumeJutiService.queryById1(resumeJuti.getResId()))

      {  return new DataResult(true,"修改成功",this.resumeJutiService.update(resumeJuti));}
    return new DataResult(true,"添加成功",this.resumeJutiService.insert(resumeJuti));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.resumeJutiService.deleteById(id));
    }

}


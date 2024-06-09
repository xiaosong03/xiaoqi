package com.test.springboot.controller;

import com.test.springboot.entity.Institution;
import com.test.springboot.entity.JobHunting;
import com.test.springboot.entity.User;
import com.test.springboot.service.InstitutionService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.InstitutionVo;
import com.test.springboot.vo.JobHuntingVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 培训机构表(Institution)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@RestController
@RequestMapping("institution")
public class InstitutionController {
    /**
     * 服务对象
     */
    @Resource
    private InstitutionService institutionService;

    /**
     * 分页查询
     *
     * @param institution 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Institution>> queryByPage(Institution institution, PageRequest pageRequest) {
        return ResponseEntity.ok(this.institutionService.queryByPage(institution, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Institution> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.institutionService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param institution 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Institution> add(Institution institution) {
        return ResponseEntity.ok(this.institutionService.insert(institution));
    }

    /**
     * 编辑数据
     *
     * @param institution 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Institution> edit(Institution institution) {
        return ResponseEntity.ok(this.institutionService.update(institution));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.institutionService.deleteById(id));
    }
//    @RequestMapping("getallinstitution")
//    public DataResult institution(@RequestBody InstitutionVo jobHuntingVo){
//        int page=jobHuntingVo.getPage();
//        int limit=jobHuntingVo.getLimit();
//        jobHuntingVo.setPage((page-1)*limit);
//        List<Institution> jobbhunt=institutionService.getallinstitution(jobHuntingVo);
//        List<Institution> counts=institutionService.getcount(jobHuntingVo);
//        long count =counts.size();
//        return DataResult.successByTotalData(jobbhunt,count);
//
//    }
    @RequestMapping("allInstStaffs")
    public DataResult institution(@PathVariable ("id") Integer id){

        return  null;
    }
}


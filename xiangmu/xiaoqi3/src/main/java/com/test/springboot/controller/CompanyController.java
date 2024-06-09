package com.test.springboot.controller;

import com.test.springboot.entity.Company;
import com.test.springboot.entity.Recruitment;
import com.test.springboot.service.CompanyService;
import com.test.springboot.service.RecruitmentService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CompanyVo;
import com.test.springboot.vo.RecuitmentVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公司企业表(Company)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@RestController
@RequestMapping("cmy")
public class CompanyController {
    /**
     * 服务对象
     */
    @Resource
    private CompanyService companyService;
    @Resource
    private RecruitmentService recruitmentService;

    /**
     * 分页查询
     *
     * @param company 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Company>> queryByPage(Company company, PageRequest pageRequest) {
        return ResponseEntity.ok(this.companyService.queryByPage(company, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Company> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.companyService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param company 实体
     * @return 新增结果
     */
    @RequestMapping("addnew")
    public DataResult add(@RequestBody Company company) {
        Company company1=this.companyService.insert(company);
        return DataResult.successByData(company1);
    }

    /**
     * 编辑数据
     *
     * @param company 实体
     * @return 编辑结果
     */
   @RequestMapping("edit")
    public DataResult edit( @RequestBody  Company company) {
       Company company1=companyService.update(company);
        return DataResult.successByData(company1);
    }

    /**
     * 删除数据
     *
     * @param  company
     * @return 删除是否成功
     */
    @DeleteMapping("delete")
    public ResponseEntity<Boolean> deleteById(@RequestBody Company company) {
        int id=company.getId();
        return ResponseEntity.ok(this.companyService.deleteById(id));
    }
   @GetMapping("fabuzhao")
    public DataResult getrecruit( @RequestBody  Recruitment recruitment){
        Recruitment recruitment1=recruitmentService.insert(recruitment);

        return DataResult.successByData(recruitment1);
   }

    @RequestMapping("/getRsume")
    public DataResult getallruit(@RequestBody RecuitmentVo recruitmentVo){
        System.out.println("-------------------------------");
        System.out.println("?????????????????????????????????????????????????");
        System.out.println(recruitmentVo.toString());
        int page1 =recruitmentVo.getPage();
        int limit=recruitmentVo.getLimit();
        recruitmentVo.setPage((page1-1)*limit);
        List<RecuitmentVo> recruit=recruitmentService.getrecruit2(recruitmentVo);
        List<Recruitment> counts=recruitmentService.getrecount(recruitmentVo);
        long count =counts.size();
        return DataResult.successByTotalData(recruit,count);
    }
//    @RequestMapping("deleteEmploy1")
//    public ResponseEntity<Boolean> deleteById(@RequestBody Recruitment recruitment) {
//        int id=recruitment.getId();
//        return ResponseEntity.ok(this.recruitmentService.deleteById(id));
//    }
    @RequestMapping("deleteEmploy")
    public  DataResult deleteById(@RequestBody Recruitment recruitment){
        Recruitment recruitment1=recruitmentService.deleteById1(recruitment);
        return new DataResult(true,"删除成功",recruitment1);

    }
    @RequestMapping("updateEmploy")
    public DataResult edit(@RequestBody Recruitment recruitment) {
        Recruitment recruitment1=recruitmentService.update(recruitment);
        return new DataResult(true,"更新成功",recruitment1);
    }
    @RequestMapping("addEmploy")
    public DataResult add(@RequestBody Recruitment recruitment) {
       Recruitment recruitment2=this.recruitmentService.insert(recruitment);
        return new DataResult(true,"添加成功",recruitment2);
    }
}


package com.test.springboot.controller;

import com.test.springboot.entity.*;
import com.test.springboot.service.*;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.InstStaffVo;
import com.test.springboot.vo.InstitutionVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 机构职员表(InstStaff)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@RestController
@RequestMapping("inst")
public class InstStaffController {
    /**
     * 服务对象
     */
    @Resource
    private InstStaffService instStaffService;
    @Resource
    private InstitutionService institutionService;
    @Resource
    private UserService userService;
    @Resource
    private CooperationService cooperationService;

    @Resource
    private CompStaffService compStaffService;
    /**
     * 分页查询
     *
     * @param instStaff 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<InstStaff>> queryByPage(InstStaff instStaff, PageRequest pageRequest) {
        return ResponseEntity.ok(this.instStaffService.queryByPage(instStaff, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<InstStaff> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.instStaffService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param instStaff 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<InstStaff> add(InstStaff instStaff) {
        return ResponseEntity.ok(this.instStaffService.insert(instStaff));
    }

    /**
     * 编辑数据
     *
     * @param instStaff 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<InstStaff> edit(InstStaff instStaff) {
        return ResponseEntity.ok(this.instStaffService.update(instStaff));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.instStaffService.deleteById(id));
    }
    @RequestMapping("myOrganization")
    public DataResult orgnization(Integer userId){
        System.out.println(userId);
       InstStaffVo instStaff=instStaffService.search(userId);
        System.out.println(instStaff);
        if(null==instStaff){
            return new DataResult(false,"查找失败",null);
        }

        InstitutionVo institution=institutionService.search(instStaff.getInstId());
        return  new DataResult(true,"查找成功",institution);

    }
    @RequestMapping("myInstStaff")
    public DataResult orgnization1(Integer userId){
        InstStaffVo instStaff1=instStaffService.search(userId);

        return  new DataResult(true,"查找成功",instStaff1);
    }
    @RequestMapping("allInstStaffs")
    public DataResult institution( Integer instId){
        List<InstStaffVo> institutionVos=instStaffService.search1(instId);

        return  new DataResult(true,"查找成功",institutionVos);
    }
    @RequestMapping("deleteinst")
    public  DataResult delete12(Integer userId){
        System.out.println(userId);

        boolean mark = instStaffService.deleteByUserId(userId);

        if(mark == true){
            return new DataResult(true,"删除成功",instStaffService.deleteByUserId(userId));
        }else{
            return new DataResult(true,"删除失败");
        }

    }
    @RequestMapping("addCoop")
    public  DataResult addCoop(String desc,String compName,Integer userId,String compChargeName){
        Cooperation cooperation = new Cooperation();
        cooperation.setDescription(desc);//---------------------------1

        //get 机构专员id
        InstStaffVo instStaffVo = instStaffService.search(userId);

        //compChargeName  ------get user information
        User user = userService.queryByname(compChargeName);

        //comp staff
        CompStaff compStaff = compStaffService.queryByUser(user);

        ////////////////////////////////////////////////////
        cooperation.setInstCharge(instStaffVo.getId());
        //cooperation.setCompStaffIdCharge(user.getId());
        cooperation.setCompStaffIdCharge(compStaff.getCompId());
        cooperation.setCompStaffNumberCharge(compStaff.getNumber());


        Cooperation result =  cooperationService.insert(cooperation);
        if(result != null)
            return  new DataResult(true,"新建成功",result);
        return  new DataResult(false,"新建失败",result);
    }
}


package com.test.springboot.controller;

import com.test.springboot.dao.UserDao;
import com.test.springboot.entity.*;
import com.test.springboot.service.*;
import com.test.springboot.utils.result.DataResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.MessageDigest;

/**
 * 用户表(User)表控制层
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;
     @Resource
     private ResumeService resumeService;
     @Resource
     private CompStaffService compStaffService;
     @Resource
     private CompanyService companyService;
     @Resource
     private TrainingService trainingService;
    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PostMapping("UpdateInfo")
    public DataResult edit(@RequestBody User user) {
        String md=user.getPassword();
        User temp = userService.queryById(user.getId());
        if(temp !=null && !temp.getPassword().equals(user.getPassword())){
            // System.out.println(md);
            md=encode(md);
            //  System.out.println(md1);
        }
        user.setPassword(md);
        User user1=userService.update(user);
        return new DataResult(true,"修改成功",user1);
    }

    @RequestMapping("updatePasw")
    public DataResult xiugai(@RequestBody  User user){
        String md=user.getPassword();
             md=encode(md);
            //  System.out.println(md1);
        user.setPassword(md);
        User user2=userService.xiugai1(user);
        if(user2 == null){
            return new DataResult<>(true,"账号或者身份证号码不正确");
        }
        return new DataResult(true,"修改成功",user2);
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }
   @RequestMapping("getResume")
    public  DataResult selectjian(@RequestBody User user){

//       System.out.println(user.toString());
//       System.out.println("-------------------------------");
        Resume resume1=resumeService.select1(user.getId());
        return new DataResult(true,"检查成功",resume1);
   }
   @RequestMapping("updateResum")
    public  DataResult editjian(@RequestBody Resume resume){

        Resume resume1=resumeService.updatejian(resume);

        return new DataResult(true,"修改成功",resume1);
   }
   @RequestMapping("showcompany")
    public  DataResult showing(@RequestBody User user){
       CompStaff compStaff=compStaffService.getCompany(user.getId());
       Company  company=companyService.showcomp(compStaff.getCompId());

        return  new DataResult(true,"展示成功",company);
   }
   @RequestMapping("getTrainingsByUserId")
    public  DataResult getinst(Integer userId){

        return  new DataResult(true,"展示成功",trainingService.train(userId));
   }
    public String encode(String str) {
        byte[] result = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes("UTF-8"));
            result = md.digest();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return parseByte2HexStr(result);
    }

    /**
     * 将二进制转换成十六进制
     *
     * @param buf
     * @return
     */
    private String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }
}


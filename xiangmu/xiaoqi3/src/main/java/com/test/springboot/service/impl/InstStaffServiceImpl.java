package com.test.springboot.service.impl;

import com.test.springboot.entity.InstStaff;
import com.test.springboot.dao.InstStaffDao;
import com.test.springboot.service.InstStaffService;
import com.test.springboot.vo.InstStaffVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 机构职员表(InstStaff)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@Service("instStaffService")
public class InstStaffServiceImpl implements InstStaffService {
    @Resource
    private InstStaffDao instStaffDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public InstStaff queryById(Integer id) {
        return this.instStaffDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param instStaff 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<InstStaff> queryByPage(InstStaff instStaff, PageRequest pageRequest) {
        long total = this.instStaffDao.count(instStaff);
        return new PageImpl<>(this.instStaffDao.queryAllByLimit(instStaff, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param instStaff 实例对象
     * @return 实例对象
     */
    @Override
    public InstStaff insert(InstStaff instStaff) {
        this.instStaffDao.insert(instStaff);
        return instStaff;
    }

    /**
     * 修改数据
     *
     * @param instStaff 实例对象
     * @return 实例对象
     */
    @Override
    public InstStaff update(InstStaff instStaff) {
        this.instStaffDao.update(instStaff);
        return this.queryById(instStaff.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.instStaffDao.deleteById(id) > 0;
    }

    @Override
    public InstStaffVo search(int userId) {
        InstStaffVo instStaffVo =instStaffDao.search(userId);
        if(null == instStaffVo){
            return null;
        }
        if(instStaffVo.getJob1()==1){
            instStaffVo.setJob("boss");

        }else{
            instStaffVo.setJob("emp");
        }
        return instStaffVo;
    }

    @Override
    public List<InstStaffVo> search1(int initid) {
        List<InstStaffVo> instStaffVo =instStaffDao.search1(initid);
        for (InstStaffVo staffVo : instStaffVo) {
            if(1==staffVo.getJob1()){
                staffVo.setJob("Boss");
            }else {
                staffVo.setJob("emp");
            }

        }
        return instStaffVo;
    }

    @Override
    public InstStaff search2(Integer id) {

        return instStaffDao.search2(id);
    }

    @Override
    public boolean deleteByUserId(Integer userId) {
        return this.instStaffDao.deleteById1(userId) > 0;
    }

    @Override
    public InstStaffVo getfu(int traingId) {
        InstStaffVo instStaffVo=instStaffDao.getfu(traingId);
        if(1==instStaffVo.getJob1()){
            instStaffVo.setJob("boss");
        }else{
            instStaffVo.setJob("emp");
        }
        return instStaffVo;
    }

    @Override
    public List<InstStaffVo> getzhi(int trainId) {
        List<InstStaffVo>list=instStaffDao.getzhi(trainId);
        for (InstStaffVo instStaffVo : list) {
            if(1==instStaffVo.getJob1()){
                instStaffVo.setJob("boss");
            }else{
                instStaffVo.setJob("emp");
            }
        }

        return  list;
    }

    @Override
    public List<InstStaffVo> getcan(int trianingId) {
        return instStaffDao.getcan(trianingId);
    }


}

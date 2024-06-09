package com.test.springboot.service.impl;

import com.test.springboot.entity.CompStaff;
import com.test.springboot.dao.CompStaffDao;
import com.test.springboot.entity.User;
import com.test.springboot.service.CompStaffService;
import com.test.springboot.vo.CompanyResumeVo;
import com.test.springboot.vo.CompanyVo;
import com.test.springboot.vo.StaffInfoVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 企业职员表(CompStaff)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:01
 */
@Service("compStaffService")
public class CompStaffServiceImpl implements CompStaffService {
    @Resource
    private CompStaffDao compStaffDao;

    /**
     * 通过ID查询单条数据
     *
     * @param compId 主键
     * @return 实例对象
     */
    @Override
    public CompStaff queryById(Integer compId) {
        return this.compStaffDao.queryById(compId);
    }

    /**
     * 分页查询
     *
     * @param compStaff 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<CompStaff> queryByPage(CompStaff compStaff, PageRequest pageRequest) {
        long total = this.compStaffDao.count(compStaff);
        return new PageImpl<>(this.compStaffDao.queryAllByLimit(compStaff, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param compStaff 实例对象
     * @return 实例对象
     */
    @Override
    public CompStaff insert(CompStaff compStaff) {
        this.compStaffDao.insert(compStaff);
        return compStaff;
    }

    /**
     * 修改数据
     *
     * @param compStaff 实例对象
     * @return 实例对象
     */
    @Override
    public CompStaff update(CompStaff compStaff) {
        this.compStaffDao.update(compStaff);
        return this.queryById(compStaff.getCompId());
    }

    /**
     * 通过主键删除数据
     *
     * @param compId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer compId) {
        return this.compStaffDao.deleteById(compId) > 0;
    }

    @Override
    public CompStaff getCompany(int userid) {
        return compStaffDao.getCompany(userid);
    }

    @Override
    public Object isStaff(User user) {
        return compStaffDao.isStaff(user);
    }

    @Override
    public int queryByUserId(User user) {
        return compStaffDao.queryByUserId(user);
    }

    @Override
    public List<StaffInfoVo> getStaffInfoVos(CompanyVo companyVo) {
        return this.compStaffDao.getStaffInfoVos(companyVo);
    }

    @Override
    public long getStaffInfoVoCount(CompanyVo companyVo) {
        return this.compStaffDao.getStaffInfoVoCount(companyVo);
    }

    @Override
    public int deleteByUserId(StaffInfoVo staffInfoVo) {
        return this.compStaffDao.deleteByUserId(staffInfoVo);
    }

    @Override
    public List<StaffInfoVo> getStaffInfoVos1(CompanyVo companyVo) {
        return this.compStaffDao.getStaffInfoVos1(companyVo);
    }

    @Override
    public List<StaffInfoVo> getStaffInfoVos2(CompanyVo companyVo) {
        return this.compStaffDao.getStaffInfoVos2(companyVo);
    }

    @Override
    public List<StaffInfoVo> getStaffInfoVos3(CompanyVo companyVo) {
        return this.compStaffDao.getStaffInfoVos3(companyVo);
    }

    @Override
    public void insert1(CompanyResumeVo companyResumeVo) {
        this.compStaffDao.insert1(companyResumeVo);
    }

    @Override
    public int selectCompanyMaxIdByComId(int compId) {
        return this.compStaffDao.selectCompanyMaxIdByComId(compId);
    }

    @Override
    public void insert2(CompanyResumeVo companyResumeVo, int maxId) {
         this.compStaffDao.insert2(companyResumeVo,maxId);
    }

    @Override
    public CompStaff queryByUser(User user) {
        return this.compStaffDao.queryByUser(user);
    }
}

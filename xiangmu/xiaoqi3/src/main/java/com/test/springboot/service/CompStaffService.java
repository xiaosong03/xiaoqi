package com.test.springboot.service;

import com.test.springboot.entity.CompStaff;
import com.test.springboot.entity.User;
import com.test.springboot.vo.CompanyResumeVo;
import com.test.springboot.vo.CompanyVo;
import com.test.springboot.vo.StaffInfoVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 企业职员表(CompStaff)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:01
 */
public interface CompStaffService {

    /**
     * 通过ID查询单条数据
     *
     * @param compId 主键
     * @return 实例对象
     */
    CompStaff queryById(Integer compId);

    /**
     * 分页查询
     *
     * @param compStaff 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<CompStaff> queryByPage(CompStaff compStaff, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param compStaff 实例对象
     * @return 实例对象
     */
    CompStaff insert(CompStaff compStaff);

    /**
     * 修改数据
     *
     * @param compStaff 实例对象
     * @return 实例对象
     */
    CompStaff update(CompStaff compStaff);

    /**
     * 通过主键删除数据
     *
     * @param compId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer compId);
    CompStaff getCompany(int userid);

    Object isStaff(User user);

    int queryByUserId(User user);

    List<StaffInfoVo> getStaffInfoVos(CompanyVo companyVo);

    long getStaffInfoVoCount(CompanyVo companyVo);

    int deleteByUserId(StaffInfoVo staffInfoVo);

    List<StaffInfoVo> getStaffInfoVos1(CompanyVo companyVo);

    List<StaffInfoVo> getStaffInfoVos2(CompanyVo companyVo);

    List<StaffInfoVo> getStaffInfoVos3(CompanyVo companyVo);

    void insert1(CompanyResumeVo companyResumeVo);

    int selectCompanyMaxIdByComId(int compId);

    void insert2(CompanyResumeVo companyResumeVo, int maxId);

    CompStaff queryByUser(User user);
}

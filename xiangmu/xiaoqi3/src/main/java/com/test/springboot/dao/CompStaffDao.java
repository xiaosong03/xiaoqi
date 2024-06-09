package com.test.springboot.dao;

import com.test.springboot.entity.CompStaff;
import com.test.springboot.entity.User;
import com.test.springboot.vo.CompanyResumeVo;
import com.test.springboot.vo.CompanyVo;
import com.test.springboot.vo.StaffInfoVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 企业职员表(CompStaff)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:58:59
 */
public interface CompStaffDao {

    /**
     * 通过ID查询单条数据
     *
     * @param compId 主键
     * @return 实例对象
     */
    CompStaff queryById(Integer compId);

    /**
     * 查询指定行数据
     *
     * @param compStaff 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<CompStaff> queryAllByLimit(CompStaff compStaff, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param compStaff 查询条件
     * @return 总行数
     */
    long count(CompStaff compStaff);

    /**
     * 新增数据
     *
     * @param compStaff 实例对象
     * @return 影响行数
     */
    int insert(CompStaff compStaff);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<CompStaff> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<CompStaff> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<CompStaff> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<CompStaff> entities);

    /**
     * 修改数据
     *
     * @param compStaff 实例对象
     * @return 影响行数
     */
    int update(CompStaff compStaff);

    /**
     * 通过主键删除数据
     *
     * @param compId 主键
     * @return 影响行数
     */
    int deleteById(Integer compId);
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


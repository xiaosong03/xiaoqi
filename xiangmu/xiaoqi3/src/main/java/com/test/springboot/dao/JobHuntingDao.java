package com.test.springboot.dao;

import com.test.springboot.entity.JobHunting;
import com.test.springboot.vo.CompanyResumeVo;
import com.test.springboot.vo.JobHuntingVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 求职信息表(JobHunting)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface JobHuntingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JobHunting queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param jobHunting 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<JobHunting> queryAllByLimit(JobHunting jobHunting, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param jobHunting 查询条件
     * @return 总行数
     */
    long count(JobHunting jobHunting);

    /**
     * 新增数据
     *
     * @param jobHunting 实例对象
     * @return 影响行数
     */
    int insert(JobHunting jobHunting);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<JobHunting> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<JobHunting> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<JobHunting> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<JobHunting> entities);

    /**
     * 修改数据
     *
     * @param jobHunting 实例对象
     * @return 影响行数
     */
    int update(JobHunting jobHunting);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    List<JobHuntingVo> getalljob(JobHuntingVo jobHuntingVo);
    List<JobHunting> getcount(JobHuntingVo jobHuntingVo);
    List<JobHuntingVo> getjob(String desc);
    List<JobHunting> getcount1(String desc);

    List<CompanyResumeVo> queryByCompanyId(Integer id);
    Object searchhot(Integer id,Integer id1);



    void updatehot(Integer compId1);

    void updatehot1(Integer compId1);
}


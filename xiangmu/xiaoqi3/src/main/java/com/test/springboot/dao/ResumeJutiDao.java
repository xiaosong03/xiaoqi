package com.test.springboot.dao;

import com.test.springboot.entity.ResumeJuti;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (ResumeJuti)表数据库访问层
 *
 * @author makejava
 * @since 2024-06-03 10:23:07
 */
public interface ResumeJutiDao {

    /**
     * 通过ID查询单条数据
     *
     * @param resId 主键
     * @return 实例对象
     */
    ResumeJuti queryById(Integer resId);

    /**
     * 查询指定行数据
     *
     * @param resumeJuti 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<ResumeJuti> queryAllByLimit(ResumeJuti resumeJuti, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param resumeJuti 查询条件
     * @return 总行数
     */
    long count(ResumeJuti resumeJuti);

    /**
     * 新增数据
     *
     * @param resumeJuti 实例对象
     * @return 影响行数
     */
    int insert(ResumeJuti resumeJuti);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<ResumeJuti> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<ResumeJuti> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<ResumeJuti> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<ResumeJuti> entities);

    /**
     * 修改数据
     *
     * @param resumeJuti 实例对象
     * @return 影响行数
     */
    int update(ResumeJuti resumeJuti);

    /**
     * 通过主键删除数据
     *
     * @param resId 主键
     * @return 影响行数
     */
    int deleteById(Integer resId);

}


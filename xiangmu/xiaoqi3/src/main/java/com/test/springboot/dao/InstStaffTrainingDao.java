package com.test.springboot.dao;

import com.test.springboot.entity.InstStaffTraining;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 机构职员_培训计划表(InstStaffTraining)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface InstStaffTrainingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InstStaffTraining queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param instStaffTraining 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<InstStaffTraining> queryAllByLimit(InstStaffTraining instStaffTraining, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param instStaffTraining 查询条件
     * @return 总行数
     */
    long count(InstStaffTraining instStaffTraining);

    /**
     * 新增数据
     *
     * @param instStaffTraining 实例对象
     * @return 影响行数
     */
    int insert(InstStaffTraining instStaffTraining);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<InstStaffTraining> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<InstStaffTraining> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<InstStaffTraining> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<InstStaffTraining> entities);

    /**
     * 修改数据
     *
     * @param instStaffTraining 实例对象
     * @return 影响行数
     */
    int update(InstStaffTraining instStaffTraining);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    int insert1(Integer id,Integer traningId);
    int search(Integer instStaffId, Integer trainingId);
}


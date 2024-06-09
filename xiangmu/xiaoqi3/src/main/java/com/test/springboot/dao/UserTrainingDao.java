package com.test.springboot.dao;

import com.test.springboot.entity.UserTraining;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 用户_培训计划表(UserTraining)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
public interface UserTrainingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserTraining queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param userTraining 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<UserTraining> queryAllByLimit(UserTraining userTraining, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param userTraining 查询条件
     * @return 总行数
     */
    long count(UserTraining userTraining);

    /**
     * 新增数据
     *
     * @param userTraining 实例对象
     * @return 影响行数
     */
    int insert(UserTraining userTraining);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserTraining> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserTraining> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<UserTraining> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserTraining> entities);

    /**
     * 修改数据
     *
     * @param userTraining 实例对象
     * @return 影响行数
     */
    int update(UserTraining userTraining);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
   int insertustrain(int id3,int id2,int id1);
   int selectmaxId();
   int select1(int id1,int id2);

}


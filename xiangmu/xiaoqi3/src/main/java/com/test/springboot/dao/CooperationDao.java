package com.test.springboot.dao;

import com.test.springboot.entity.Cooperation;
import com.test.springboot.entity.Training;
import com.test.springboot.vo.CooperateInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 校企合作表(Cooperation)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface CooperationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cooperation queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param cooperation 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Cooperation> queryAllByLimit(Cooperation cooperation, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param cooperation 查询条件
     * @return 总行数
     */
    long count(Cooperation cooperation);

    /**
     * 新增数据
     *
     * @param cooperation 实例对象
     * @return 影响行数
     */
    int insert(Cooperation cooperation);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cooperation> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Cooperation> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Cooperation> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Cooperation> entities);

    /**
     * 修改数据
     *
     * @param cooperation 实例对象
     * @return 影响行数
     */
    int update(Cooperation cooperation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<CooperateInfo> queryAll(Integer instId);

    List<CooperateInfo> getSpecificCoopertationsByInstId(Integer id, String searchInfo);

}


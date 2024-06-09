package com.test.springboot.dao;

import com.test.springboot.entity.Training;
import com.test.springboot.vo.TrainVo;
import com.test.springboot.vo.TrainingVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 培训计划表(Training)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
public interface TrainingDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Training queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param training 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Training> queryAllByLimit(Training training, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param training 查询条件
     * @return 总行数
     */
    long count(Training training);

    /**
     * 新增数据
     *
     * @param training 实例对象
     * @return 影响行数
     */
    int insert(Training training);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Training> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Training> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Training> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Training> entities);

    /**
     * 修改数据
     *
     * @param training 实例对象
     * @return 影响行数
     */
    int update(Training training);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    List<Training>gettrain(TrainingVo trainingVo);
    List<Training>getcount(TrainingVo trainingVo);

    List<TrainVo> getAllTrainingsByInstId(Integer id);

    List<Training> getSpecificTrainingsByInstId(Integer id, String searchInfo);
    Training search1(int id);
    int insert1(Integer userId,String desc,Integer instId,Integer isCoop);

    int insert2(Integer userId, String desc, Integer instId, Integer isCoop,String link);
    List<TrainVo> train(int userId);
}


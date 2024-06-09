package com.test.springboot.service;

import com.test.springboot.entity.Training;
import com.test.springboot.vo.TrainVo;
import com.test.springboot.vo.TrainingVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 培训计划表(Training)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
public interface TrainingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Training queryById(Integer id);

    /**
     * 分页查询
     *
     * @param training 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Training> queryByPage(Training training, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param training 实例对象
     * @return 实例对象
     */
    Training insert(Training training);

    /**
     * 修改数据
     *
     * @param training 实例对象
     * @return 实例对象
     */
    Training update(Training training);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    List<Training> gettrain(TrainingVo trainingVo);
    List<Training> getcount(TrainingVo trainingVo);

    List<TrainVo> getAllTrainingsByInstId(Integer id);

    List<Training> getSpecificTrainingsByInstId(Integer id, String searchInfo);
    Training search1(int id);
    boolean insert1(Integer userId,String desc,Integer instId,Integer isCoop);

    int insert2(Integer userId, String desc, Integer instId, Integer isCoop,String link);
    List<TrainVo> train(int userId);
}

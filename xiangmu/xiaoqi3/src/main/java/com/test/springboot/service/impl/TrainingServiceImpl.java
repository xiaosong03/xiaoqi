package com.test.springboot.service.impl;

import com.test.springboot.entity.Training;
import com.test.springboot.dao.TrainingDao;
import com.test.springboot.service.TrainingService;
import com.test.springboot.vo.TrainVo;
import com.test.springboot.vo.TrainingVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 培训计划表(Training)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
@Service("trainingService")
public class TrainingServiceImpl implements TrainingService {
    @Resource
    private TrainingDao trainingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Training queryById(Integer id) {
        return this.trainingDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param training 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Training> queryByPage(Training training, PageRequest pageRequest) {
        long total = this.trainingDao.count(training);
        return new PageImpl<>(this.trainingDao.queryAllByLimit(training, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param training 实例对象
     * @return 实例对象
     */
    @Override
    public Training insert(Training training) {
        this.trainingDao.insert(training);
        return training;
    }

    /**
     * 修改数据
     *
     * @param training 实例对象
     * @return 实例对象
     */
    @Override
    public Training update(Training training) {
        this.trainingDao.update(training);
        return this.queryById(training.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.trainingDao.deleteById(id) > 0;
    }
    @Override
    public List<Training> gettrain(TrainingVo trainingVo) {
        return  trainingDao.gettrain(trainingVo);
    }

    @Override
    public List<Training> getcount(TrainingVo trainingVo) {
        return  trainingDao.getcount(trainingVo);
    }

    @Override
    public List<TrainVo> getAllTrainingsByInstId(Integer id) {
        List<TrainVo>trainVos =trainingDao.getAllTrainingsByInstId(id);
        for (TrainVo trainVo : trainVos) {
            if(trainVo.getIsInCoop()==1){
                trainVo.setIsInCoop1("是");
            }else {
                trainVo.setIsInCoop1("否");
            }
        }
        return trainVos;
    }


    @Override
    public List<Training> getSpecificTrainingsByInstId(Integer id, String searchInfo) {
        return  trainingDao.getSpecificTrainingsByInstId(id,searchInfo);
    }

    @Override
    public Training search1(int id) {
        if(null==trainingDao.search1(id)){
            return  null;
        }
        return trainingDao.search1(id);
    }

    @Override
    public boolean insert1(Integer userId, String desc, Integer instId, Integer isCoop) {
       int n= this.trainingDao.insert1(userId,desc,instId,isCoop);
        return (n!=0);
    }

    @Override
    public int insert2(Integer userId, String desc, Integer instId, Integer isCoop,String link) {
        return this.trainingDao.insert2(userId,desc,instId,isCoop,link);
    }

    @Override
    public List<TrainVo> train(int userId) {
        List<TrainVo> trainVos = trainingDao.train(userId);
        for (TrainVo trainVo : trainVos) {
            if(1==trainVo.getIsInCoop()){
                trainVo.setIsInCoop1("是");
            }else {
                trainVo.setIsInCoop1("否");
            }

        }
        System.out.println(trainVos);
        return trainVos;
    }
}

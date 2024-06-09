package com.test.springboot.service.impl;

import com.test.springboot.entity.InstStaffTraining;
import com.test.springboot.dao.InstStaffTrainingDao;
import com.test.springboot.service.InstStaffTrainingService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 机构职员_培训计划表(InstStaffTraining)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@Service("instStaffTrainingService")
public class InstStaffTrainingServiceImpl implements InstStaffTrainingService {
    @Resource
    private InstStaffTrainingDao instStaffTrainingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public InstStaffTraining queryById(Integer id) {
        return this.instStaffTrainingDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param instStaffTraining 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<InstStaffTraining> queryByPage(InstStaffTraining instStaffTraining, PageRequest pageRequest) {
        long total = this.instStaffTrainingDao.count(instStaffTraining);
        return new PageImpl<>(this.instStaffTrainingDao.queryAllByLimit(instStaffTraining, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param instStaffTraining 实例对象
     * @return 实例对象
     */
    @Override
    public InstStaffTraining insert(InstStaffTraining instStaffTraining) {
        this.instStaffTrainingDao.insert(instStaffTraining);
        return instStaffTraining;
    }

    /**
     * 修改数据
     *
     * @param instStaffTraining 实例对象
     * @return 实例对象
     */
    @Override
    public InstStaffTraining update(InstStaffTraining instStaffTraining) {
        this.instStaffTrainingDao.update(instStaffTraining);
        return this.queryById(instStaffTraining.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.instStaffTrainingDao.deleteById(id) > 0;
    }

    @Override
    public boolean insert1(Integer id, Integer id1) {
        return (this.instStaffTrainingDao.insert1(id,id1)!=0);
    }

    @Override
    public int insert2(Integer id, Integer id1) {
        return this.instStaffTrainingDao.insert1(id,id1);
    }

    @Override
    public int search(Integer instStaffId, Integer trainingId) {
        return instStaffTrainingDao.search(instStaffId,trainingId);
    }


}

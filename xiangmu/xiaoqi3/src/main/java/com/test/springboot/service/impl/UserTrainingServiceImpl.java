package com.test.springboot.service.impl;

import com.test.springboot.entity.UserTraining;
import com.test.springboot.dao.UserTrainingDao;
import com.test.springboot.service.UserTrainingService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 用户_培训计划表(UserTraining)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
@Service("userTrainingService")
public class UserTrainingServiceImpl implements UserTrainingService {
    @Resource
    private UserTrainingDao userTrainingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserTraining queryById(Integer id) {
        return this.userTrainingDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userTraining 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<UserTraining> queryByPage(UserTraining userTraining, PageRequest pageRequest) {
        long total = this.userTrainingDao.count(userTraining);
        return new PageImpl<>(this.userTrainingDao.queryAllByLimit(userTraining, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param userTraining 实例对象
     * @return 实例对象
     */
    @Override
    public UserTraining insert(UserTraining userTraining) {
        this.userTrainingDao.insert(userTraining);
        return userTraining;
    }

    /**
     * 修改数据
     *
     * @param userTraining 实例对象
     * @return 实例对象
     */
    @Override
    public UserTraining update(UserTraining userTraining) {
        this.userTrainingDao.update(userTraining);
        return this.queryById(userTraining.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userTrainingDao.deleteById(id) > 0;
    }

    @Override
    public boolean addusertrain(int id3, int id, int id1) {
        return (this.userTrainingDao.insertustrain(id3,id,id1)!=0);
    }

    @Override
    public int addusertrain1(int id3, int id, int id1) {

        return (this.userTrainingDao.insertustrain(id3,id,id1));
    }


    @Override
    public int selectmax() {
        return userTrainingDao.selectmaxId();
    }

    @Override
    public int select1(int id1, int id2) {
        return userTrainingDao.select1(id1,id2);
    }
}

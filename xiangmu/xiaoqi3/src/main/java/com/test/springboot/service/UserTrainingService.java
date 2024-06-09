package com.test.springboot.service;

import com.test.springboot.entity.UserTraining;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 用户_培训计划表(UserTraining)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
public interface UserTrainingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserTraining queryById(Integer id);

    /**
     * 分页查询
     *
     * @param userTraining 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<UserTraining> queryByPage(UserTraining userTraining, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param userTraining 实例对象
     * @return 实例对象
     */
    UserTraining insert(UserTraining userTraining);

    /**
     * 修改数据
     *
     * @param userTraining 实例对象
     * @return 实例对象
     */
    UserTraining update(UserTraining userTraining);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    boolean addusertrain(int id3,int id,int id1);
    int addusertrain1(int id3,int id,int id1);
    int selectmax();
    int select1(int id1,int id2);

}

package com.test.springboot.service;

import com.test.springboot.entity.InstStaffTraining;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * 机构职员_培训计划表(InstStaffTraining)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface InstStaffTrainingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InstStaffTraining queryById(Integer id);

    /**
     * 分页查询
     *
     * @param instStaffTraining 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<InstStaffTraining> queryByPage(InstStaffTraining instStaffTraining, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param instStaffTraining 实例对象
     * @return 实例对象
     */
    InstStaffTraining insert(InstStaffTraining instStaffTraining);

    /**
     * 修改数据
     *
     * @param instStaffTraining 实例对象
     * @return 实例对象
     */
    InstStaffTraining update(InstStaffTraining instStaffTraining);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    boolean insert1(Integer id, Integer id1);
    int insert2(Integer id,Integer id1);
    int search(Integer instStaffId, Integer trainingId);
}

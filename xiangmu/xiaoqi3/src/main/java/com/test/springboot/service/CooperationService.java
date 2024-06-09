package com.test.springboot.service;

import com.test.springboot.entity.Cooperation;
import com.test.springboot.entity.Training;
import com.test.springboot.vo.CooperateInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 校企合作表(Cooperation)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface CooperationService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Cooperation queryById(Integer id);

    /**
     * 分页查询
     *
     * @param cooperation 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Cooperation> queryByPage(Cooperation cooperation, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param cooperation 实例对象
     * @return 实例对象
     */
    Cooperation insert(Cooperation cooperation);

    /**
     * 修改数据
     *
     * @param cooperation 实例对象
     * @return 实例对象
     */
    Cooperation update(Cooperation cooperation);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<CooperateInfo> queryAll(Integer instId);

    List<CooperateInfo> getSpecificCoopertationsByInstId(Integer id, String searchInfo);


}

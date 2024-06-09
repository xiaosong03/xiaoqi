package com.test.springboot.service;

import com.test.springboot.entity.ResumeJuti;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (ResumeJuti)表服务接口
 *
 * @author makejava
 * @since 2024-06-03 10:23:07
 */
public interface ResumeJutiService {

    /**
     * 通过ID查询单条数据
     *
     * @param resId 主键
     * @return 实例对象
     */
    ResumeJuti queryById(Integer resId);
    boolean queryById1(Integer resId);
    /**
     * 分页查询
     *
     * @param resumeJuti 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<ResumeJuti> queryByPage(ResumeJuti resumeJuti, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param resumeJuti 实例对象
     * @return 实例对象
     */
    ResumeJuti insert(ResumeJuti resumeJuti);

    /**
     * 修改数据
     *
     * @param resumeJuti 实例对象
     * @return 实例对象
     */
    ResumeJuti update(ResumeJuti resumeJuti);

    /**
     * 通过主键删除数据
     *
     * @param resId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer resId);

}

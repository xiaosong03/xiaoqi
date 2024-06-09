package com.test.springboot.service;

import com.test.springboot.entity.JobHunting;
import com.test.springboot.vo.CompanyResumeVo;
import com.test.springboot.vo.JobHuntingVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 求职信息表(JobHunting)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface JobHuntingService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    JobHunting queryById(Integer id);

    /**
     * 分页查询
     *
     * @param jobHunting 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<JobHunting> queryByPage(JobHunting jobHunting, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param jobHunting 实例对象
     * @return 实例对象
     */
    JobHunting insert(JobHunting jobHunting);

    /**
     * 修改数据
     *
     * @param jobHunting 实例对象
     * @return 实例对象
     */
    JobHunting update(JobHunting jobHunting);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    List<JobHuntingVo> getalljob(JobHuntingVo jobHuntingVo);
    List<JobHunting> getcount(JobHuntingVo jobHuntingVo);
    List<JobHuntingVo> getjob(String desc);
    List<JobHunting> getcount1(String desc);

    List<CompanyResumeVo> queryByCompanyId(Integer id);

    boolean searchhot(Integer compId ,Integer id1);

    void sethot(Integer compId1);

    void addhot(Integer compId1);
}

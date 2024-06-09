package com.test.springboot.service.impl;

import com.test.springboot.entity.JobHunting;
import com.test.springboot.dao.JobHuntingDao;
import com.test.springboot.service.JobHuntingService;
import com.test.springboot.vo.CompanyResumeVo;
import com.test.springboot.vo.JobHuntingVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 求职信息表(JobHunting)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@Service("jobHuntingService")
public class JobHuntingServiceImpl implements JobHuntingService {
    @Resource
    private JobHuntingDao jobHuntingDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public JobHunting queryById(Integer id) {
        return this.jobHuntingDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param jobHunting 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<JobHunting> queryByPage(JobHunting jobHunting, PageRequest pageRequest) {
        long total = this.jobHuntingDao.count(jobHunting);
        return new PageImpl<>(this.jobHuntingDao.queryAllByLimit(jobHunting, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param jobHunting 实例对象
     * @return 实例对象
     */
    @Override
    public JobHunting insert(JobHunting jobHunting) {
        this.jobHuntingDao.insert(jobHunting);
        return jobHunting;
    }

    /**
     * 修改数据
     *
     * @param jobHunting 实例对象
     * @return 实例对象
     */
    @Override
    public JobHunting update(JobHunting jobHunting) {
        this.jobHuntingDao.update(jobHunting);
        return this.queryById(jobHunting.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.jobHuntingDao.deleteById(id) > 0;
    }

    @Override
    public List<JobHuntingVo> getalljob(JobHuntingVo jobHuntingVo) {
        return jobHuntingDao.getalljob(jobHuntingVo);
    }


    @Override
    public List<JobHunting> getcount(JobHuntingVo jobHuntingVo) {
        return jobHuntingDao.getcount(jobHuntingVo);
    }

    @Override
    public List<JobHuntingVo> getjob(String desc) {
        return jobHuntingDao.getjob(desc);
    }


    @Override
    public List<JobHunting> getcount1(String desc) {
        return jobHuntingDao.getcount1(desc);
    }

    @Override
    public List<CompanyResumeVo> queryByCompanyId(Integer id) {
        return jobHuntingDao.queryByCompanyId(id);
    }

    @Override
    public boolean searchhot(Integer compId, Integer id1) {
        if(jobHuntingDao.searchhot(compId,id1)==null)
        {
            return false;
        }
        return true;
    }


    @Override
    public void sethot(Integer compId1) {
        jobHuntingDao.updatehot(compId1);
    }

    @Override
    public void addhot(Integer compId1) {
        jobHuntingDao.updatehot1(compId1);
    }
}

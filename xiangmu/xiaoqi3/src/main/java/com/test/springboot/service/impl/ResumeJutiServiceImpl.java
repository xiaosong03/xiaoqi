package com.test.springboot.service.impl;

import com.test.springboot.entity.ResumeJuti;
import com.test.springboot.dao.ResumeJutiDao;
import com.test.springboot.service.ResumeJutiService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (ResumeJuti)表服务实现类
 *
 * @author makejava
 * @since 2024-06-03 10:23:07
 */
@Service("resumeJutiService")
public class ResumeJutiServiceImpl implements ResumeJutiService {
    @Resource
    private ResumeJutiDao resumeJutiDao;

    /**
     * 通过ID查询单条数据
     *
     * @param resId 主键
     * @return 实例对象
     */
    @Override
    public ResumeJuti queryById(Integer resId) {
        return this.resumeJutiDao.queryById(resId);
    }

    @Override
    public boolean queryById1(Integer resId) {
       if(null==this.resumeJutiDao.queryById(resId)){
           return false;
       }
       return true;
    }

    /**
     * 分页查询
     *
     * @param resumeJuti 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<ResumeJuti> queryByPage(ResumeJuti resumeJuti, PageRequest pageRequest) {
        long total = this.resumeJutiDao.count(resumeJuti);
        return new PageImpl<>(this.resumeJutiDao.queryAllByLimit(resumeJuti, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param resumeJuti 实例对象
     * @return 实例对象
     */
    @Override
    public ResumeJuti insert(ResumeJuti resumeJuti) {
        this.resumeJutiDao.insert(resumeJuti);
        return resumeJuti;
    }

    /**
     * 修改数据
     *
     * @param resumeJuti 实例对象
     * @return 实例对象
     */
    @Override
    public ResumeJuti update(ResumeJuti resumeJuti) {
        this.resumeJutiDao.update(resumeJuti);
        return this.queryById(resumeJuti.getResId());
    }

    /**
     * 通过主键删除数据
     *
     * @param resId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer resId) {
        return this.resumeJutiDao.deleteById(resId) > 0;
    }
}

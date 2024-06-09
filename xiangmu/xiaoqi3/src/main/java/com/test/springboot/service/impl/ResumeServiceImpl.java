package com.test.springboot.service.impl;

import com.test.springboot.entity.Resume;
import com.test.springboot.dao.ResumeDao;
import com.test.springboot.service.ResumeService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 简历表(Resume)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeDao resumeDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Resume queryById(Integer id) {
        return this.resumeDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param resume 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Resume> queryByPage(Resume resume, PageRequest pageRequest) {
        long total = this.resumeDao.count(resume);
        return new PageImpl<>(this.resumeDao.queryAllByLimit(resume, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param resume 实例对象
     * @return 实例对象
     */
    @Override
    public Resume insert(Resume resume) {
        this.resumeDao.insert(resume);
        return resume;
    }

    /**
     * 修改数据
     *
     * @param resume 实例对象
     * @return 实例对象
     */
    @Override
    public Resume update(Resume resume) {
        this.resumeDao.update(resume);
        return this.queryById(resume.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.resumeDao.deleteById(id) > 0;
    }

    @Override
    public Resume updatejian(Resume resume) {
        this.resumeDao.update(resume);
        return this.queryById(resume.getId());
    }


    @Override
    public Resume select1(int userId) {
        return resumeDao.select1(userId);
    }
}

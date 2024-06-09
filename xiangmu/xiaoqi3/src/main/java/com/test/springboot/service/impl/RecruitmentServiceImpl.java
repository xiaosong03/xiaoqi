package com.test.springboot.service.impl;

import com.test.springboot.entity.Recruitment;
import com.test.springboot.dao.RecruitmentDao;
import com.test.springboot.service.RecruitmentService;
import com.test.springboot.vo.RecuitmentVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 招聘信息表(Recruitment)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@Service("recruitmentService")
public class RecruitmentServiceImpl implements RecruitmentService {
    @Resource
    private RecruitmentDao recruitmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Recruitment queryById(Integer id) {
        return this.recruitmentDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param recruitment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Recruitment> queryByPage(Recruitment recruitment, PageRequest pageRequest) {
        long total = this.recruitmentDao.count(recruitment);
        return new PageImpl<>(this.recruitmentDao.queryAllByLimit(recruitment, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param recruitment 实例对象
     * @return 实例对象
     */
    @Override
    public Recruitment insert(Recruitment recruitment) {
        this.recruitmentDao.insert(recruitment);
        return recruitment;
    }

    /**
     * 修改数据
     *
     * @param recruitment 实例对象
     * @return 实例对象
     */
    @Override
    public Recruitment update(Recruitment recruitment) {
        this.recruitmentDao.update(recruitment);
        return this.queryById(recruitment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.recruitmentDao.deleteById(id) > 0;
    }

    @Override
    public Recruitment deleteById1(Recruitment recruitment) {
        this.recruitmentDao.deleteById(recruitment.getId());
        return this.recruitmentDao.queryById(recruitment.getId());
    }

    @Override
    public List<RecuitmentVo> getrecruit(RecuitmentVo recruitmentVo) {
        return recruitmentDao.getrecruit(recruitmentVo);
    }


    @Override
    public List<Recruitment> getrecount(RecuitmentVo recruitmentVo) {
        return  recruitmentDao.getcount(recruitmentVo);
    }

    @Override
    public List<RecuitmentVo> getrecruit1(String dec) {
        return recruitmentDao.getrecruit1(dec);
    }


    @Override
    public List<Recruitment> getcount1(String dec) {
        return recruitmentDao.getcount1(dec);
    }

    @Override
    public List<RecuitmentVo> getrecruit2(RecuitmentVo recruitmentVo) {
        return recruitmentDao.getrecruit2(recruitmentVo);
    }

    @Override
    public boolean searchhot(Integer id) {
        Object ob=recruitmentDao.gethot(id);
        System.out.println(ob);
        System.out.println("dddddddddddddddddddddddddd");
        if(null==ob){
            return false;
        }
        return true;
    }

    @Override
    public int addhot(Integer id) {
        return recruitmentDao.updatehot(id);
    }

    @Override
    public int reducehot(Integer id) {
        return recruitmentDao.updatehot1(id);
    }

    @Override
    public void setHot(Integer id) {

            recruitmentDao.updatehot2(id);

    }


}

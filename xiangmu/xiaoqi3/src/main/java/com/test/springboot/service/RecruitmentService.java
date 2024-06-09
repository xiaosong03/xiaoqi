package com.test.springboot.service;

import com.test.springboot.entity.Recruitment;
import com.test.springboot.vo.RecuitmentVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 招聘信息表(Recruitment)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface RecruitmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Recruitment queryById(Integer id);

    /**
     * 分页查询
     *
     * @param recruitment 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Recruitment> queryByPage(Recruitment recruitment, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param recruitment 实例对象
     * @return 实例对象
     */
    Recruitment insert(Recruitment recruitment);

    /**
     * 修改数据
     *
     * @param recruitment 实例对象
     * @return 实例对象
     */
    Recruitment update(Recruitment recruitment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
 Recruitment deleteById1(Recruitment recruitment);
    List<RecuitmentVo> getrecruit(RecuitmentVo recruitmentVo);
    List<Recruitment> getrecount(RecuitmentVo recruitmentVo);
    List<RecuitmentVo> getrecruit1(String dec);
    List<Recruitment> getcount1(String dec);

    List<RecuitmentVo> getrecruit2(RecuitmentVo recruitmentVo);

    boolean searchhot(Integer id);

   int addhot(Integer id);

    int reducehot(Integer id);

    void setHot(Integer id);
}

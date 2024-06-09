package com.test.springboot.dao;

import com.test.springboot.entity.Recruitment;
import com.test.springboot.vo.RecuitmentVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 招聘信息表(Recruitment)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface RecruitmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Recruitment queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param recruitment 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Recruitment> queryAllByLimit(Recruitment recruitment, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param recruitment 查询条件
     * @return 总行数
     */
    long count(Recruitment recruitment);

    /**
     * 新增数据
     *
     * @param recruitment 实例对象
     * @return 影响行数
     */


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Recruitment> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Recruitment> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Recruitment> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Recruitment> entities);

    /**
     * 修改数据
     *
     * @param recruitment 实例对象
     * @return 影响行数
     */
    int update(Recruitment recruitment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    List<RecuitmentVo> getrecruit(RecuitmentVo recruitmentVo);
    List<Recruitment> getcount(RecuitmentVo recruitmentVo);
    int insert(Recruitment recruitment);
    List<RecuitmentVo> getrecruit1(String dec);
    List<Recruitment> getcount1(String dec);

    List<RecuitmentVo> getrecruit2(RecuitmentVo recruitmentVo);

    Object gethot(Integer id);

  int updatehot(Integer id);

  int updatehot1(Integer id);

    void updatehot2(Integer id);


}


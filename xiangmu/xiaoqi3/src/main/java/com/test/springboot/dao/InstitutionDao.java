package com.test.springboot.dao;

import com.test.springboot.entity.InstStaff;
import com.test.springboot.entity.Institution;
import com.test.springboot.entity.JobHunting;
import com.test.springboot.vo.InstitutionVo;
import com.test.springboot.vo.JobHuntingVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 培训机构表(Institution)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface InstitutionDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Institution queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param institution 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Institution> queryAllByLimit(Institution institution, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param institution 查询条件
     * @return 总行数
     */
    long count(Institution institution);

    /**
     * 新增数据
     *
     * @param institution 实例对象
     * @return 影响行数
     */
    int insert(Institution institution);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Institution> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Institution> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Institution> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Institution> entities);

    /**
     * 修改数据
     *
     * @param institution 实例对象
     * @return 影响行数
     */
    int update(Institution institution);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    List<InstitutionVo> getallinstitution(InstitutionVo institution);
    List<Institution> getcount(InstitutionVo institution);
    List<InstitutionVo> getinstitution(String name);
    List<Institution> getcount1(String name);
    InstitutionVo search(int id);
 String search1(int id);
    Institution queryByRegistrantId(int id);

   int updatehot(Integer id);

    Object searchhot(Integer id);

    void updatehot1(Integer id);
}


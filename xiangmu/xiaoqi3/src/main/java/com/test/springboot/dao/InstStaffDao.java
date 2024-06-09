package com.test.springboot.dao;

import com.test.springboot.entity.InstStaff;
import com.test.springboot.vo.InstStaffVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 机构职员表(InstStaff)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface InstStaffDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InstStaff queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param instStaff 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<InstStaff> queryAllByLimit(InstStaff instStaff, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param instStaff 查询条件
     * @return 总行数
     */
    long count(InstStaff instStaff);

    /**
     * 新增数据
     *
     * @param instStaff 实例对象
     * @return 影响行数
     */
    int insert(InstStaff instStaff);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<InstStaff> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<InstStaff> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<InstStaff> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<InstStaff> entities);

    /**
     * 修改数据
     *
     * @param instStaff 实例对象
     * @return 影响行数
     */
    int update(InstStaff instStaff);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
  InstStaffVo search(int userId);
    List<InstStaffVo> search1(int initid);
    InstStaff search2(Integer id);
    int deleteById1(Integer userId);
    InstStaffVo getfu(int trainingId);
    List<InstStaffVo> getzhi(int trainingId);
    List<InstStaffVo> getcan(int trianingId);

}


package com.test.springboot.dao;

import com.test.springboot.entity.Company;
import com.test.springboot.entity.User;
import com.test.springboot.vo.CompanyVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * 公司企业表(Company)表数据库访问层
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface CompanyDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Company queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param company 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Company> queryAllByLimit(Company company, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param company 查询条件
     * @return 总行数
     */
    long count(Company company);

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 影响行数
     */
    int insert(Company company);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Company> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Company> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Company> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Company> entities);

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 影响行数
     */
    int update(Company company);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);
    List<Company> getallcomany(CompanyVo companyVo);

    List<Company> getcount(CompanyVo companyVo);
    List<Company>getcompany(String name);
    List<Company>getcount1(String name);
    List<CompanyVo> getallcomany1(CompanyVo companyVo);
    List<CompanyVo> getallcomany2(CompanyVo companyVo);
    Company showcomp(int id);

    Object isBossOrManager(User user);

    int queryByUserId(User user);

    Company queryByRegistrantId(Company company);

    List<Company> queryAll();
}


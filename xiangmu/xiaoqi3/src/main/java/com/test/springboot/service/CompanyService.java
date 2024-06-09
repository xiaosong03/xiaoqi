package com.test.springboot.service;

import com.test.springboot.entity.Company;
import com.test.springboot.entity.User;
import com.test.springboot.vo.CompanyVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 公司企业表(Company)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface CompanyService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Company queryById(Integer id);

    /**
     * 分页查询
     *
     * @param company 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Company> queryByPage(Company company, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    Company insert(Company company);

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    Company update(Company company);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    List<Company> getallcomany(CompanyVo companyVo);
    List<Company> getcount(CompanyVo companyVo);
    List<Company>getcompany(String name);
    List<Company>getcount1(String name);
    Company showcomp(int id);

    Object isBossOrManager(User user);

    int queryByUserId(User user);

    Company queryByRegistrantId(Company company);

    List<CompanyVo> getallcomany1(CompanyVo companyVo);

    List<CompanyVo> getallcomany2(CompanyVo companyVo);

    List<Company> queryAll();
}

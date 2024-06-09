package com.test.springboot.service.impl;

import com.test.springboot.entity.Company;
import com.test.springboot.dao.CompanyDao;
import com.test.springboot.entity.Institution;
import com.test.springboot.entity.User;
import com.test.springboot.service.CompanyService;
import com.test.springboot.utils.result.DataResult;
import com.test.springboot.vo.CompanyVo;
import com.test.springboot.vo.InstitutionVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * 公司企业表(Company)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@Service("companyService")
public class CompanyServiceImpl implements CompanyService {
    @Resource
    private CompanyDao companyDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Company queryById(Integer id) {
        return this.companyDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param company 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Company> queryByPage(Company company, PageRequest pageRequest) {
        long total = this.companyDao.count(company);
        return new PageImpl<>(this.companyDao.queryAllByLimit(company, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    @Override
    public Company insert(Company company) {
        this.companyDao.insert(company);
        return company;
    }

    /**
     * 修改数据
     *
     * @param company 实例对象
     * @return 实例对象
     */
    @Override
    public Company update(Company company) {
       int flag= this.companyDao.update(company);
        if(flag == 0){
            return null;
        }
        return this.queryById(company.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.companyDao.deleteById(id) > 0;
    }

    @Override
    public List<Company> getallcomany(CompanyVo companyVo) {
        return companyDao.getallcomany(companyVo);
    }

    @Override
    public List<Company> getcount(CompanyVo companyVo) {
        return companyDao.getcount(companyVo);
    }

    @Override
    public List<Company> getcompany(String name) {
       return  companyDao.getcompany(name);
    }

    @Override
    public List<Company> getcount1(String name) {
        return companyDao.getcount1(name);
    }

    @Override
    public Company showcomp(int id) {
        return  companyDao.showcomp(id);
    }

    @Override
    public Object isBossOrManager(User user) {
        return  this.companyDao.isBossOrManager(user);
    }

    @Override
    public int queryByUserId(User user) {
        return  this.companyDao.queryByUserId(user);
    }

    @Override
    public Company queryByRegistrantId(Company company) {
        return  this.companyDao.queryByRegistrantId(company);
    }

    @Override
    public List<CompanyVo> getallcomany1(CompanyVo companyVo) {
        return companyDao.getallcomany1(companyVo);
    }

    @Override
    public List<CompanyVo> getallcomany2(CompanyVo companyVo) {
        return companyDao.getallcomany2(companyVo);
    }

    @Override
    public List<Company> queryAll() {
        return companyDao.queryAll();
    }

}

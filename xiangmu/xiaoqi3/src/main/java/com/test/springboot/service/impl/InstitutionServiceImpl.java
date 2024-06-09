package com.test.springboot.service.impl;

import com.test.springboot.entity.Institution;
import com.test.springboot.dao.InstitutionDao;
import com.test.springboot.service.InstitutionService;
import com.test.springboot.vo.InstitutionVo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 培训机构表(Institution)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@Service("institutionService")
public class InstitutionServiceImpl implements InstitutionService {
    @Resource
    private InstitutionDao institutionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Institution queryById(Integer id) {
        return this.institutionDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param institution 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Institution> queryByPage(Institution institution, PageRequest pageRequest) {
        long total = this.institutionDao.count(institution);
        return new PageImpl<>(this.institutionDao.queryAllByLimit(institution, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param institution 实例对象
     * @return 实例对象
     */
    @Override
    public Institution insert(Institution institution) {
        this.institutionDao.insert(institution);
        return institution;
    }

    /**
     * 修改数据
     *
     * @param institution 实例对象
     * @return 实例对象
     */
    @Override
    public Institution update(Institution institution) {
        this.institutionDao.update(institution);
        return this.queryById(institution.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.institutionDao.deleteById(id) > 0;
    }

    @Override
    public List<InstitutionVo> getallinstitution(InstitutionVo institution) {
        return institutionDao.getallinstitution(institution);
    }


    @Override
    public List<Institution> getcount(InstitutionVo institution) {
        return institutionDao.getcount(institution);
    }

    @Override
    public List<InstitutionVo> getinstitution(String name) {
        return institutionDao.getinstitution(name);
    }


    @Override
    public List<Institution> getcount1(String name) {
        return institutionDao.getcount1(name);
    }

    @Override
    public InstitutionVo search(int id) {
        InstitutionVo institutionVo =institutionDao.search(id);
        institutionVo.setManager1(institutionDao.search1(id));
        return institutionVo;
    }


    @Override
    public Institution queryByRegistrantId(int id) {
        return institutionDao.queryByRegistrantId(id);
    }

    @Override
    public int updatehot(Integer id) {
        return institutionDao.updatehot(id);
    }

    @Override
    public void sethot(Integer id) {
       institutionDao.updatehot1(id);
    }


    @Override
    public boolean searchhot(Integer id) {
      if(null==institutionDao.searchhot(id)){
          return false;

      }
      return  true;
    }


}

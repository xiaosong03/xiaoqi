package com.test.springboot.service;

import com.test.springboot.entity.Institution;
import com.test.springboot.vo.InstitutionVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 培训机构表(Institution)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface InstitutionService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Institution queryById(Integer id);

    /**
     * 分页查询
     *
     * @param institution 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Institution> queryByPage(Institution institution, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param institution 实例对象
     * @return 实例对象
     */
    Institution insert(Institution institution);

    /**
     * 修改数据
     *
     * @param institution 实例对象
     * @return 实例对象
     */
    Institution update(Institution institution);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    List<InstitutionVo> getallinstitution(InstitutionVo institution);
    List<Institution> getcount(InstitutionVo institution);
    List<InstitutionVo> getinstitution(String name);
    List<Institution> getcount1(String name);
    InstitutionVo search(int id);

    Institution queryByRegistrantId(int id);

   int updatehot(Integer id);
   void sethot(Integer id);

    boolean searchhot(Integer id);
}

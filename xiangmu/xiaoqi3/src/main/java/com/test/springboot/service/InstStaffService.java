package com.test.springboot.service;

import com.test.springboot.entity.InstStaff;
import com.test.springboot.vo.InstStaffVo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

/**
 * 机构职员表(InstStaff)表服务接口
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
public interface InstStaffService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    InstStaff queryById(Integer id);

    /**
     * 分页查询
     *
     * @param instStaff 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<InstStaff> queryByPage(InstStaff instStaff, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param instStaff 实例对象
     * @return 实例对象
     */
    InstStaff insert(InstStaff instStaff);

    /**
     * 修改数据
     *
     * @param instStaff 实例对象
     * @return 实例对象
     */
    InstStaff update(InstStaff instStaff);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);
    InstStaffVo search(int userId);
    List<InstStaffVo> search1(int initid);
    InstStaff search2(Integer id);
    boolean deleteByUserId(Integer userId);
    InstStaffVo getfu(int traingId);
    List<InstStaffVo> getzhi(int trainId);
    List<InstStaffVo> getcan(int trianingId);

}

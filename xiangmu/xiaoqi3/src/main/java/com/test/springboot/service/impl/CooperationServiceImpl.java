package com.test.springboot.service.impl;

import com.test.springboot.entity.Cooperation;
import com.test.springboot.dao.CooperationDao;
import com.test.springboot.entity.Training;
import com.test.springboot.service.CooperationService;
import com.test.springboot.vo.CooperateInfo;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * 校企合作表(Cooperation)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:02
 */
@Service("cooperationService")
public class CooperationServiceImpl implements CooperationService {
    @Resource
    private CooperationDao cooperationDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Cooperation queryById(Integer id) {
        return this.cooperationDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param cooperation 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Cooperation> queryByPage(Cooperation cooperation, PageRequest pageRequest) {
        long total = this.cooperationDao.count(cooperation);
        return new PageImpl<>(this.cooperationDao.queryAllByLimit(cooperation, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param cooperation 实例对象
     * @return 实例对象
     */
    @Override
    public Cooperation insert(Cooperation cooperation) {
        this.cooperationDao.insert(cooperation);
        return cooperation;
    }

    /**
     * 修改数据
     *
     * @param cooperation 实例对象
     * @return 实例对象
     */
    @Override
    public Cooperation update(Cooperation cooperation) {
        this.cooperationDao.update(cooperation);
        return this.queryById(cooperation.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.cooperationDao.deleteById(id) > 0;
    }

    @Override
    public List<CooperateInfo> queryAll(Integer instId) {
        return this.cooperationDao.queryAll(instId);
    }

    @Override
    public List<CooperateInfo> getSpecificCoopertationsByInstId(Integer id, String searchInfo) {
        return this.cooperationDao.getSpecificCoopertationsByInstId(id,searchInfo);
    }


}

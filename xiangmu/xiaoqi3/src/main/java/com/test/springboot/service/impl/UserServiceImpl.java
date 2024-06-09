package com.test.springboot.service.impl;

import com.test.springboot.entity.Resume;
import com.test.springboot.entity.User;
import com.test.springboot.dao.UserDao;
import com.test.springboot.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * 用户表(User)表服务实现类
 *
 * @author makejava
 * @since 2024-05-19 10:59:03
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryByname(user.getUsername());
    }

    @Override
    public User queryByname(String username) {
        return this.userDao.queryByname(username);
    }

    @Override
    public User xiugai1(User user) {

       int flag=this.userDao.xiugai1(user);
       // flag == 0   -- 没修改

        if(flag == 0){
            return null;
        }
        return this.queryByCount(user.getUsername(),user.getIdCard());
    }
    @Override
    public User queryByCount(String username, String idCard) {
        return this.userDao.queryByCount(username,idCard);
    }



    @Override
    public User login(User user) {
        return this.userDao.queryLogin(user);
    }

    @Override
    public int register(User user) {
        return this.userDao.insert(user);
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }
}

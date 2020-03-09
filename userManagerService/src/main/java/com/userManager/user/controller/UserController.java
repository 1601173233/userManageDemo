package com.userManager.user.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.User;
import com.userManager.user.service.UserService;
import com.userManager.user.api.UserApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 用户表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@RestController
@Slf4j
public class UserController implements UserApi {
    /**
     * 用户管理服务
     */
    @Autowired
    UserService userApi;

    @Override
    public User getById(String id){
        log.info("根据 id 获取用户信息");

        User result = userApi.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除用户信息");

        // 删除对应的记录
        boolean result = userApi.removeById(id);

        return result;
    }

    @Override
    public boolean save(User user){
        log.info("新增用户信息");

        // 新增一条记录
        boolean result = userApi.save(user);

        return result;
    }

    @Override
    public boolean updateById(User user){
        log.info("更新用户信息");

        // 新增一条记录
        boolean result = userApi.updateById(user);

        return result;
    }

    @Override
    public User selectOne(User user){
        log.info("根据信息获取用户信息单个对象");

        // 根据信息获取用户信息列表
        User entity = userApi.selectOne(user);

        return entity;
    }

    @Override
    public List<User> select(User user){
        log.info("根据信息获取用户信息列表");

        // 根据信息获取用户信息列表
        List<User> list = userApi.select(user);

        return list;
    }

    @Override
    public PageResultVo<User> getPage(User user, PageParamsVo pageParamsVo){
        log.info("根据信息获取用户分页信息");

        // 根据信息获取用户分页信息
        PageResultVo<User> page = userApi.getPage(user, pageParamsVo);

        return page;
    }
}

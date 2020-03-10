package com.userManagerauth.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManagerauth.entity.Auth;
import com.userManagerauth.service.AuthService;
import com.userManagerauth.api.AuthApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 权限管理表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class AuthController implements AuthApi {
    /**
     * 权限管理管理服务
     */
    @Autowired
    AuthService authService;

    @Override
    public Auth getById(String id){
        log.info("根据 id 获取权限管理信息");

        Auth result = authService.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除权限管理信息");

        // 删除对应的记录
        boolean result = authService.removeById(id);

        return result;
    }

    @Override
    public boolean save(Auth auth){
        log.info("新增权限管理信息");

        // 新增一条记录
        boolean result = authService.save(auth);

        return result;
    }

    @Override
    public boolean updateById(Auth auth){
        log.info("更新权限管理信息");

        // 新增一条记录
        boolean result = authService.updateById(auth);

        return result;
    }

    @Override
    public Auth selectOne(Auth auth){
        log.info("根据信息获取权限管理信息单个对象");

        // 根据信息获取权限管理信息列表
        Auth entity = authService.selectOne(auth);

        return entity;
    }

    @Override
    public List<Auth> select(Auth auth){
        log.info("根据信息获取权限管理信息列表");

        // 根据信息获取权限管理信息列表
        List<Auth> list = authService.select(auth);

        return list;
    }

    @Override
    public PageResultVo<Auth> getPage(Auth auth, PageParamsVo pageParamsVo){
        log.info("根据信息获取权限管理分页信息");

        // 根据信息获取权限管理分页信息
        PageResultVo<Auth> page = authService.getPage(auth, pageParamsVo);

        return page;
    }
}

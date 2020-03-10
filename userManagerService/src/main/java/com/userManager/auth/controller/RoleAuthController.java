package com.userManager.auth.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.auth.entity.RoleAuth;
import com.userManager.auth.service.RoleAuthService;
import com.userManager.auth.api.RoleAuthApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 角色授权表表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class RoleAuthController implements RoleAuthApi {
    /**
     * 角色授权表管理服务
     */
    @Autowired
    RoleAuthService roleAuthService;

    @Override
    public RoleAuth getById(String id){
        log.info("根据 id 获取角色授权表信息");

        RoleAuth result = roleAuthService.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除角色授权表信息");

        // 删除对应的记录
        boolean result = roleAuthService.removeById(id);

        return result;
    }

    @Override
    public boolean save(RoleAuth roleAuth){
        log.info("新增角色授权表信息");

        // 新增一条记录
        boolean result = roleAuthService.save(roleAuth);

        return result;
    }

    @Override
    public boolean updateById(RoleAuth roleAuth){
        log.info("更新角色授权表信息");

        // 新增一条记录
        boolean result = roleAuthService.updateById(roleAuth);

        return result;
    }

    @Override
    public RoleAuth selectOne(RoleAuth roleAuth){
        log.info("根据信息获取角色授权表信息单个对象");

        // 根据信息获取角色授权表信息列表
        RoleAuth entity = roleAuthService.selectOne(roleAuth);

        return entity;
    }

    @Override
    public List<RoleAuth> select(RoleAuth roleAuth){
        log.info("根据信息获取角色授权表信息列表");

        // 根据信息获取角色授权表信息列表
        List<RoleAuth> list = roleAuthService.select(roleAuth);

        return list;
    }

    @Override
    public PageResultVo<RoleAuth> getPage(RoleAuth roleAuth, PageParamsVo pageParamsVo){
        log.info("根据信息获取角色授权表分页信息");

        // 根据信息获取角色授权表分页信息
        PageResultVo<RoleAuth> page = roleAuthService.getPage(roleAuth, pageParamsVo);

        return page;
    }
}

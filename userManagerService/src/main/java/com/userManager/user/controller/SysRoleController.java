package com.userManager.user.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.SysRole;
import com.userManager.user.service.SysRoleService;
import com.userManager.user.api.SysRoleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 系统角色表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@RestController
@Slf4j
public class SysRoleController implements SysRoleApi {
    /**
     * 系统角色管理服务
     */
    @Autowired
    SysRoleService sysRoleApi;

    @Override
    public SysRole getById(String id){
        log.info("根据 id 获取系统角色信息");

        SysRole result = sysRoleApi.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除系统角色信息");

        // 删除对应的记录
        boolean result = sysRoleApi.removeById(id);

        return result;
    }

    @Override
    public boolean save(SysRole sysRole){
        log.info("新增系统角色信息");

        // 新增一条记录
        boolean result = sysRoleApi.save(sysRole);

        return result;
    }

    @Override
    public boolean updateById(SysRole sysRole){
        log.info("更新系统角色信息");

        // 新增一条记录
        boolean result = sysRoleApi.updateById(sysRole);

        return result;
    }

    @Override
    public SysRole selectOne(SysRole sysRole){
        log.info("根据信息获取系统角色信息单个对象");

        // 根据信息获取系统角色信息列表
        SysRole entity = sysRoleApi.selectOne(sysRole);

        return entity;
    }

    @Override
    public List<SysRole> select(SysRole sysRole){
        log.info("根据信息获取系统角色信息列表");

        // 根据信息获取系统角色信息列表
        List<SysRole> list = sysRoleApi.select(sysRole);

        return list;
    }

    @Override
    public PageResultVo<SysRole> getPage(SysRole sysRole, PageParamsVo pageParamsVo){
        log.info("根据信息获取系统角色分页信息");

        // 根据信息获取系统角色分页信息
        PageResultVo<SysRole> page = sysRoleApi.getPage(sysRole, pageParamsVo);

        return page;
    }
}

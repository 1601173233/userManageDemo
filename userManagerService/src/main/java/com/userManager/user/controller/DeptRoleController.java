package com.userManager.user.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.DeptRole;
import com.userManager.user.service.DeptRoleService;
import com.userManager.user.api.DeptRoleApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 部门角色表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@RestController
@Slf4j
public class DeptRoleController implements DeptRoleApi {
    /**
     * 部门角色管理服务
     */
    @Autowired
    DeptRoleService deptRoleApi;

    @Override
    public DeptRole getById(String id){
        log.info("根据 id 获取部门角色信息");

        DeptRole result = deptRoleApi.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除部门角色信息");

        // 删除对应的记录
        boolean result = deptRoleApi.removeById(id);

        return result;
    }

    @Override
    public boolean save(DeptRole deptRole){
        log.info("新增部门角色信息");

        // 新增一条记录
        boolean result = deptRoleApi.save(deptRole);

        return result;
    }

    @Override
    public boolean updateById(DeptRole deptRole){
        log.info("更新部门角色信息");

        // 新增一条记录
        boolean result = deptRoleApi.updateById(deptRole);

        return result;
    }

    @Override
    public DeptRole selectOne(DeptRole deptRole){
        log.info("根据信息获取部门角色信息单个对象");

        // 根据信息获取部门角色信息列表
        DeptRole entity = deptRoleApi.selectOne(deptRole);

        return entity;
    }

    @Override
    public List<DeptRole> select(DeptRole deptRole){
        log.info("根据信息获取部门角色信息列表");

        // 根据信息获取部门角色信息列表
        List<DeptRole> list = deptRoleApi.select(deptRole);

        return list;
    }

    @Override
    public PageResultVo<DeptRole> getPage(DeptRole deptRole, PageParamsVo pageParamsVo){
        log.info("根据信息获取部门角色分页信息");

        // 根据信息获取部门角色分页信息
        PageResultVo<DeptRole> page = deptRoleApi.getPage(deptRole, pageParamsVo);

        return page;
    }
}

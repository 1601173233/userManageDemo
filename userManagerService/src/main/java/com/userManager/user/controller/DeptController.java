package com.userManager.user.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.Dept;
import com.userManager.user.service.DeptService;
import com.userManager.user.api.DeptApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 部门表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@RestController
@Slf4j
public class DeptController implements DeptApi {
    /**
     * 部门管理服务
     */
    @Autowired
    DeptService deptApi;

    @Override
    public Dept getById(String id){
        log.info("根据 id 获取部门信息");

        Dept result = deptApi.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除部门信息");

        // 删除对应的记录
        boolean result = deptApi.removeById(id);

        return result;
    }

    @Override
    public boolean save(Dept dept){
        log.info("新增部门信息");

        // 新增一条记录
        boolean result = deptApi.save(dept);

        return result;
    }

    @Override
    public boolean updateById(Dept dept){
        log.info("更新部门信息");

        // 新增一条记录
        boolean result = deptApi.updateById(dept);

        return result;
    }

    @Override
    public Dept selectOne(Dept dept){
        log.info("根据信息获取部门信息单个对象");

        // 根据信息获取部门信息列表
        Dept entity = deptApi.selectOne(dept);

        return entity;
    }

    @Override
    public List<Dept> select(Dept dept){
        log.info("根据信息获取部门信息列表");

        // 根据信息获取部门信息列表
        List<Dept> list = deptApi.select(dept);

        return list;
    }

    @Override
    public PageResultVo<Dept> getPage(Dept dept, PageParamsVo pageParamsVo){
        log.info("根据信息获取部门分页信息");

        // 根据信息获取部门分页信息
        PageResultVo<Dept> page = deptApi.getPage(dept, pageParamsVo);

        return page;
    }
}

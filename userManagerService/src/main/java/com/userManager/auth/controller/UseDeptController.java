package com.userManager.auth.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.auth.entity.UseDept;
import com.userManager.auth.service.UseDeptService;
import com.userManager.auth.api.UseDeptApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 用户的部门表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class UseDeptController implements UseDeptApi {
    /**
     * 用户的部门管理服务
     */
    @Autowired
    UseDeptService useDeptService;

    @Override
    public UseDept getById(String id){
        log.info("根据 id 获取用户的部门信息");

        UseDept result = useDeptService.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除用户的部门信息");

        // 删除对应的记录
        boolean result = useDeptService.removeById(id);

        return result;
    }

    @Override
    public boolean save(UseDept useDept){
        log.info("新增用户的部门信息");

        // 新增一条记录
        boolean result = useDeptService.save(useDept);

        return result;
    }

    @Override
    public boolean updateById(UseDept useDept){
        log.info("更新用户的部门信息");

        // 新增一条记录
        boolean result = useDeptService.updateById(useDept);

        return result;
    }

    @Override
    public UseDept selectOne(UseDept useDept){
        log.info("根据信息获取用户的部门信息单个对象");

        // 根据信息获取用户的部门信息列表
        UseDept entity = useDeptService.selectOne(useDept);

        return entity;
    }

    @Override
    public List<UseDept> select(UseDept useDept){
        log.info("根据信息获取用户的部门信息列表");

        // 根据信息获取用户的部门信息列表
        List<UseDept> list = useDeptService.select(useDept);

        return list;
    }

    @Override
    public PageResultVo<UseDept> getPage(UseDept useDept, PageParamsVo pageParamsVo){
        log.info("根据信息获取用户的部门分页信息");

        // 根据信息获取用户的部门分页信息
        PageResultVo<UseDept> page = useDeptService.getPage(useDept, pageParamsVo);

        return page;
    }
}

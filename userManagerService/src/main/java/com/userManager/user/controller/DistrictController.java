package com.userManager.user.controller;

import com.base.common.util.ExceptionUtil;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.TreeVo;
import com.userManager.user.api.DistrictApi;
import com.userManager.user.entity.District;
import com.userManager.user.service.DistrictService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 区域管理表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class DistrictController implements DistrictApi {
    /**
     * 区域管理管理服务
     */
    @Autowired
    DistrictService districtService;

    @Override
    public District getById(String id){
        log.info("根据 id 获取区域管理信息");

        if(StringUtils.isEmpty(id)){
            ExceptionUtil.validError("id 不能为空！");
        }

        District result = districtService.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除区域管理信息");

        // 删除对应的记录
        boolean result = districtService.removeById(id);

        return result;
    }

    @Override
    public boolean save(District district){
        log.info("新增区域管理信息");

        // 新增一条记录
        boolean result = districtService.save(district);

        return result;
    }

    @Override
    public boolean updateById(District district){
        log.info("更新区域管理信息");

        // 新增一条记录
        boolean result = districtService.updateById(district);

        return result;
    }

    @Override
    public District selectOne(District district){
        log.info("根据信息获取区域管理信息单个对象");

        // 根据信息获取区域管理信息列表
        District entity = districtService.selectOne(district);

        return entity;
    }

    @Override
    public List<District> select(District district){
        log.info("根据信息获取区域管理信息列表");

        // 根据信息获取区域管理信息列表
        List<District> list = districtService.select(district);

        return list;
    }

    @Override
    public PageResultVo<District> getPage(District district, PageParamsVo pageParamsVo){
        log.info("根据信息获取区域管理分页信息");

        // 根据信息获取区域管理分页信息
        PageResultVo<District> page = districtService.getPage(district, pageParamsVo);

        return page;
    }

    @Override
    public boolean move(Integer id, Integer newParentCode, Integer nextNodeId) {
        log.info("根据信息获取区域管理分页信息：节点{},移动到{}的最后,移动到{}的之前", id, newParentCode, nextNodeId);

        return districtService.move(id, newParentCode, nextNodeId);
    }

    @Override
    public TreeVo<String> getTree() {
        log.info("根据信息获取区域树");

        return districtService.getTree();
    }

    @Override
    public TreeVo<String> getTreeByParentCode(String parentCode) {
        log.info("根据信息获取自定子节点下的区域树");

        return districtService.getTreeByParentCode(parentCode);
    }

    @Override
    public TreeVo<String> getTreeWithDept() {
        log.info("根据信息获取区域部门树");

        return districtService.getTreeWithDept();
    }

    @Override
    public TreeVo<String> getTreeWithDeptByParentCode(String parentCode) {
        log.info("根据信息获取自定子节点下的区域部门树");

        return districtService.getTreeWithDeptByParentCode(parentCode);
    }
}

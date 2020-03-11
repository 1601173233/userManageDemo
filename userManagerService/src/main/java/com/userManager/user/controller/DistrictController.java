package com.userManager.user.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.District;
import com.userManager.user.service.DistrictService;
import com.userManager.user.api.DistrictApi;
import lombok.extern.slf4j.Slf4j;
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
    public PageResultVo<District> getTree() {
        log.info("根据信息获取区域树");

        List<District> districtList = districtService.list();
        return null;
    }

    @Override
    public PageResultVo<District> getTreeByParentCode(Integer parentCode) {
        log.info("根据信息获取自定子节点下的区域树");
        return null;
    }

    @Override
    public PageResultVo<District> getTreeWithDept() {
        log.info("根据信息获取区域部门树");
        return null;
    }

    @Override
    public PageResultVo<District> getTreeWithDeptByParentCode(Integer parentCode) {
        log.info("根据信息获取自定子节点下的区域部门树");
        return null;
    }
}

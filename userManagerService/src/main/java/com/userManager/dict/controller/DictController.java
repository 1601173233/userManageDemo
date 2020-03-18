package com.userManager.dict.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.TreeVo;
import com.userManager.dict.entity.Dict;
import com.userManager.dict.service.DictService;
import com.userManager.dict.api.DictApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 字典表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class DictController implements DictApi {
    /**
     * 字典管理服务
     */
    @Autowired
    DictService dictService;

    @Override
    public Dict getById(String id){
        log.info("根据 id 获取字典信息");

        Dict result = dictService.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除字典信息");

        // 删除对应的记录
        boolean result = dictService.removeById(id);

        return result;
    }

    @Override
    public boolean save(Dict dict){
        log.info("新增字典信息");

        // 新增一条记录
        boolean result = dictService.save(dict);

        return result;
    }

    @Override
    public boolean updateById(Dict dict){
        log.info("更新字典信息");

        // 新增一条记录
        boolean result = dictService.updateById(dict);

        return result;
    }

    @Override
    public Dict selectOne(Dict dict){
        log.info("根据信息获取字典信息单个对象");

        // 根据信息获取字典信息列表
        Dict entity = dictService.selectOne(dict);

        return entity;
    }

    @Override
    public List<Dict> select(Dict dict){
        log.info("根据信息获取字典信息列表");

        // 根据信息获取字典信息列表
        List<Dict> list = dictService.select(dict);

        return list;
    }

    @Override
    public PageResultVo<Dict> getPage(Dict dict, PageParamsVo pageParamsVo){
        log.info("根据信息获取字典分页信息");

        // 根据信息获取字典分页信息
        PageResultVo<Dict> page = dictService.getPage(dict, pageParamsVo);

        return page;
    }

    @Override
    public boolean move(Integer id, Integer newParentId, Integer nextNodeId) {
        return dictService.move(id, newParentId, nextNodeId);
    }

    @Override
    public TreeVo<Dict> getTreeByDictType(String type) {
        return dictService.getTreeByDictType(type);
    }
}

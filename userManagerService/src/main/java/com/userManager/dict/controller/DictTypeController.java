package com.userManager.dict.controller;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.dict.entity.DictType;
import com.userManager.dict.service.DictTypeService;
import com.userManager.dict.api.DictTypeApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * 字典类型表表服务控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RestController
@Slf4j
public class DictTypeController implements DictTypeApi {
    /**
     * 字典类型表管理服务
     */
    @Autowired
    DictTypeService dictTypeService;

    @Override
    public DictType getById(String id){
        log.info("根据 id 获取字典类型表信息");

        DictType result = dictTypeService.getById(id);

        // 根据id获取记录
        return result;
    }

    @Override
    public boolean removeById(String id){
        log.info("根据 id 删除字典类型表信息");

        // 删除对应的记录
        boolean result = dictTypeService.removeById(id);

        return result;
    }

    @Override
    public boolean save(DictType dictType){
        log.info("新增字典类型表信息");

        // 新增一条记录
        boolean result = dictTypeService.save(dictType);

        return result;
    }

    @Override
    public boolean updateById(DictType dictType){
        log.info("更新字典类型表信息");

        // 新增一条记录
        boolean result = dictTypeService.updateById(dictType);

        return result;
    }

    @Override
    public DictType selectOne(DictType dictType){
        log.info("根据信息获取字典类型表信息单个对象");

        // 根据信息获取字典类型表信息列表
        DictType entity = dictTypeService.selectOne(dictType);

        return entity;
    }

    @Override
    public List<DictType> select(DictType dictType){
        log.info("根据信息获取字典类型表信息列表");

        // 根据信息获取字典类型表信息列表
        List<DictType> list = dictTypeService.select(dictType);

        return list;
    }

    @Override
    public PageResultVo<DictType> getPage(DictType dictType, PageParamsVo pageParamsVo){
        log.info("根据信息获取字典类型表分页信息");

        // 根据信息获取字典类型表分页信息
        PageResultVo<DictType> page = dictTypeService.getPage(dictType, pageParamsVo);

        return page;
    }
}

package com.userManager.dict.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.dict.entity.DictType;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 字典类型表对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface DictTypeApi{
    /**
     * 根据 id 获取字典类型表信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/dict/dictTypeApi/getById")
    DictType getById(String id);

    /**
     * 根据 id 删除字典类型表信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/dict/dictTypeApi/removeById")
    boolean removeById(String id);

    /**
     * 新增字典类型表信息
     * @param dictType 字典类型表信息
     * @return
     */
    @PutMapping(value = "/innerApi/dict/dictTypeApi/save")
    boolean save(@RequestPart("dictType") DictType dictType);

    /**
     * 更新字典类型表信息
     * @param dictType 字典类型表信息
     * @return
     */
    @PostMapping(value = "/innerApi/dict/dictTypeApi/updateById")
    boolean updateById(@RequestPart("dictType") DictType dictType);

    /**
     * 根据信息获取字典类型表信息单个对象
     * @param dictType 字典类型表信息
     * @return
     */
    @GetMapping(value = "/innerApi/dict/dictTypeApi/selectOne")
    DictType selectOne(@RequestPart("dictType") DictType dictType);

    /**
     * 根据信息获取字典类型表信息列表
     * @param dictType 字典类型表信息
     * @return
     */
    @GetMapping(value = "/innerApi/dict/dictTypeApi/select")
    List<DictType> select(@RequestPart("dictType") DictType dictType);

    /**
     * 根据信息获取字典类型表分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/dict/dictTypeApi/getPage")
    PageResultVo<DictType> getPage(@RequestPart("dictType") DictType dictType,
                                   @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
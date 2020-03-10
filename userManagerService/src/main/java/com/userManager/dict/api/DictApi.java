package com.userManager.dict.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.dict.entity.Dict;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 字典对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface DictApi{
    /**
     * 根据 id 获取字典信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/dictApi/getById")
    Dict getById(String id);

    /**
     * 根据 id 删除字典信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/dictApi/removeById")
    boolean removeById(String id);

    /**
     * 新增字典信息
     * @param dict 字典信息
     * @return
     */
    @PutMapping(value = "/innerApi/dictApi/save")
    boolean save(@RequestPart("dict") Dict dict);

    /**
     * 更新字典信息
     * @param dict 字典信息
     * @return
     */
    @PostMapping(value = "/innerApi/dictApi/updateById")
    boolean updateById(@RequestPart("dict") Dict dict);

    /**
     * 根据信息获取字典信息单个对象
     * @param dict 字典信息
     * @return
     */
    @GetMapping(value = "/innerApi/dictApi/selectOne")
    Dict selectOne(@RequestPart("dict") Dict dict);

    /**
     * 根据信息获取字典信息列表
     * @param dict 字典信息
     * @return
     */
    @GetMapping(value = "/innerApi/dictApi/select")
    List<Dict> select(@RequestPart("dict") Dict dict);

    /**
     * 根据信息获取字典分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/dictApi/getPage")
    PageResultVo<Dict> getPage(@RequestPart("dict") Dict dict,
                               @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
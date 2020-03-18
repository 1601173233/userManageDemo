package com.userManager.dict.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.TreeVo;
import com.userManager.dict.entity.Dict;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "/innerApi/dict/dictApi/getById")
    Dict getById(String id);

    /**
     * 根据 id 删除字典信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/dict/dictApi/removeById")
    boolean removeById(String id);

    /**
     * 新增字典信息
     * @param dict 字典信息
     * @return
     */
    @PutMapping(value = "/innerApi/dict/dictApi/save")
    boolean save(@RequestPart("dict") Dict dict);

    /**
     * 更新字典信息
     * @param dict 字典信息
     * @return
     */
    @PostMapping(value = "/innerApi/dict/dictApi/updateById")
    boolean updateById(@RequestPart("dict") Dict dict);

    /**
     * 根据信息获取字典信息单个对象
     * @param dict 字典信息
     * @return
     */
    @GetMapping(value = "/innerApi/dict/dictApi/selectOne")
    Dict selectOne(@RequestPart("dict") Dict dict);

    /**
     * 根据信息获取字典信息列表
     * @param dict 字典信息
     * @return
     */
    @GetMapping(value = "/innerApi/dict/dictApi/select")
    List<Dict> select(@RequestPart("dict") Dict dict);

    /**
     * 根据信息获取字典分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/dict/dictApi/getPage")
    PageResultVo<Dict> getPage(@RequestPart("dict") Dict dict,
                               @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param nextNodeId 移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点
     * @return
     */
    @PutMapping(value = "/innerApi/user/dictApi/move")
    boolean move(@RequestPart("id") Integer id,
                 @RequestPart("newParentId") Integer newParentId,
                 @RequestPart(value = "nextNodeId", required = false) Integer nextNodeId);

    /**
     * 根据字典类型获取字典树
     * @param type 字典类型
     * @return
     */
    @GetMapping(value = "/innerApi/user/dictApi/getTreeByDictType")
    TreeVo<Dict> getTreeByDictType(String type);
}
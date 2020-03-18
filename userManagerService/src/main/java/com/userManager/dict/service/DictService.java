package com.userManager.dict.service;

import com.base.common.service.BaseService;
import com.base.common.vo.TreeVo;
import com.userManager.dict.entity.Dict;

/**
 * 字典服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface DictService extends BaseService<Dict>{

    /**
     * 根据编码获取数据
     * @param code
     * @return
     */
    Dict getByCode(String code);

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param nextNodeId 移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点
     * @return
     */
    boolean move(Integer id, Integer newParentId, Integer nextNodeId);

    /**
     * 根据字典类型获取字典树
     * @param type 字典类型
     * @return
     */
    TreeVo<Dict> getTreeByDictType(String type);
}
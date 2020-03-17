package com.userManager.user.service;

import com.base.common.service.BaseService;
import com.userManager.user.entity.Dept;

/**
 * 部门服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface DeptService extends BaseService<Dept>{
    /**
     * 根据部门编码获取数据
     * @param code
     * @return
     */
    Dept getByCode(String code);

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param parentType 父节点类型:1.区域，2.部门
     * @param nextNodeId 移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点
     * @return
     */
    boolean move(Integer id, Integer newParentId, Integer parentType, Integer nextNodeId);

    /**
     * 行政区移动时修改相关部门关联的行政区编码
     * @param oldCode 旧的行政区编码
     * @param code 新的行政区编码
     */
    void updateDistrictCodeByDistrictMove(String oldCode, String code);
}
package com.userManager.user.service;

import com.base.common.service.BaseService;
import com.base.common.vo.TreeVo;
import com.userManager.user.entity.District;

/**
 * 区域管理服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface DistrictService extends BaseService<District>{

    /**
     * 根据行政区编码获取数据
     * @param code
     * @return
     */
    District getByCode(String code);

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param nextNodeId 移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点
     * @return
     */
    boolean move(Integer id, Integer newParentId, Integer nextNodeId);

    /**
     * 根据信息获取区域树
     * @return
     */
    TreeVo<String> getTree();

    /**
     * 根据信息获取自定子节点下的区域树
     * @return
     */
    TreeVo<String> getTreeByParentCode(Integer parentCode);

    /**
     * 根据信息获取区域部门树
     * @return
     */
    TreeVo<String> getTreeWithDept();

    /**
     * 根据信息获取自定子节点下的区域部门树
     * @return
     */
    TreeVo<String> getTreeWithDeptByParentCode(Integer parentCode);
}
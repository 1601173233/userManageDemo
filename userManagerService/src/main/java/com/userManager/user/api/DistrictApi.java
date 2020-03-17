package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.TreeVo;
import com.userManager.user.entity.District;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 区域管理对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface DistrictApi{
    /**
     * 根据 id 获取区域管理信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getById")
    District getById(String id);

    /**
     * 根据 id 删除区域管理信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/user/districtApi/removeById")
    boolean removeById(String id);

    /**
     * 新增区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @PutMapping(value = "/innerApi/user/districtApi/save")
    boolean save(@RequestPart("district") District district);

    /**
     * 更新区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @PostMapping(value = "/innerApi/user/districtApi/updateById")
    boolean updateById(@RequestPart("district") District district);

    /**
     * 根据信息获取区域管理信息单个对象
     * @param district 区域管理信息
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/selectOne")
    District selectOne(@RequestPart("district") District district);

    /**
     * 根据信息获取区域管理信息列表
     * @param district 区域管理信息
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/select")
    List<District> select(@RequestPart("district") District district);

    /**
     * 根据信息获取区域管理分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getPage")
    PageResultVo<District> getPage(@RequestPart("district") District district,
                                   @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param nextNodeId 移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点
     * @return
     */
    @PutMapping(value = "/innerApi/user/districtApi/move")
    boolean move(@RequestPart("id") Integer id,
                 @RequestPart("newParentId") Integer newParentId,
                 @RequestPart(value = "nextNodeId", required = false) Integer nextNodeId);

    /**
     * 根据信息获取区域树
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getTree")
    TreeVo<String> getTree();

    /**
     * 根据信息获取自定子节点下的区域树
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getTreeByParentCode")
    TreeVo<String> getTreeByParentCode(String parentCode);

    /**
     * 根据信息获取区域部门树
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getTreeWithDept")
    TreeVo<String> getTreeWithDept();

    /**
     * 根据信息获取自定子节点下的区域部门树
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getTreeWithDeptByParentCode")
    TreeVo<String> getTreeWithDeptByParentCode(String parentCode);
}
package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.Dept;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface DeptApi{
    /**
     * 根据 id 获取部门信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/user/deptApi/getById")
    Dept getById(String id);

    /**
     * 根据 id 删除部门信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/user/deptApi/removeById")
    boolean removeById(String id);

    /**
     * 新增部门信息
     * @param dept 部门信息
     * @return
     */
    @PutMapping(value = "/innerApi/user/deptApi/save")
    boolean save(@RequestPart("dept") Dept dept);

    /**
     * 更新部门信息
     * @param dept 部门信息
     * @return
     */
    @PostMapping(value = "/innerApi/user/deptApi/updateById")
    boolean updateById(@RequestPart("dept") Dept dept);

    /**
     * 根据信息获取部门信息单个对象
     * @param dept 部门信息
     * @return
     */
    @GetMapping(value = "/innerApi/user/deptApi/selectOne")
    Dept selectOne(@RequestPart("dept") Dept dept);

    /**
     * 根据信息获取部门信息列表
     * @param dept 部门信息
     * @return
     */
    @GetMapping(value = "/innerApi/user/deptApi/select")
    List<Dept> select(@RequestPart("dept") Dept dept);

    /**
     * 根据信息获取部门分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/user/deptApi/getPage")
    PageResultVo<Dept> getPage(@RequestPart("dept") Dept dept,
                               @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param parentType 父节点类型:1.区域，2.部门
     * @param nextNodeId 下一个节点的Id，如果为空说明是插入
     * @return
     */
    @PutMapping(value = "/innerApi/user/deptApi/move")
    boolean move(@RequestPart("id") Integer id,
                 @RequestPart("newParentId") Integer newParentId,
                 @RequestPart("parentType") Integer parentType,
                 @RequestPart(value = "nextNodeId", required = false) Integer nextNodeId);
}
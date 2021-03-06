package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.Dept;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

/**
 * 部门对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface DeptApi{
    /**
     * 根据 id 获取部门信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/deptApi/getById")
    Dept getById(@Param("id") String id);

    /**
     * 根据 id 删除部门信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/user/deptApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增部门信息
     * @param dept 部门信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/user/deptApi/save")
    boolean save(@Param("dept") Dept dept);

    /**
     * 更新部门信息
     * @param dept 部门信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/user/deptApi/updateById")
    boolean updateById(@Param("dept") Dept dept);

    /**
     * 根据信息获取部门信息单个对象
     * @param dept 部门信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/deptApi/selectOne")
    Dept selectOne(@Param("dept") Dept dept);

    /**
     * 根据信息获取部门信息列表
     * @param dept 部门信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/deptApi/select")
    List<Dept> select(@Param("dept") Dept dept);

    /**
     * 根据信息获取部门分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/deptApi/getPage")
    PageResultVo<Dept> getPage(@Param("dept") Dept dept, @Param("pageParamsVo") PageParamsVo pageParamsVo);

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param parentType 父节点类型:1.区域，2.部门
     * @param nextNodeId 下一个节点的Id，如果为空说明是插入
     * @return
     */
    @RequestLine(value = "PUT /innerApi/user/deptApi/move")
    boolean move(@Param("id") Integer id,
                 @Param("newParentId") Integer newParentId,
                 @Param("parentType") Integer parentType,
                 @Param("nextNodeId") Integer nextNodeId);
}
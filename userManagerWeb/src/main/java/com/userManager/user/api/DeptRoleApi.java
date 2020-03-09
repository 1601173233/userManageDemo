package com.userManager.user.api;

import com.userManager.user.entity.DeptRole;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 部门角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@FeignClient(name = "USER-MANAGER-SERVER")
public interface DeptRoleApi{
    /**
     * 根据 id 获取部门角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/deptRoleApi/getById")
    DeptRole getById(@Param("id") String id);

    /**
     * 根据 id 删除部门角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/deptRoleApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增部门角色信息
     * @param deptRole 部门角色信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/deptRoleApi/save")
    boolean save(@Param("deptRole") DeptRole deptRole);

    /**
     * 更新部门角色信息
     * @param deptRole 部门角色信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/deptRoleApi/updateById")
    boolean updateById(@Param("deptRole") DeptRole deptRole);

    /**
     * 根据信息获取部门角色信息单个对象
     * @param deptRole 部门角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/deptRoleApi/selectOne")
    DeptRole selectOne(@Param("deptRole") DeptRole deptRole);

    /**
     * 根据信息获取部门角色信息列表
     * @param deptRole 部门角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/deptRoleApi/select")
    List<DeptRole> select(@Param("deptRole") DeptRole deptRole);

    /**
     * 根据信息获取部门角色分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/deptRoleApi/getPage")
    PageResultVo<DeptRole> getPage(@Param("deptRole") DeptRole deptRole, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
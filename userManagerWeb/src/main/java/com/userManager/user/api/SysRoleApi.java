package com.userManager.user.api;

import com.userManager.user.entity.SysRole;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 系统角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@FeignClient(name = "USER-MANAGER-SERVER")
public interface SysRoleApi{
    /**
     * 根据 id 获取系统角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/sysRoleApi/getById")
    SysRole getById(@Param("id") String id);

    /**
     * 根据 id 删除系统角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/sysRoleApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增系统角色信息
     * @param sysRole 系统角色信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/sysRoleApi/save")
    boolean save(@Param("sysRole") SysRole sysRole);

    /**
     * 更新系统角色信息
     * @param sysRole 系统角色信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/sysRoleApi/updateById")
    boolean updateById(@Param("sysRole") SysRole sysRole);

    /**
     * 根据信息获取系统角色信息单个对象
     * @param sysRole 系统角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/sysRoleApi/selectOne")
    SysRole selectOne(@Param("sysRole") SysRole sysRole);

    /**
     * 根据信息获取系统角色信息列表
     * @param sysRole 系统角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/sysRoleApi/select")
    List<SysRole> select(@Param("sysRole") SysRole sysRole);

    /**
     * 根据信息获取系统角色分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/sysRoleApi/getPage")
    PageResultVo<SysRole> getPage(@Param("sysRole") SysRole sysRole, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
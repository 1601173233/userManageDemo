package com.userManager.user.api;

import com.userManager.user.entity.Role;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface RoleApi{
    /**
     * 根据 id 获取角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/roleApi/getById")
    Role getById(@Param("id") String id);

    /**
     * 根据 id 删除角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/user/roleApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增角色信息
     * @param role 角色信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/user/roleApi/save")
    boolean save(@Param("role") Role role);

    /**
     * 更新角色信息
     * @param role 角色信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/user/roleApi/updateById")
    boolean updateById(@Param("role") Role role);

    /**
     * 根据信息获取角色信息单个对象
     * @param role 角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/roleApi/selectOne")
    Role selectOne(@Param("role") Role role);

    /**
     * 根据信息获取角色信息列表
     * @param role 角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/roleApi/select")
    List<Role> select(@Param("role") Role role);

    /**
     * 根据信息获取角色分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/roleApi/getPage")
    PageResultVo<Role> getPage(@Param("role") Role role, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
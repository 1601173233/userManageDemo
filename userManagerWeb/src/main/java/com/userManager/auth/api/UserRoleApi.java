package com.userManager.auth.api;

import com.userManager.auth.entity.UserRole;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 用户的角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface UserRoleApi{
    /**
     * 根据 id 获取用户的角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/userRoleApi/getById")
    UserRole getById(@Param("id") String id);

    /**
     * 根据 id 删除用户的角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/auth/userRoleApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增用户的角色信息
     * @param userRole 用户的角色信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/auth/userRoleApi/save")
    boolean save(@Param("userRole") UserRole userRole);

    /**
     * 更新用户的角色信息
     * @param userRole 用户的角色信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/auth/userRoleApi/updateById")
    boolean updateById(@Param("userRole") UserRole userRole);

    /**
     * 根据信息获取用户的角色信息单个对象
     * @param userRole 用户的角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/userRoleApi/selectOne")
    UserRole selectOne(@Param("userRole") UserRole userRole);

    /**
     * 根据信息获取用户的角色信息列表
     * @param userRole 用户的角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/userRoleApi/select")
    List<UserRole> select(@Param("userRole") UserRole userRole);

    /**
     * 根据信息获取用户的角色分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/userRoleApi/getPage")
    PageResultVo<UserRole> getPage(@Param("userRole") UserRole userRole, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
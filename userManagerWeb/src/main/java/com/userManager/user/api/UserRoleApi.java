package com.userManager.user.api;

import com.userManager.user.entity.UserRole;
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
 * @version : 2020年03月09日
 * @since
 */
@FeignClient(name = "USER-MANAGER-SERVER")
public interface UserRoleApi{
    /**
     * 根据 id 获取用户的角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/userRoleApi/getById")
    UserRole getById(@Param("id") String id);

    /**
     * 根据 id 删除用户的角色信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/userRoleApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增用户的角色信息
     * @param userRole 用户的角色信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/userRoleApi/save")
    boolean save(@Param("userRole") UserRole userRole);

    /**
     * 更新用户的角色信息
     * @param userRole 用户的角色信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/userRoleApi/updateById")
    boolean updateById(@Param("userRole") UserRole userRole);

    /**
     * 根据信息获取用户的角色信息单个对象
     * @param userRole 用户的角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/userRoleApi/selectOne")
    UserRole selectOne(@Param("userRole") UserRole userRole);

    /**
     * 根据信息获取用户的角色信息列表
     * @param userRole 用户的角色信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/userRoleApi/select")
    List<UserRole> select(@Param("userRole") UserRole userRole);

    /**
     * 根据信息获取用户的角色分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/userRoleApi/getPage")
    PageResultVo<UserRole> getPage(@Param("userRole") UserRole userRole, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
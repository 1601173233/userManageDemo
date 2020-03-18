package com.userManager.auth.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.auth.entity.RoleAuth;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;

/**
 * 角色授权表对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface RoleAuthApi{
    /**
     * 根据角色ID获取角色拥有的权限列表
     */
    @RequestLine(value = "GET /innerApi/auth/roleAuthApi/selectByRoleId")
    List<RoleAuth> selectByRoleId(@Param("roleId") Integer roleId);

    /**
     * 给某个角色设置权限
     */
    @RequestLine(value = "POST /innerApi/auth/roleAuthApi/setAuth")
    Boolean setAuth(@Param("roleId") Integer roleId,
                    @Param(value = "authIdList") List<Integer> authIdList);
}
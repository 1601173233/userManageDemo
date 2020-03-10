package com.userManager.auth.api;

import com.userManager.auth.entity.RoleAuth;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 角色授权表对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "USER-MANAGER-SERVER")
public interface RoleAuthApi{
    /**
     * 根据 id 获取角色授权表信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/roleAuthApi/getById")
    RoleAuth getById(@Param("id") String id);

    /**
     * 根据 id 删除角色授权表信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/auth/roleAuthApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增角色授权表信息
     * @param roleAuth 角色授权表信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/auth/roleAuthApi/save")
    boolean save(@Param("roleAuth") RoleAuth roleAuth);

    /**
     * 更新角色授权表信息
     * @param roleAuth 角色授权表信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/auth/roleAuthApi/updateById")
    boolean updateById(@Param("roleAuth") RoleAuth roleAuth);

    /**
     * 根据信息获取角色授权表信息单个对象
     * @param roleAuth 角色授权表信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/roleAuthApi/selectOne")
    RoleAuth selectOne(@Param("roleAuth") RoleAuth roleAuth);

    /**
     * 根据信息获取角色授权表信息列表
     * @param roleAuth 角色授权表信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/roleAuthApi/select")
    List<RoleAuth> select(@Param("roleAuth") RoleAuth roleAuth);

    /**
     * 根据信息获取角色授权表分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/roleAuthApi/getPage")
    PageResultVo<RoleAuth> getPage(@Param("roleAuth") RoleAuth roleAuth, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
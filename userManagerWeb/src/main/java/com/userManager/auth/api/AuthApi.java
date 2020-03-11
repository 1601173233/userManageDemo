package com.userManager.auth.api;

import com.userManager.auth.entity.Auth;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 权限管理对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface AuthApi{
    /**
     * 根据 id 获取权限管理信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/authApi/getById")
    Auth getById(@Param("id") String id);

    /**
     * 根据 id 删除权限管理信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/auth/authApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增权限管理信息
     * @param auth 权限管理信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/auth/authApi/save")
    boolean save(@Param("auth") Auth auth);

    /**
     * 更新权限管理信息
     * @param auth 权限管理信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/auth/authApi/updateById")
    boolean updateById(@Param("auth") Auth auth);

    /**
     * 根据信息获取权限管理信息单个对象
     * @param auth 权限管理信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/authApi/selectOne")
    Auth selectOne(@Param("auth") Auth auth);

    /**
     * 根据信息获取权限管理信息列表
     * @param auth 权限管理信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/authApi/select")
    List<Auth> select(@Param("auth") Auth auth);

    /**
     * 根据信息获取权限管理分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/auth/authApi/getPage")
    PageResultVo<Auth> getPage(@Param("auth") Auth auth, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
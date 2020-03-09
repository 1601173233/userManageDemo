package com.userManager.user.api;

import com.userManager.user.entity.User;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 用户对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@FeignClient(name = "USER-MANAGER-SERVER")
public interface UserApi{
    /**
     * 根据 id 获取用户信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/userApi/getById")
    User getById(@Param("id") String id);

    /**
     * 根据 id 删除用户信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/userApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增用户信息
     * @param user 用户信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/userApi/save")
    boolean save(@Param("user") User user);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/userApi/updateById")
    boolean updateById(@Param("user") User user);

    /**
     * 根据信息获取用户信息单个对象
     * @param user 用户信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/userApi/selectOne")
    User selectOne(@Param("user") User user);

    /**
     * 根据信息获取用户信息列表
     * @param user 用户信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/userApi/select")
    List<User> select(@Param("user") User user);

    /**
     * 根据信息获取用户分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/userApi/getPage")
    PageResultVo<User> getPage(@Param("user") User user, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
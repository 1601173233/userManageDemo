package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.User;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 用户对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
public interface UserApi{
    /**
     * 根据 id 获取用户信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/userApi/getById")
    User getById(String id);

    /**
     * 根据 id 删除用户信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/userApi/removeById")
    boolean removeById(String id);

    /**
     * 新增用户信息
     * @param user 用户信息
     * @return
     */
    @PutMapping(value = "/innerApi/userApi/save")
    boolean save(@RequestPart("user") User user);

    /**
     * 更新用户信息
     * @param user 用户信息
     * @return
     */
    @PostMapping(value = "/innerApi/userApi/updateById")
    boolean updateById(@RequestPart("user") User user);

    /**
     * 根据信息获取用户信息单个对象
     * @param user 用户信息
     * @return
     */
    @GetMapping(value = "/innerApi/userApi/selectOne")
    User selectOne(@RequestPart("user") User user);

    /**
     * 根据信息获取用户信息列表
     * @param user 用户信息
     * @return
     */
    @GetMapping(value = "/innerApi/userApi/select")
    List<User> select(@RequestPart("user") User user);

    /**
     * 根据信息获取用户分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/userApi/getPage")
    PageResultVo<User> getPage(@RequestPart("user") User user,
                               @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
package com.userManagerauth.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManagerauth.entity.UserRole;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 用户的角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface UserRoleApi{
    /**
     * 根据 id 获取用户的角色信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/auth/userRoleApi/getById")
    UserRole getById(String id);

    /**
     * 根据 id 删除用户的角色信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/auth/userRoleApi/removeById")
    boolean removeById(String id);

    /**
     * 新增用户的角色信息
     * @param userRole 用户的角色信息
     * @return
     */
    @PutMapping(value = "/innerApi/auth/userRoleApi/save")
    boolean save(@RequestPart("userRole") UserRole userRole);

    /**
     * 更新用户的角色信息
     * @param userRole 用户的角色信息
     * @return
     */
    @PostMapping(value = "/innerApi/auth/userRoleApi/updateById")
    boolean updateById(@RequestPart("userRole") UserRole userRole);

    /**
     * 根据信息获取用户的角色信息单个对象
     * @param userRole 用户的角色信息
     * @return
     */
    @GetMapping(value = "/innerApi/userRoleApi/selectOne")
    UserRole selectOne(@RequestPart("userRole") UserRole userRole);

    /**
     * 根据信息获取用户的角色信息列表
     * @param userRole 用户的角色信息
     * @return
     */
    @GetMapping(value = "/innerApi/auth/userRoleApi/select")
    List<UserRole> select(@RequestPart("userRole") UserRole userRole);

    /**
     * 根据信息获取用户的角色分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/auth/userRoleApi/getPage")
    PageResultVo<UserRole> getPage(@RequestPart("userRole") UserRole userRole,
                                            @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
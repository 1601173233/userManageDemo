package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.Role;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface RoleApi{
    /**
     * 根据 id 获取角色信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/user/roleApi/getById")
    Role getById(String id);

    /**
     * 根据 id 删除角色信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/user/roleApi/removeById")
    boolean removeById(String id);

    /**
     * 新增角色信息
     * @param role 角色信息
     * @return
     */
    @PutMapping(value = "/innerApi/user/roleApi/save")
    boolean save(@RequestPart("role") Role role);

    /**
     * 更新角色信息
     * @param role 角色信息
     * @return
     */
    @PostMapping(value = "/innerApi/user/roleApi/updateById")
    boolean updateById(@RequestPart("role") Role role);

    /**
     * 根据信息获取角色信息单个对象
     * @param role 角色信息
     * @return
     */
    @GetMapping(value = "/innerApi/user/roleApi/selectOne")
    Role selectOne(@RequestPart("role") Role role);

    /**
     * 根据信息获取角色信息列表
     * @param role 角色信息
     * @return
     */
    @GetMapping(value = "/innerApi/user/roleApi/select")
    List<Role> select(@RequestPart("role") Role role);

    /**
     * 根据信息获取角色分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/user/roleApi/getPage")
    PageResultVo<Role> getPage(@RequestPart("role") Role role,
                               @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
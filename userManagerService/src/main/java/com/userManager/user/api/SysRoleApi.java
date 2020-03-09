package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.SysRole;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 系统角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
public interface SysRoleApi{
    /**
     * 根据 id 获取系统角色信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/sysRoleApi/getById")
    SysRole getById(String id);

    /**
     * 根据 id 删除系统角色信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/sysRoleApi/removeById")
    boolean removeById(String id);

    /**
     * 新增系统角色信息
     * @param sysRole 系统角色信息
     * @return
     */
    @PutMapping(value = "/innerApi/sysRoleApi/save")
    boolean save(@RequestPart("sysRole") SysRole sysRole);

    /**
     * 更新系统角色信息
     * @param sysRole 系统角色信息
     * @return
     */
    @PostMapping(value = "/innerApi/sysRoleApi/updateById")
    boolean updateById(@RequestPart("sysRole") SysRole sysRole);

    /**
     * 根据信息获取系统角色信息单个对象
     * @param sysRole 系统角色信息
     * @return
     */
    @GetMapping(value = "/innerApi/sysRoleApi/selectOne")
    SysRole selectOne(@RequestPart("sysRole") SysRole sysRole);

    /**
     * 根据信息获取系统角色信息列表
     * @param sysRole 系统角色信息
     * @return
     */
    @GetMapping(value = "/innerApi/sysRoleApi/select")
    List<SysRole> select(@RequestPart("sysRole") SysRole sysRole);

    /**
     * 根据信息获取系统角色分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/sysRoleApi/getPage")
    PageResultVo<SysRole> getPage(@RequestPart("sysRole") SysRole sysRole,
                                  @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
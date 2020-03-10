package com.userManagerauth.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManagerauth.entity.RoleAuth;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 角色授权表对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface RoleAuthApi{
    /**
     * 根据 id 获取角色授权表信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/auth/roleAuthApi/getById")
    RoleAuth getById(String id);

    /**
     * 根据 id 删除角色授权表信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/auth/roleAuthApi/removeById")
    boolean removeById(String id);

    /**
     * 新增角色授权表信息
     * @param roleAuth 角色授权表信息
     * @return
     */
    @PutMapping(value = "/innerApi/auth/roleAuthApi/save")
    boolean save(@RequestPart("roleAuth") RoleAuth roleAuth);

    /**
     * 更新角色授权表信息
     * @param roleAuth 角色授权表信息
     * @return
     */
    @PostMapping(value = "/innerApi/auth/roleAuthApi/updateById")
    boolean updateById(@RequestPart("roleAuth") RoleAuth roleAuth);

    /**
     * 根据信息获取角色授权表信息单个对象
     * @param roleAuth 角色授权表信息
     * @return
     */
    @GetMapping(value = "/innerApi/roleAuthApi/selectOne")
    RoleAuth selectOne(@RequestPart("roleAuth") RoleAuth roleAuth);

    /**
     * 根据信息获取角色授权表信息列表
     * @param roleAuth 角色授权表信息
     * @return
     */
    @GetMapping(value = "/innerApi/auth/roleAuthApi/select")
    List<RoleAuth> select(@RequestPart("roleAuth") RoleAuth roleAuth);

    /**
     * 根据信息获取角色授权表分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/auth/roleAuthApi/getPage")
    PageResultVo<RoleAuth> getPage(@RequestPart("roleAuth") RoleAuth roleAuth,
                                            @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
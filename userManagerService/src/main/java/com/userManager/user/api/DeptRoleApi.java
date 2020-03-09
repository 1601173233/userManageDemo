package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.DeptRole;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 部门角色对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
public interface DeptRoleApi{
    /**
     * 根据 id 获取部门角色信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/deptRoleApi/getById")
    DeptRole getById(String id);

    /**
     * 根据 id 删除部门角色信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/deptRoleApi/removeById")
    boolean removeById(String id);

    /**
     * 新增部门角色信息
     * @param deptRole 部门角色信息
     * @return
     */
    @PutMapping(value = "/innerApi/deptRoleApi/save")
    boolean save(@RequestPart("deptRole") DeptRole deptRole);

    /**
     * 更新部门角色信息
     * @param deptRole 部门角色信息
     * @return
     */
    @PostMapping(value = "/innerApi/deptRoleApi/updateById")
    boolean updateById(@RequestPart("deptRole") DeptRole deptRole);

    /**
     * 根据信息获取部门角色信息单个对象
     * @param deptRole 部门角色信息
     * @return
     */
    @GetMapping(value = "/innerApi/deptRoleApi/selectOne")
    DeptRole selectOne(@RequestPart("deptRole") DeptRole deptRole);

    /**
     * 根据信息获取部门角色信息列表
     * @param deptRole 部门角色信息
     * @return
     */
    @GetMapping(value = "/innerApi/deptRoleApi/select")
    List<DeptRole> select(@RequestPart("deptRole") DeptRole deptRole);

    /**
     * 根据信息获取部门角色分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/deptRoleApi/getPage")
    PageResultVo<DeptRole> getPage(@RequestPart("deptRole") DeptRole deptRole,
                                   @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
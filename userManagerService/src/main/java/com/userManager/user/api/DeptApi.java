package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.Dept;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 部门对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface DeptApi{
    /**
     * 根据 id 获取部门信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/deptApi/getById")
    Dept getById(String id);

    /**
     * 根据 id 删除部门信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/deptApi/removeById")
    boolean removeById(String id);

    /**
     * 新增部门信息
     * @param dept 部门信息
     * @return
     */
    @PutMapping(value = "/innerApi/deptApi/save")
    boolean save(@RequestPart("dept") Dept dept);

    /**
     * 更新部门信息
     * @param dept 部门信息
     * @return
     */
    @PostMapping(value = "/innerApi/deptApi/updateById")
    boolean updateById(@RequestPart("dept") Dept dept);

    /**
     * 根据信息获取部门信息单个对象
     * @param dept 部门信息
     * @return
     */
    @GetMapping(value = "/innerApi/deptApi/selectOne")
    Dept selectOne(@RequestPart("dept") Dept dept);

    /**
     * 根据信息获取部门信息列表
     * @param dept 部门信息
     * @return
     */
    @GetMapping(value = "/innerApi/deptApi/select")
    List<Dept> select(@RequestPart("dept") Dept dept);

    /**
     * 根据信息获取部门分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/deptApi/getPage")
    PageResultVo<Dept> getPage(@RequestPart("dept") Dept dept,
                               @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
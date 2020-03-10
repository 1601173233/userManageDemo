package com.userManager.auth.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.auth.entity.UseDept;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 用户的部门对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface UseDeptApi{
    /**
     * 根据 id 获取用户的部门信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/auth/useDeptApi/getById")
    UseDept getById(String id);

    /**
     * 根据 id 删除用户的部门信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/auth/useDeptApi/removeById")
    boolean removeById(String id);

    /**
     * 新增用户的部门信息
     * @param useDept 用户的部门信息
     * @return
     */
    @PutMapping(value = "/innerApi/auth/useDeptApi/save")
    boolean save(@RequestPart("useDept") UseDept useDept);

    /**
     * 更新用户的部门信息
     * @param useDept 用户的部门信息
     * @return
     */
    @PostMapping(value = "/innerApi/auth/useDeptApi/updateById")
    boolean updateById(@RequestPart("useDept") UseDept useDept);

    /**
     * 根据信息获取用户的部门信息单个对象
     * @param useDept 用户的部门信息
     * @return
     */
    @GetMapping(value = "/innerApi/useDeptApi/selectOne")
    UseDept selectOne(@RequestPart("useDept") UseDept useDept);

    /**
     * 根据信息获取用户的部门信息列表
     * @param useDept 用户的部门信息
     * @return
     */
    @GetMapping(value = "/innerApi/auth/useDeptApi/select")
    List<UseDept> select(@RequestPart("useDept") UseDept useDept);

    /**
     * 根据信息获取用户的部门分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/auth/useDeptApi/getPage")
    PageResultVo<UseDept> getPage(@RequestPart("useDept") UseDept useDept,
                                            @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
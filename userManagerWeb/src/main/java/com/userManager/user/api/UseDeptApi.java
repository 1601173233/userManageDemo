package com.userManager.user.api;

import com.userManager.user.entity.UseDept;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 用户的部门对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月09日
 * @since
 */
@FeignClient(name = "USER-MANAGER-SERVER")
public interface UseDeptApi{
    /**
     * 根据 id 获取用户的部门信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/useDeptApi/getById")
    UseDept getById(@Param("id") String id);

    /**
     * 根据 id 删除用户的部门信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/useDeptApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增用户的部门信息
     * @param useDept 用户的部门信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/useDeptApi/save")
    boolean save(@Param("useDept") UseDept useDept);

    /**
     * 更新用户的部门信息
     * @param useDept 用户的部门信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/useDeptApi/updateById")
    boolean updateById(@Param("useDept") UseDept useDept);

    /**
     * 根据信息获取用户的部门信息单个对象
     * @param useDept 用户的部门信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/useDeptApi/selectOne")
    UseDept selectOne(@Param("useDept") UseDept useDept);

    /**
     * 根据信息获取用户的部门信息列表
     * @param useDept 用户的部门信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/useDeptApi/select")
    List<UseDept> select(@Param("useDept") UseDept useDept);

    /**
     * 根据信息获取用户的部门分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/useDeptApi/getPage")
    PageResultVo<UseDept> getPage(@Param("useDept") UseDept useDept, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
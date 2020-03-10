package com.userManager.user.api;

import com.userManager.user.entity.District;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 区域管理对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "USER-MANAGER-SERVER")
public interface DistrictApi{
    /**
     * 根据 id 获取区域管理信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/districtApi/getById")
    District getById(@Param("id") String id);

    /**
     * 根据 id 删除区域管理信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/user/districtApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/user/districtApi/save")
    boolean save(@Param("district") District district);

    /**
     * 更新区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/user/districtApi/updateById")
    boolean updateById(@Param("district") District district);

    /**
     * 根据信息获取区域管理信息单个对象
     * @param district 区域管理信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/districtApi/selectOne")
    District selectOne(@Param("district") District district);

    /**
     * 根据信息获取区域管理信息列表
     * @param district 区域管理信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/districtApi/select")
    List<District> select(@Param("district") District district);

    /**
     * 根据信息获取区域管理分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/districtApi/getPage")
    PageResultVo<District> getPage(@Param("district") District district, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.District;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 区域管理对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface DistrictApi{
    /**
     * 根据 id 获取区域管理信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/districtApi/getById")
    District getById(String id);

    /**
     * 根据 id 删除区域管理信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/districtApi/removeById")
    boolean removeById(String id);

    /**
     * 新增区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @PutMapping(value = "/innerApi/districtApi/save")
    boolean save(@RequestPart("district") District district);

    /**
     * 更新区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @PostMapping(value = "/innerApi/districtApi/updateById")
    boolean updateById(@RequestPart("district") District district);

    /**
     * 根据信息获取区域管理信息单个对象
     * @param district 区域管理信息
     * @return
     */
    @GetMapping(value = "/innerApi/districtApi/selectOne")
    District selectOne(@RequestPart("district") District district);

    /**
     * 根据信息获取区域管理信息列表
     * @param district 区域管理信息
     * @return
     */
    @GetMapping(value = "/innerApi/districtApi/select")
    List<District> select(@RequestPart("district") District district);

    /**
     * 根据信息获取区域管理分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/districtApi/getPage")
    PageResultVo<District> getPage(@RequestPart("district") District district,
                                   @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
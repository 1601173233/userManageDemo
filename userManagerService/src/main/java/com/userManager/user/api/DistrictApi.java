package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.user.entity.District;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping(value = "/innerApi/user/districtApi/getById")
    District getById(String id);

    /**
     * 根据 id 删除区域管理信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/user/districtApi/removeById")
    boolean removeById(String id);

    /**
     * 新增区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @PutMapping(value = "/innerApi/user/districtApi/save")
    boolean save(@RequestPart("district") District district);

    /**
     * 更新区域管理信息
     * @param district 区域管理信息
     * @return
     */
    @PostMapping(value = "/innerApi/user/districtApi/updateById")
    boolean updateById(@RequestPart("district") District district);

    /**
     * 根据信息获取区域管理信息单个对象
     * @param district 区域管理信息
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/selectOne")
    District selectOne(@RequestPart("district") District district);

    /**
     * 根据信息获取区域管理信息列表
     * @param district 区域管理信息
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/select")
    List<District> select(@RequestPart("district") District district);

    /**
     * 根据信息获取区域管理分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getPage")
    PageResultVo<District> getPage(@RequestPart("district") District district,
                                   @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);

    /**
     * 根据信息获取区域树
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getTree")
    PageResultVo<District> getTree();

    /**
     * 根据信息获取自定子节点下的区域树
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getTreeByParentCode")
    PageResultVo<District> getTreeByParentCode(Integer parentCode);

    /**
     * 根据信息获取区域部门树
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getTreeWithDept")
    PageResultVo<District> getTreeWithDept();

    /**
     * 根据信息获取自定子节点下的区域部门树
     * @return
     */
    @GetMapping(value = "/innerApi/user/districtApi/getTreeWithDeptByParentCode")
    PageResultVo<District> getTreeWithDeptByParentCode(Integer parentCode);
}
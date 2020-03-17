package com.userManager.user.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.TreeVo;
import com.userManager.user.entity.District;
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
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
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

    /**
     * 节点移动到指定的位置
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     * @param nextNodeId 移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点
     * @return
     */
    @RequestLine(value = "PUT /innerApi/user/districtApi/move")
    boolean move(@Param("id") Integer id,
                 @Param("newParentId") Integer newParentId,
                 @Param("nextNodeId")  Integer nextNodeId);

    /**
     * 根据信息获取区域树
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/districtApi/getTree")
    TreeVo<String> getTree();

    /**
     * 根据信息获取自定子节点下的区域树
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/districtApi/getTreeByParentCode")
    TreeVo<String> getTreeByParentCode(@Param("parentCode") Integer parentCode);

    /**
     * 根据信息获取区域部门树
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/districtApi/getTreeWithDept")
    TreeVo<String> getTreeWithDept();

    /**
     * 根据信息获取自定子节点下的区域部门树
     * @return
     */
    @RequestLine(value = "GET /innerApi/user/districtApi/getTreeWithDeptByParentCode")
    TreeVo<String> getTreeWithDeptByParentCode(@Param("parentCode") Integer parentCode);

}
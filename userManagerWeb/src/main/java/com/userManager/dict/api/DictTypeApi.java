package com.userManager.dict.api;

import com.userManager.dict.entity.DictType;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 字典类型表对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "${serviceName.gateway}/${serviceName.userManage}")
public interface DictTypeApi{
    /**
     * 根据 id 获取字典类型表信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/dict/dictTypeApi/getById")
    DictType getById(@Param("id") String id);

    /**
     * 根据 id 删除字典类型表信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/dict/dictTypeApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增字典类型表信息
     * @param dictType 字典类型表信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/dict/dictTypeApi/save")
    boolean save(@Param("dictType") DictType dictType);

    /**
     * 更新字典类型表信息
     * @param dictType 字典类型表信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/dict/dictTypeApi/updateById")
    boolean updateById(@Param("dictType") DictType dictType);

    /**
     * 根据信息获取字典类型表信息单个对象
     * @param dictType 字典类型表信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/dict/dictTypeApi/selectOne")
    DictType selectOne(@Param("dictType") DictType dictType);

    /**
     * 根据信息获取字典类型表信息列表
     * @param dictType 字典类型表信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/dict/dictTypeApi/select")
    List<DictType> select(@Param("dictType") DictType dictType);

    /**
     * 根据信息获取字典类型表分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/dict/dictTypeApi/getPage")
    PageResultVo<DictType> getPage(@Param("dictType") DictType dictType, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
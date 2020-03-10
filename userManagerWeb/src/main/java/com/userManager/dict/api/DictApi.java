package com.userManager.dict.api;

import com.userManager.dict.entity.Dict;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import java.util.List;

/**
 * 字典对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@FeignClient(name = "USER-MANAGER-SERVER")
public interface DictApi{
    /**
     * 根据 id 获取字典信息
     * @param id
     * @return
     */
    @RequestLine(value = "GET /innerApi/dict/dictApi/getById")
    Dict getById(@Param("id") String id);

    /**
     * 根据 id 删除字典信息
     * @param id
     * @return
     */
    @RequestLine(value = "DELETE /innerApi/dict/dictApi/removeById")
    boolean removeById(@Param("id") String id);

    /**
     * 新增字典信息
     * @param dict 字典信息
     * @return
     */
    @RequestLine(value = "PUT /innerApi/dict/dictApi/save")
    boolean save(@Param("dict") Dict dict);

    /**
     * 更新字典信息
     * @param dict 字典信息
     * @return
     */
    @RequestLine(value = "POST /innerApi/dict/dictApi/updateById")
    boolean updateById(@Param("dict") Dict dict);

    /**
     * 根据信息获取字典信息单个对象
     * @param dict 字典信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/dict/dictApi/selectOne")
    Dict selectOne(@Param("dict") Dict dict);

    /**
     * 根据信息获取字典信息列表
     * @param dict 字典信息
     * @return
     */
    @RequestLine(value = "GET /innerApi/dict/dictApi/select")
    List<Dict> select(@Param("dict") Dict dict);

    /**
     * 根据信息获取字典分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @RequestLine(value = "GET /innerApi/dict/dictApi/getPage")
    PageResultVo<Dict> getPage(@Param("dict") Dict dict, @Param("pageParamsVo") PageParamsVo pageParamsVo);
}
package com.base.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;

import java.util.List;

/**
 * 基础Service
 * @author huangyujie
 * @version 2019/7/11
 */
public interface BaseService<T> extends IService<T> {
    /**
     * 查询单一的数据项
     * @param t
     * @return
     */
    T selectOne(T t);

    /**
     * 查询列表的数据项
     * @param t
     * @return
     */
    List<T> select(T t);

    /**
     * 分页操作
     * @param pageParamsVo
     * @return
     */
    PageResultVo<T> getPage(T t, PageParamsVo pageParamsVo);
}

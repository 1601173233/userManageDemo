package com.base.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.base.common.entity.BaseModel;
import com.base.common.mapper.BaseCommonMapper;
import com.base.common.service.BaseService;
import com.base.common.util.PageUtil;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;

import java.util.List;

/**
 * 基础Service实现类
 * @author huangyujie
 * @version 2019/7/11
 */
public class BaseServiceImpl<T extends BaseModel, MAPPER extends BaseCommonMapper<T>>
        extends ServiceImpl<MAPPER, T> implements BaseService<T> {

    @Override
    public T selectOne(T t){
        QueryWrapper<T> queryWrapper = new QueryWrapper<>(t);
        return getOne(queryWrapper);
    }

    @Override
    public List<T> select(T t){
        QueryWrapper<T> queryWrapper = new QueryWrapper<>(t);
        return list(queryWrapper);
    }

    @Override
    public PageResultVo<T> getPage(T t, PageParamsVo pageParamsVo){
        IPage<T> page = PageUtil.getPage(pageParamsVo);
        QueryWrapper<T> queryWrapper = new QueryWrapper<>(t);
        page = page(page, queryWrapper);
        return PageUtil.getPageResultVo(pageParamsVo, page);
    }
}

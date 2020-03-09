package com.base.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;

/**
 * 分页工具类
 * @author huangyujie
 * @version 2019/5/8
 */
public class PageUtil {
    /**
     * 创造不用分页的参数
     */
    public static PageParamsVo createNoPageParams(){
        PageParamsVo pageParamsVo = new PageParamsVo();
        pageParamsVo.setIsPage(false);
        return pageParamsVo;
    }

    /**
     * 创造不用分页的参数
     */
    public static IPage createNoPage(){
        return getPage(createNoPageParams());
    }

    /**
     * 启动分页
     *
     * @param pageParamsVo 分页参数
     */
    public static IPage getPage(PageParamsVo pageParamsVo){
        // 需要分页的话,默认空为需要分页
        if(pageParamsVo.getIsPage() == null || pageParamsVo.getIsPage()) {
            Page page = new Page(pageParamsVo.getPageNo(), pageParamsVo.getPageSize());
            return page;
        }

        Page page = new Page(0, -1);
        return page;
    }

    /**
     * 获取分页结果
     * @param pageParamsVo 分页参数(保留使用,允许后期生成不分页的结果,用于公用分页与不分页的处理方法)
     * @param page   分页结果
     * @return
     */
    public static <T extends Object> PageResultVo<T> getPageResultVo(PageParamsVo pageParamsVo,
                                                                  IPage<T> page){
        return new PageResultVo(page);
    }
}

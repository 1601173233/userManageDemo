package com.base.common.vo;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分页返回结果类
 *
 * @author hyj
 * 2019/04/23 14:22:43
 */
@Data
@ApiModel("分页返回结果")
public class PageResultVo<T> {
    /** 记录总数 */
    @ApiModelProperty(value="记录总数")
    Long count;

    /** 总页数 */
    @ApiModelProperty(value="总页数")
    Integer pageCount;

    /** 返回的列表结果 */
    @ApiModelProperty(value="列表结果")
    List<T> records;

    /**
     * 构造结果
     *
     */
    public PageResultVo() {

    }

    /**
     * 构造结果
     * @param page
     */
    public PageResultVo(IPage<T> page) {
        count = page.getTotal();
        pageCount = ((Long) page.getSize()).intValue();
        records = page.getRecords();
    }
}

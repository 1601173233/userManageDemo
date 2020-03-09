package com.base.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.base.common.util.GsonUtil;

/**
 * 分页查询参数
 *
 * @author hyj
 * 2019/04/23 14:22:43
 */
@ApiModel("分页请求参数")
@Data
public class PageParamsVo {
    /** 当前页码 */
    @ApiModelProperty(value="当前页码", required = true)
    Integer pageNo;

    /** 每页大小 */
    @ApiModelProperty(value="每页大小", required = true)
    Integer pageSize;

    /** 是否需要分页(导出excel的时候就不分页了) */
    Boolean isPage;
}

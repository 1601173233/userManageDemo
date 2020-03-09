package com.base.common.vo;

import com.base.common.enums.HttpCode;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 数据返回结构
 *
 * @author : huangyujie
 * @version : 2020年03月04日
 * @since
 */
@Data
@ApiModel("数据返回结构")
public class Response<T>{
    /** code */
    @ApiModelProperty(value="异常码")
    private int code;

    /** 返回参数 */
    @ApiModelProperty(value="返回参数")
    private T data;

    /**
     * 构造方法
     * @param httpCode
     */
    public Response(HttpCode httpCode){
        code = httpCode.getCode();
    }
}
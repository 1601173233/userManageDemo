package com.userManager.user.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 区域管理
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@ApiModel("区域管理")
public class District extends BaseModel{
    /** id */
    @ApiModelProperty(value="id")
    private Integer id;

    /** 编码 */
    @ApiModelProperty(value="编码")
    private String code;

    /** 区域名称 */
    @ApiModelProperty(value="区域名称")
    private String name;

    /** 排序号 */
    @ApiModelProperty(value="排序号")
    private Integer sortNum;

    /** 父区域编码 */
    @ApiModelProperty(value="父区域编码")
    private String parentCode;

    /** 删除标志（0：未删除，1：已删除） */
    @ApiModelProperty(value="删除标志（0：未删除，1：已删除）")
    private Integer delFlag;

    /** 创建时间 */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /** 创建人 */
    @ApiModelProperty(value="创建人")
    private Integer creator;

    /** 修改时间 */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /** 修改人 */
    @ApiModelProperty(value="修改人")
    private Integer modifier;

}
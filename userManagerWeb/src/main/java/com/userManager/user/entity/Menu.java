package com.userManager.user.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 菜单
 *
 * @author : huangyujie
 * @version : 2020年03月06日
 * @since
 */
@Data
@ApiModel("菜单")
public class Menu extends BaseModel{
    /** id */
    @ApiModelProperty(value="id")
    private Integer id;

    /** 菜单名称 */
    @ApiModelProperty(value="菜单名称")
    private String name;

    /** 链接 */
    @ApiModelProperty(value="链接")
    private String url;

    /** 图标名称 */
    @ApiModelProperty(value="图标名称")
    private String icon;

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
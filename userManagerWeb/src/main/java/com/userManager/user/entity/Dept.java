package com.userManager.user.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 部门
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@ApiModel("部门")
public class Dept extends BaseModel{
    /** id */
    @ApiModelProperty(value="id")
    private Integer id;

    /** 编码 */
    @ApiModelProperty(value="编码")
    private String code;

    /** 部门名称 */
    @ApiModelProperty(value="部门名称")
    private String name;

    /** 图标名称 */
    @ApiModelProperty(value="图标名称")
    private String icon;

    /** 父部门编码 */
    @ApiModelProperty(value="父部门编码")
    private String parentCode;

    /** 所属行政区编码 */
    @ApiModelProperty(value="所属行政区编码")
    private String districtCode;

    /** 父节点类型 */
    @ApiModelProperty(value="父节点类型")
    private Integer parentType;

    /** 排序号 */
    @ApiModelProperty(value="排序号")
    private Integer sortNum;

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
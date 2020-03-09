package com.userManager.user.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 部门角色
 *
 * @author : huangyujie
 * @version : 2020年03月06日
 * @since
 */
@Data
@ApiModel("部门角色")
public class DeptRole extends BaseModel{
    /** id */
    @ApiModelProperty(value="id")
    private Integer id;

    /** 部门Id */
    @ApiModelProperty(value="部门Id")
    private Integer deptId;

    /** 角色名称 */
    @ApiModelProperty(value="角色名称")
    private String name;

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
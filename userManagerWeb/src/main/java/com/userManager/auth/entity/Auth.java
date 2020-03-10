package com.userManager.auth.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
/**
 * 权限管理
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@ApiModel("权限管理")
public class Auth extends BaseModel{
    /** id */
    @ApiModelProperty(value="id")
    private Integer id;

    /** 权限名称 */
    @ApiModelProperty(value="权限名称")
    private String name;

    /** 菜单ID */
    @ApiModelProperty(value="菜单ID")
    private Integer menuId;

    /** 权限类型：1.系统权限,2.菜单权限 */
    @ApiModelProperty(value="权限类型：1.系统权限,2.菜单权限")
    private Integer authType;

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
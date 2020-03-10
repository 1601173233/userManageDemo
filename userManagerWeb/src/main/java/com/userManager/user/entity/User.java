package com.userManager.user.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 用户
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@ApiModel("用户")
public class User extends BaseModel{
    /** id */
    @ApiModelProperty(value="id")
    private Integer id;

    /** 用户名 */
    @ApiModelProperty(value="用户名")
    private String userName;

    /** 密码 */
    @ApiModelProperty(value="密码")
    private String password;

    /** 昵称 */
    @ApiModelProperty(value="昵称")
    private String nick;

    /** 用户类型（0：超管，1：普通用户） */
    @ApiModelProperty(value="用户类型（0：超管，1：普通用户）")
    private Integer userType;

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
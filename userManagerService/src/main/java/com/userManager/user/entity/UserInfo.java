package com.userManager.user.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 用户登录信息
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
public class UserInfo {
    /** id */
    @ApiModelProperty(value="id")
    private Integer id;

    /** 用户名 */
    @ApiModelProperty(value="用户名")
    private String userName;

    /** 昵称 */
    @ApiModelProperty(value="昵称")
    private String nick;

    /** 用户类型（0：超管，1：普通用户） */
    @ApiModelProperty(value="用户类型（0：超管，1：普通用户）")
    private Integer userType;
}
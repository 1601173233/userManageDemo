package com.userManager.user.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 * 用户的角色
 *
 * @author : huangyujie
 * @version : 2020年03月06日
 * @since
 */
@Data
@ApiModel("用户的角色")
public class UserRole extends BaseModel{
    /** 用户id */
    @ApiModelProperty(value="用户id")
    private Integer userId;

    /** 角色id */
    @ApiModelProperty(value="角色id")
    private Integer roleId;

}
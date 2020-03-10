package com.userManagerauth.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
/**
 * 角色授权表
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@ApiModel("角色授权表")
public class RoleAuth extends BaseModel{
    /** 权限ID */
    @ApiModelProperty(value="权限ID")
    private Integer authId;

    /** 角色ID */
    @ApiModelProperty(value="角色ID")
    private Integer roleId;

}
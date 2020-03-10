package com.userManager.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.common.entity.BaseModel;
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
@TableName("ROLE_AUTH")
public class RoleAuth extends BaseModel{
    /** 权限ID */
    @TableField("AUTH_ID")
    private Integer authId;

    /** 角色ID */
    @TableField("ROLE_ID")
    private Integer roleId;

}
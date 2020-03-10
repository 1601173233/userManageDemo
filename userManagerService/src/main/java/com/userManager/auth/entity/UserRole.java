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
 * 用户的角色
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@TableName("USER_ROLE")
public class UserRole extends BaseModel{
    /** 用户id */
    @TableField("USER_ID")
    private Integer userId;

    /** 角色id */
    @TableField("ROLE_ID")
    private Integer roleId;

}
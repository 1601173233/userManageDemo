package com.userManager.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.common.entity.BaseModel;
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
@TableName("USER")
public class User extends BaseModel{
    /** id */
    @TableId(value = "ID", type = IdType.AUTO)
    @TableField("ID")
    private Integer id;

    /** 用户名 */
    @TableField("USER_NAME")
    private String userName;

    /** 密码 */
    @TableField("PASSWORD")
    private String password;

    /** 昵称 */
    @TableField("NICK")
    private String nick;

    /** 用户类型（0：超管，1：普通用户） */
    @TableField("USER_TYPE")
    private Integer userType;

    /** 删除标志（0：未删除，1：已删除） */
    @TableLogic(value = "0", delval = "1")
    @TableField("DEL_FLAG")
    private Integer delFlag;

    /** 创建时间 */
    @TableField("CREATE_TIME")
    private Date createTime;

    /** 创建人 */
    @TableField("CREATOR")
    private Integer creator;

    /** 修改时间 */
    @TableField("UPDATE_TIME")
    private Date updateTime;

    /** 修改人 */
    @TableField("MODIFIER")
    private Integer modifier;

}
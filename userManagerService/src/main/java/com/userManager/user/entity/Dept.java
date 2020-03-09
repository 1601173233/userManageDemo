package com.userManager.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.base.common.entity.BaseModel;
import lombok.Data;

import java.util.Date;

/**
 * 部门
 *
 * @author : huangyujie
 * @version : 2020年03月06日
 * @since
 */
@Data
@TableName("DEPT")
public class Dept extends BaseModel{
    /** id */
    @TableId(value = "ID", type = IdType.AUTO)
    @TableField("ID")
    private Integer id;

    /** 部门名称 */
    @TableField("NAME")
    private String name;

    /** 图标名称 */
    @TableField("ICON")
    private String icon;

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
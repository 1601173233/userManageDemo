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
 * 角色
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@TableName("ROLE")
public class Role extends BaseModel{
    /** id */
    @TableId(value = "ID", type = IdType.AUTO)
    @TableField("ID")
    private Integer id;

    /** 角色名称 */
    @TableField("NAME")
    private String name;

    /** 部门Id */
    @TableField("DEPT_ID")
    private Integer deptId;

    /** 角色类型：1.系统角色,2.部门角色 */
    @TableField("ROLE_TYPE")
    private Integer roleType;

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
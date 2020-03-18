package com.userManager.auth.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.common.entity.BaseModel;
import lombok.Data;
/**
 * 用户的部门
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@TableName("USER_DEPT")
public class UserDept extends BaseModel{
    /** 用户Id */
    @TableId
    @TableField("USER_ID")
    private Integer userId;

    /** 单位id */
    @TableId
    @TableField("DEPT_ID")
    private Integer deptId;

}
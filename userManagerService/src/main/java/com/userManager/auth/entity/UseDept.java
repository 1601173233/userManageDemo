package com.userManagerauth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.base.common.entity.BaseModel;
import lombok.Data;
import java.util.Date;
/**
 * 用户的部门
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@TableName("USE_DEPT")
public class UseDept extends BaseModel{
    /** 用户Id */
    @TableField("USER_ID")
    private Integer userId;

    /** 单位id */
    @TableField("DEPT_ID")
    private Integer deptId;

}
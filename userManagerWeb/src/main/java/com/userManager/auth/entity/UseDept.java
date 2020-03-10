package com.userManager.auth.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
@ApiModel("用户的部门")
public class UseDept extends BaseModel{
    /** 用户Id */
    @ApiModelProperty(value="用户Id")
    private Integer userId;

    /** 单位id */
    @ApiModelProperty(value="单位id")
    private Integer deptId;

}
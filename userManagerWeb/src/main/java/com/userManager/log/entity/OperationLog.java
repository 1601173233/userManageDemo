package com.userManager.log.entity;

import com.base.common.entity.BaseModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
/**
 * 操作日志
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@ApiModel("操作日志")
public class OperationLog extends BaseModel{
    /** id */
    @ApiModelProperty(value="id")
    private Integer id;

    /** 被操作者ID */
    @ApiModelProperty(value="被操作者ID")
    private String subjectId;

    /** 操作ID */
    @ApiModelProperty(value="操作ID")
    private Integer operatedId;

    /** 操作类型:详细参见字典OPERATION_TYPE */
    @ApiModelProperty(value="操作类型:详细参见字典OPERATION_TYPE")
    private Integer operationType;

    /** 删除标志（0：未删除，1：已删除） */
    @ApiModelProperty(value="删除标志（0：未删除，1：已删除）")
    private Integer delFlag;

    /** 创建时间 */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /** 创建人 */
    @ApiModelProperty(value="创建人")
    private Integer creator;

    /** 修改时间 */
    @ApiModelProperty(value="修改时间")
    private Date updateTime;

    /** 修改人 */
    @ApiModelProperty(value="修改人")
    private Integer modifier;

}
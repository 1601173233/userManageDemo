package com.base.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.*;

/**
 * 树结构的返回结果类
 *
 * @author hyj
 * 2020/03/12 14:22:43
 */
@Data
@ApiModel("树结构的返回结果")
public class TreeVo<T> {
    /** id */
    @ApiModelProperty(value="id")
    String id;

    /** 当前节点名称 */
    @ApiModelProperty(value="当前节点名称")
    String name;

    /** 父节点ID */
    @ApiModelProperty(value="父节点ID")
    String parentId;

    /** 节点类型 */
    @ApiModelProperty(value="节点类型")
    String type;

    /** 父节点类型 */
    @ApiModelProperty(value="父节点类型")
    String parentType;

    /** 数据 */
    @ApiModelProperty(value="数据")
    T data;

    /** 排序号 */
    Integer sortNum;

    /** 返回的列表结果 */
    @ApiModelProperty(value="列表结果")
    List<TreeVo<T>> childrens;
}

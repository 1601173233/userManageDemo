package com.userManager.dict.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.base.common.entity.BaseModel;
import com.base.common.vo.TreeVo;
import com.userManager.dict.enums.DictNodeType;
import lombok.Data;

import java.util.Date;
/**
 * 字典类型表
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@TableName("DICT_TYPE")
public class DictType extends BaseModel{
    /** id */
    @TableId(value = "ID", type = IdType.AUTO)
    @TableField("ID")
    private Integer id;

    /** 字典类型名称 */
    @TableField("NAME")
    private String name;

    /** 字典类型编码 */
    @TableField("DICT_TYPE")
    private String dictType;

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

    /**
     * 构造树节点
     * @return
     */
    public TreeVo<Dict> convertTreeNode(){
        TreeVo<Dict> treeVo = new TreeVo<>();
        treeVo.setId("0"); // 默认为根节点
        treeVo.setName(name);
        treeVo.setParentId(null);
        treeVo.setSortNum(0);
        treeVo.setType(DictNodeType.DICT_TYPE.getCode().toString());
        treeVo.setParentType(DictNodeType.DICT_TYPE.getCode().toString());
        return treeVo;
    }

}
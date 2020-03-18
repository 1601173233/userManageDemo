package com.userManager.dict.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.base.common.entity.BaseModel;
import com.base.common.vo.TreeVo;
import com.userManager.dict.enums.DictNodeType;
import lombok.Data;

import java.util.Date;
/**
 * 字典
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@TableName("DICT")
public class Dict extends BaseModel{
    /** id */
    @TableId(value = "ID", type = IdType.AUTO)
    @TableField("ID")
    private Integer id;

    /** 字典名称 */
    @TableField("NAME")
    private String name;

    /** 编码 */
    @TableField("CODE")
    private String code;

    /** 自定义编码 */
    @TableField("CUST_CODE")
    private String custCode;

    /** 字典类型ID */
    @TableField("DICT_TYPE_ID")
    private Integer dictTypeId;

    /** 排序号 */
    @TableField("SORT_NUM")
    private Integer sortNum;

    /** 父字典编码 */
    @TableField("PARENT_CODE")
    private String parentCode;

    /** 字典描述 */
    @TableField("DESCRIBES")
    private String describes;

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

    /** 字典类型 */
    private String dictType;

    /** 字典类型描述 */
    private String dictTypeDesc;

    /**
     * 构造树节点
     * @return
     */
    public TreeVo<Dict> convertTreeNode(){
        TreeVo<Dict> treeVo = new TreeVo<>();
        treeVo.setId(code);
        treeVo.setName(name);
        treeVo.setParentId(parentCode);
        treeVo.setSortNum(sortNum);
        treeVo.setType(DictNodeType.DICT.getCode().toString());

        // 如果父字典编码为0，那么父节点是字典类型
        if(parentCode.equals("0")) {
            treeVo.setParentType(DictNodeType.DICT_TYPE.getCode().toString());
        }else{
            treeVo.setParentType(DictNodeType.DICT.getCode().toString());
        }

        treeVo.setData(this);
        return treeVo;
    }
}
package com.userManager.menu.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.base.common.entity.BaseModel;
import com.base.common.vo.TreeVo;
import com.userManager.dict.enums.DictNodeType;
import lombok.Data;

import java.util.Date;
/**
 * 菜单
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@TableName("MENU")
public class Menu extends BaseModel{
    /** id */
    @TableId(value = "ID", type = IdType.AUTO)
    @TableField("ID")
    private Integer id;

    /** 编码 */
    @TableField("CODE")
    private String code;

    /** 菜单名称 */
    @TableField("NAME")
    private String name;

    /** 链接 */
    @TableField("URL")
    private String url;

    /** 图标名称 */
    @TableField("ICON")
    private String icon;

    /** 排序号 */
    @TableField("SORT_NUM")
    private Integer sortNum;

    /** 父菜单编码 */
    @TableField("PARENT_CODE")
    private String parentCode;

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
    public TreeVo<Menu> convertTreeNode(){
        TreeVo<Menu> treeVo = new TreeVo<>();
        treeVo.setId(code);
        treeVo.setName(name);
        treeVo.setParentId(parentCode);
        treeVo.setSortNum(sortNum);
        treeVo.setData(this);
        return treeVo;
    }
}
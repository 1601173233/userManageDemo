package com.userManager.user.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.base.common.entity.BaseModel;
import com.base.common.vo.TreeVo;
import com.userManager.user.enums.DeptNodeType;
import lombok.Data;

import java.util.Date;
/**
 * 部门
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Data
@TableName("DEPT")
public class Dept extends BaseModel{
    /** id */
    @TableId(value = "ID", type = IdType.AUTO)
    @TableField("ID")
    private Integer id;

    /** 编码 */
    @TableField("CODE")
    private String code;

    /** 部门名称 */
    @TableField("NAME")
    private String name;

    /** 图标名称 */
    @TableField("ICON")
    private String icon;

    /** 排序号 */
    @TableField("SORT_NUM")
    private Integer sortNum;

    /** 父节点类型 */
    @TableField("PARENT_TYPE")
    private Integer parentType;

    /** 父部门编码 */
    @TableField("PARENT_CODE")
    private String parentCode;

    /** 所属行政区编码 */
    @TableField("DISTRICT_CODE")
    private String districtCode;

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
    public TreeVo<String> convertTreeNode(){
        TreeVo<String> treeVo = new TreeVo<>();
        treeVo.setId(code);
        treeVo.setName(name);
        treeVo.setSortNum(sortNum);
        treeVo.setType(DeptNodeType.DEPT.getCode().toString());
        treeVo.setData(id.toString());

        // 如果父部门编码为0，那么父节点是区域，否则是部门
        if(parentCode.equals("0")) {
            treeVo.setParentId(districtCode);
            treeVo.setParentType(DeptNodeType.DISTRICT.getCode().toString());
        }else{
            treeVo.setParentId(parentCode);
            treeVo.setParentType(DeptNodeType.DEPT.getCode().toString());
        }

        return treeVo;
    }

}
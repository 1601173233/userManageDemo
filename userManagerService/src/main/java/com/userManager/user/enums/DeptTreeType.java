package com.userManager.user.enums;

/**
 * 部门树节点类型
 *
 * @author huangyujie
 * @version 2019/7/11
 */
public enum DeptTreeType {
    /** 行政区 */
    DISTRICT("1"),
    /** 部门 */
    DEPT("2");

    /**
     * 构造方法
     * @param code
     */
    DeptTreeType(String code){
        this.code = code;
    }

    /** 返回编码 */
    private String code;

    /**
     * 返回编码
     * @return
     */
    public String getCode(){
        return code;
    }
}

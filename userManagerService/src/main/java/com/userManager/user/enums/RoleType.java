package com.userManager.user.enums;

/**
 * 角色类型
 *
 * @author huangyujie
 * @version 2019/7/11
 */
public enum RoleType {
    /** 系统角色 */
    SYSTEM(1),
    /** 部门角色 */
    DEPT(2);

    /**
     * 构造方法
     * @param code
     */
    RoleType(Integer code){
        this.code = code;
    }

    /** 返回编码 */
    private Integer code;

    /**
     * 返回编码
     * @return
     */
    public Integer getCode(){
        return code;
    }
}

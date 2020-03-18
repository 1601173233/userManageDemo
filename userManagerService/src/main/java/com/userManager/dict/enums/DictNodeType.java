package com.userManager.dict.enums;

/**
 * 字典树节点类型
 *
 * @author huangyujie
 * @version 2019/7/11
 */
public enum DictNodeType {
    /** 字典类型 */
    DICT_TYPE(1),
    /** 字典 */
    DICT(2);

    /**
     * 构造方法
     * @param code
     */
    DictNodeType(Integer code){
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

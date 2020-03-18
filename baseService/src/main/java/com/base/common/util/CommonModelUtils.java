package com.base.common.util;

/**
 * 模型对象常用计算类
 * @author huangyujie
 * @version 2020/03/18
 */
public class CommonModelUtils {
    /**
     * 计算下一个树节点编码
     *
     * @param maxCode 当前最大树节点编码
     * @return
     */
    public static String getNextCode(String parentCode, String maxCode){
        String nextCode = maxCode;

        // 如果当前父节点不存在子节点
        if(nextCode == null){
            // 如果父节点是默认节点
            if(parentCode.equals("0")){
                nextCode = "01";
            }else{
                nextCode = parentCode + "01";
            }
        }else{
            // 否则节点序号 + 1
            Integer nextCodeNum = Integer.parseInt(nextCode.substring(nextCode.length() - 2, nextCode.length()));
            nextCodeNum = nextCodeNum + 1;
            nextCode = nextCodeNum >= 10 ? nextCodeNum.toString() : "0" + nextCodeNum;

            // 把父节点序号补充回去
            if(!parentCode.equals("0")){
                nextCode = parentCode + nextCode;
            }
        }

        return nextCode;
    }
}

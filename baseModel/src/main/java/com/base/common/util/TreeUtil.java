package com.base.common.util;

import com.base.common.vo.TreeVo;

import java.util.*;

/**
 * 树操作类
 * @author huangyujie
 * @version 2020/03/12
 */
public class TreeUtil {
    /**
     * 数据构造树结构
     * @param treeVoList 数据列表
     * @param parentId 父节点id
     */
    public static <T> List<TreeVo<T>> bulidTree(List<TreeVo<T>> treeVoList, String parentId){
        return bulidTree(treeVoList, parentId, null, false);
    }

    /**
     * 数据构造树结构
     * 不需要根据类型判断
     * @param treeVoList 数据列表
     * @param parentId 父节点id
     * @param isSort 是否根据排序号进行排序
     */
    public static <T> List<TreeVo<T>> bulidTree(List<TreeVo<T>> treeVoList, String parentId, Boolean isSort){
        return bulidTree(treeVoList, parentId, null, isSort);
    }

    /**
     * 数据构造树结构
     * 默认不排序
     * @param treeVoList 数据列表
     * @param parentId 父节点id
     * @param parentType 父节点类型
     */
    public static <T> List<TreeVo<T>> bulidTree(List<TreeVo<T>> treeVoList, String parentId, String parentType){
        return bulidTree(treeVoList, parentId, parentType, false);
    }

    /**
     * 数据构造树结构
     * @param treeVoList 数据列表
     * @param parentId 父节点id
     * @param parentType 父节点类型
     * @param isSort 是否根据排序号进行排序
     */
    public static <T> List<TreeVo<T>> bulidTree(List<TreeVo<T>> treeVoList, String parentId, String parentType, Boolean isSort){
        List<TreeVo<T>> resultList;

        // 如果没有指定对应的父节点类型，那么默认整个树构造不需要判断节点类型
        boolean hasParentType = true;
        String defaultParentType = "0";
        if(parentType == null){
            hasParentType = false;
            parentType = "0";
        }

        // 如果需要排序
        if(isSort){
            Collections.sort(treeVoList, (o1, o2) -> {return o1.getSortNum().compareTo(o2.getSortNum());});
        }

        // 父节点类型 - 父节点Id - 对象
        Map<String, Map<String, List<TreeVo<T>>>> dataTypeMap = new HashMap<>();
        for(TreeVo treeVo : treeVoList){

            // 获取当前节点类型的数据
            Map<String, List<TreeVo<T>>> dataMap;

            // 如果存在父节点类型
            if(hasParentType) {
                dataMap = dataTypeMap.get(treeVo.getParentType());

                if (dataMap == null) {
                    dataMap = new HashMap<>();
                    dataTypeMap.put(treeVo.getParentType(), dataMap);
                }
            }else{
                dataMap = dataTypeMap.get(defaultParentType);

                if (dataMap == null) {
                    dataMap = new HashMap<>();
                    dataTypeMap.put(defaultParentType, dataMap);
                }
            }

            List<TreeVo<T>> dataList = dataMap.get(treeVo.getParentId());

            if(dataList == null){
                dataList = new ArrayList<>();
                dataMap.put(treeVo.getParentId(), dataList);
            }

            dataList.add(treeVo);
        }

        // 获取父节点，如果不存在，直接返回空数组
        resultList = dataTypeMap.get(parentType).get(parentId);
        if(resultList == null){
            return new ArrayList<>();
        }

        // 模拟递归的方式，先把当前的所有节点进行循环，同时记录所有的子节点，扫描完当前节点后，再次扫描本次添加的所有子节点。
        // 已经加到树里面去的所有节点，用于循环构造树
        List<TreeVo<T>> hasAddList = new ArrayList<>();
        hasAddList.addAll(resultList);

        // 添加的子节点
        List<TreeVo<T>> childrenAddList = new ArrayList<>();
        while(true) {
            Iterator<TreeVo<T>> iterator = hasAddList.iterator();
            // 循环把数据构造为树
            while (iterator.hasNext()) {
                TreeVo treeVo = iterator.next();
                if (hasParentType) {
                    treeVo.setChildrens(dataTypeMap.get(treeVo.getType()).get(treeVo.getId()));
                } else {
                    treeVo.setChildrens(dataTypeMap.get(defaultParentType).get(treeVo.getId()));
                }

                if (treeVo.getChildrens() == null) {
                    treeVo.setChildrens(new ArrayList<T>());
                }

                // 把所有添加的子节点都记录起来,用于下一轮构造
                childrenAddList.addAll(treeVo.getChildrens());
            }

            // 当没有添加任何子节点的时候，跳出循环
            if(childrenAddList.isEmpty()){
                break;
            }else{
                // 扫描本次添加的所有子节点
                hasAddList.clear();
                hasAddList = childrenAddList;
                childrenAddList = new ArrayList<>();
            }
        }

        // 显示释放所有数据
        dataTypeMap.clear();

        return resultList;
    }
}

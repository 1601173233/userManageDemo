package com.userManager.dict.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.common.service.impl.BaseServiceImpl;
import com.base.common.util.CommonModelUtils;
import com.base.common.util.TreeUtil;
import com.base.common.vo.TreeVo;
import com.userManager.dict.entity.Dict;
import com.userManager.dict.entity.DictType;
import com.userManager.dict.mapper.DictMapper;
import com.userManager.dict.service.DictService;
import com.userManager.dict.service.DictTypeService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 字典服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class DictServiceImpl
        extends BaseServiceImpl<DictMapper, Dict> implements DictService {

    @Autowired
    DictTypeService dictTypeService;

    @Override
    public Dict getByCode(String code){
        Dict dict = new Dict();
        dict.setCode(code);
        return getOne(new QueryWrapper<>(dict));
    }

    @Override
    public boolean save(Dict dict){
        // 如果父节点不存在，那么就取默认的父节点
        if(StringUtils.isEmpty(dict.getParentCode())){
            dict.setParentCode("0");
        }

        dict.setCode(getNextCode(dict.getParentCode()));
        dict.setSortNum(getNextSortNum(dict.getParentCode()));
        return super.save(dict);
    }

    /**
     * 根据父节点编码获取下一个节点的编码
     * @param parentCode
     * @return
     */
    public String getNextCode(String parentCode){
        String maxCode = baseMapper.getMaxCodeByParentCode(parentCode);
        return CommonModelUtils.getNextCode(parentCode, maxCode);
    }

    /**
     * 根据父节点编码获取下一个节点的编码
     * @param parentCode
     * @return
     */
    public Integer getNextSortNum(String parentCode){
        Integer maxSortNum = baseMapper.getMaxSortNumByParentCode(parentCode);
        if(maxSortNum == null){
            maxSortNum = 0;
        }

        return maxSortNum + 1;
    }

    @Override
    public boolean move(Integer id, Integer newParentId, Integer nextNodeId) {
        Dict dict, nextDict;
        boolean isChangeParent = false; // 是否修改了父节点

        dict = getById(id);

        // 获取父节点编码
        String parentCode;
        // 如果父节点是根节点的话
        if(newParentId == null || newParentId == 0){
            parentCode = "0";
        }else{
            Dict parentDict = getById(newParentId);
            parentCode = parentDict.getCode();
        }

        // 如果父节点发生了改变的话
        if(!parentCode.equals(dict.getParentCode())){
            String oldCode = dict.getCode();

            // 当前节点以及所有子孙节点的编码都需要发生改变
            dict.setCode(getNextCode(parentCode));

            // 更新所有的子节点
            baseMapper.updateSonCode(oldCode, dict.getCode());

            dict.setParentCode(parentCode);

            // 标示为修改了父节点
            isChangeParent = true;
        }

        // 如果当前节点是最后一个节点
        if(nextNodeId == null){
            dict.setSortNum(getNextSortNum(dict.getParentCode()));
        }else{
            // 获取后一个节点原来的排序号
            nextDict = getById(nextNodeId);
            Integer nextDictSortNum = nextDict.getSortNum();
            Integer oldSortNum = dict.getSortNum(); // 被移动节点的原有排序号

            // 如果修改了父节点，那么原有排序号为当前父节点的新的排序号
            if(isChangeParent){
                oldSortNum = getNextSortNum(parentCode);
            }

            // 如果是向前移动
            if(oldSortNum > nextDictSortNum){
                // 新节点位置到原来节点位置中间的所有节点的所有排序号都 + 1
                baseMapper.updateOtherNodeSort(parentCode, nextDictSortNum, oldSortNum - 1, 1);

                // 当前节点的排序号等于后一个节点排序号
                dict.setSortNum(nextDictSortNum);
            }else{
                // 新节点位置到原来节点位置中间的所有节点的所有排序号都 - 1
                baseMapper.updateOtherNodeSort(parentCode, oldSortNum, nextDictSortNum - 1, -1);

                // 当前节点的排序号等于后一个节点排序号 - 1
                dict.setSortNum(nextDictSortNum - 1);
            }

        }
        return updateById(dict);
    }

    @Override
    public TreeVo<Dict> getTreeByDictType(String type) {
        DictType dictType = new DictType();
        dictType.setDictType(type);
        dictType = dictTypeService.selectOne(dictType);
        if(dictType == null){
            return null;
        }

        // 类型节点做根节点
        TreeVo<Dict> parentTreeVo = dictType.convertTreeNode();

        Dict dict = new Dict();
        dict.setDictTypeId(dictType.getId());
        List<Dict> dictList = select(dict);
        List<TreeVo<Dict>> dictTreeVoList = new ArrayList<>(dictList.size());
        for(Dict mDict : dictList){
            mDict.setDictType(dictType.getDictType());
            mDict.setDictTypeDesc(dictType.getName());
            dictTreeVoList.add(mDict.convertTreeNode());
        }

        // 构造为树结构
        dictTreeVoList = TreeUtil.bulidTree(dictTreeVoList, "0");
        parentTreeVo.setChildrens(dictTreeVoList);
        return parentTreeVo;
    }
}
package com.userManager.user.mapper;

import com.userManager.user.entity.District;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.base.common.mapper.BaseCommonMapper;

/**
 * 区域管理持久层接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Component
public interface DistrictMapper extends BaseCommonMapper<District>{
    /**
     * 获取父节点对应的最大节点编码
     */
    String getMaxCodeByParentCode(String parentCode);

    /**
     * 获取父节点对应的最大排序号
     */
    Integer getMaxSortNumByParentCode(String parentCode);

    /**
     * 更新所有子节点的编码以及对应的父编码1
     * @param oldParentCode 旧的父编码
     * @param newParentCode 新的父编码
     */
    void updateSonCode(@Param("oldParentCode") String oldParentCode, @Param("newParentCode") String newParentCode);

    /**
     * 更新所有节点的排序号
     * @param startSortNum 开始的排序号
     * @param endSortNum 结束的排序号
     * @param increaseCount 修改量
     */
    void updateOtherNodeSort(@Param("parentCode") String parentCode,
                             @Param("startSortNum") Integer startSortNum,
                             @Param("endSortNum") Integer endSortNum,
                             @Param("increaseCount") int increaseCount);
}
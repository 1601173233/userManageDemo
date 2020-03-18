package com.userManager.auth.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.base.common.service.impl.BaseServiceImpl;
import com.base.common.util.ExceptionUtil;
import com.userManager.auth.entity.RoleAuth;
import com.userManager.auth.mapper.RoleAuthMapper;
import com.userManager.auth.service.RoleAuthService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色授权表服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class RoleAuthServiceImpl
        extends BaseServiceImpl<RoleAuthMapper, RoleAuth> implements RoleAuthService {

    @Value("${userManagerService.mybatisBatchSize}")
    private Integer mybatisBatchSize;


    @Override
    public List<RoleAuth> selectByRoleId(Integer roleId) {
        if(roleId == null){
            ExceptionUtil.validError("角色ID不能为空！");
        }

        RoleAuth roleAuth = new RoleAuth();
        roleAuth.setRoleId(roleId);
        return select(roleAuth);
    }

    @Override
    public Boolean setAuth(Integer roleId, List<Integer> authIdList) {
        if(roleId == null){
            ExceptionUtil.validError("角色ID不能为空！");
        }

        RoleAuth roleAuth = new RoleAuth();
        roleAuth.setRoleId(roleId);

        // 先删除原来所有的权限
        Wrapper<RoleAuth> roleAuthWrapper = new QueryWrapper<>(roleAuth);
        remove(roleAuthWrapper);

        List<RoleAuth> roleAuthList = new ArrayList<>(authIdList.size());
        for(Integer authId : authIdList){
            RoleAuth mRoleAuth = new RoleAuth();
            mRoleAuth.setRoleId(roleId);
            mRoleAuth.setAuthId(authId);
            roleAuthList.add(mRoleAuth);
        }

        // 把数据批量插入
        return saveBatch(roleAuthList, mybatisBatchSize);
    }
}
package com.userManager.user.service.impl;

import com.base.common.service.impl.BaseServiceImpl;
import com.userManager.user.entity.User;
import com.userManager.user.mapper.UserMapper;
import com.userManager.user.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@Service
public class UserServiceImpl
        extends BaseServiceImpl<UserMapper, User> implements UserService {


    @Override
    public List<User> selectByUserIdList(List<Integer> userIdList) {
        return baseMapper.selectBatchIds(userIdList);
    }
}
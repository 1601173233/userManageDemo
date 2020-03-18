package com.userManager.user.service;

import com.base.common.service.BaseService;
import com.userManager.user.entity.User;

import java.util.List;

/**
 * 用户服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface UserService extends BaseService<User>{
    /**
     * 根据用户ID列表查询用户数据
     */
    List<User> selectByUserIdList(List<Integer> userIdList);

}
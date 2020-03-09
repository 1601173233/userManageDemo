package com.userManager.user.service.impl;

import com.base.common.service.impl.BaseServiceImpl;
import com.userManager.user.entity.Menu;
import com.userManager.user.mapper.MenuMapper;
import com.userManager.user.service.MenuService;
import org.springframework.stereotype.Service;

/**
 * 菜单服务接口
 *
 * @author : huangyujie
 * @version : 2020年03月06日
 * @since
 */
@Service
public class MenuServiceImpl
        extends BaseServiceImpl<Menu, MenuMapper> implements MenuService {


}
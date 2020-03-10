package com.userManager.auth.api;

import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.userManager.auth.entity.Auth;
import java.util.List;
import org.springframework.web.bind.annotation.*;

/**
 * 权限管理对外接口
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
public interface AuthApi{
    /**
     * 根据 id 获取权限管理信息
     * @param id
     * @return
     */
    @GetMapping(value = "/innerApi/auth/authApi/getById")
    Auth getById(String id);

    /**
     * 根据 id 删除权限管理信息
     * @param id
     * @return
     */
    @DeleteMapping(value = "/innerApi/auth/authApi/removeById")
    boolean removeById(String id);

    /**
     * 新增权限管理信息
     * @param auth 权限管理信息
     * @return
     */
    @PutMapping(value = "/innerApi/auth/authApi/save")
    boolean save(@RequestPart("auth") Auth auth);

    /**
     * 更新权限管理信息
     * @param auth 权限管理信息
     * @return
     */
    @PostMapping(value = "/innerApi/auth/authApi/updateById")
    boolean updateById(@RequestPart("auth") Auth auth);

    /**
     * 根据信息获取权限管理信息单个对象
     * @param auth 权限管理信息
     * @return
     */
    @GetMapping(value = "/innerApi/authApi/selectOne")
    Auth selectOne(@RequestPart("auth") Auth auth);

    /**
     * 根据信息获取权限管理信息列表
     * @param auth 权限管理信息
     * @return
     */
    @GetMapping(value = "/innerApi/auth/authApi/select")
    List<Auth> select(@RequestPart("auth") Auth auth);

    /**
     * 根据信息获取权限管理分页信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @GetMapping(value = "/innerApi/auth/authApi/getPage")
    PageResultVo<Auth> getPage(@RequestPart("auth") Auth auth,
                                            @RequestPart("pageParamsVo") PageParamsVo pageParamsVo);
}
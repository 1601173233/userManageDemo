package com.userManager.menu.controller;

import com.base.common.controller.BaseController;
import com.base.common.validType.Insert;
import com.base.common.validType.Update;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.Response;
import com.base.common.vo.TreeVo;
import com.userManager.dict.entity.Dict;
import com.userManager.menu.api.MenuApi;
import com.userManager.menu.entity.Menu;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 菜单表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/menu")
@RestController
@Slf4j
@Api(tags = "菜单管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class MenuController extends BaseController {
    /**
     * 菜单管理服务
     */
    @Autowired
    MenuApi menuApi;

    /**
     * 根据 id 获取菜单信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取菜单信息",notes = "根据 id 获取菜单信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<Menu>> getById(String id){
        log.info("根据 id 获取菜单信息");

        Menu result = menuApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除菜单信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除菜单信息",notes = "根据 id 删除菜单信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除菜单信息");

        // 删除对应的记录
        boolean result = menuApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增菜单信息
     * @param menu 菜单信息
     * @return
     */
    @ApiOperation(value = "新增菜单信息",notes = "新增菜单信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) Menu menu){
        log.info("新增菜单信息");

        // 新增一条记录
        boolean result = menuApi.save(menu);

        return updateResponse(result);
    }

    /**
     * 更新菜单信息
     * @param menu 菜单信息
     * @return
     */
    @ApiOperation(value = "更新菜单信息",notes = "更新菜单信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) Menu menu){
        log.info("更新菜单信息");

        // 新增一条记录
        boolean result = menuApi.updateById(menu);

        return updateResponse(result);
    }

    /**
     * 根据信息获取菜单信息单个对象
     * @param menu 菜单信息
     * @return
     */
    @ApiOperation(value = "根据信息获取菜单信息单个对象",notes = "根据信息获取菜单信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<Menu>> selectOne(Menu menu){
        log.info("根据信息获取菜单信息单个对象");

        // 根据信息获取菜单信息列表
        Menu entity = menuApi.selectOne(menu);

        return responseOk(entity);
    }

    /**
     * 根据信息获取菜单信息列表
     * @param menu 菜单信息
     * @return
     */
    @ApiOperation(value = "根据信息获取菜单信息列表",notes = "根据信息获取菜单信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<Menu>>> select(Menu menu){
        log.info("根据信息获取菜单信息列表");

        // 根据信息获取菜单信息列表
        List<Menu> list = menuApi.select(menu);

        return responseOk(list);
    }

    /**
     * 根据信息获取菜单分页信息
     * @param menu 菜单信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取菜单信息分页信息",notes = "根据信息获取菜单分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<Menu>>> getPage(Menu menu, PageParamsVo pageParamsVo){
        log.info("根据信息获取菜单分页信息");

        // 根据信息获取菜单分页信息
        PageResultVo<Menu> page = menuApi.getPage(menu, pageParamsVo);

        return responseOk(page);
    }

    /**
     * 节点移动到指定的父节点
     * @param id 移动的节点ID
     * @param newParentId 父节点ID
     */
    @ApiOperation(value = "节点移动到指定的父节点")
    @PutMapping("/move")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id", value ="移动的节点ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name="newParentId", value ="父节点ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name="nextNodeId", value ="移动后当前节点后一个节点的ID，空表示当前节点为最后一个节点", dataType = "int", paramType = "query")
    })
    public ResponseEntity<Response> move(Integer id, Integer newParentId, Integer nextNodeId){
        log.info("节点移动到指定的父节点：节点{},移动到{}的最后", id, newParentId);
        boolean result = menuApi.move(id, newParentId, nextNodeId);
        return updateResponse(result);
    }

    /**
     * 根据获取菜单树
     * @return
     */
    @ApiOperation(value = "根据获取菜单树")
    @GetMapping("/getTree")
    public ResponseEntity<Response<TreeVo<Menu>>> getTree(){
        log.info("根据获取菜单树");
        TreeVo<Menu> treeVo = menuApi.getTree();
        return responseOk(treeVo);
    }
}

package com.userManagerauth.controller;

import com.userManagerauth.entity.UseDept;
import com.userManagerauth.api.UseDeptApi;
import com.base.common.controller.BaseController;
import com.base.common.vo.PageParamsVo;
import com.base.common.vo.PageResultVo;
import com.base.common.vo.Response;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.base.common.validType.Insert;
import com.base.common.validType.Update;
import java.util.List;

/**
 * 用户的部门表控制层
 *
 * @author : huangyujie
 * @version : 2020年03月10日
 * @since
 */
@RequestMapping("${urlHead}/useDept")
@RestController
@Slf4j
@Api(tags = "用户的部门管理")
@ApiResponses({@ApiResponse(code = 500, message = "服务器内部错误")})
public class UseDeptController extends BaseController {
    /**
     * 用户的部门管理服务
     */
    @Autowired
    UseDeptApi useDeptApi;

    /**
     * 根据 id 获取用户的部门信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 获取用户的部门信息",notes = "根据 id 获取用户的部门信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @GetMapping("/getById")
    public ResponseEntity<Response<UseDept>> getById(String id){
        log.info("根据 id 获取用户的部门信息");

        UseDept result = useDeptApi.getById(id);

        // 根据id获取记录
        return responseOk(result);
    }

    /**
     * 根据 id 删除用户的部门信息
     * @param id
     * @return
     */
    @ApiOperation(value = "根据 id 删除用户的部门信息",notes = "根据 id 删除用户的部门信息")
    @ApiImplicitParam(name="id", value ="id", required = true, dataType = "String", paramType = "query")
    @DeleteMapping("/removeById")
    public ResponseEntity<Response> removeById(String id){
        log.info("根据 id 删除用户的部门信息");

        // 删除对应的记录
        boolean result = useDeptApi.removeById(id);

        return updateResponse(result);
    }

    /**
     * 新增用户的部门信息
     * @param useDept 用户的部门信息
     * @return
     */
    @ApiOperation(value = "新增用户的部门信息",notes = "新增用户的部门信息")
    @PostMapping("/save")
    public ResponseEntity<Response> save(@Validated({Insert.class}) UseDept useDept){
        log.info("新增用户的部门信息");

        // 新增一条记录
        boolean result = useDeptApi.save(useDept);

        return updateResponse(result);
    }

    /**
     * 更新用户的部门信息
     * @param useDept 用户的部门信息
     * @return
     */
    @ApiOperation(value = "更新用户的部门信息",notes = "更新用户的部门信息")
    @PutMapping("/updateById")
    public ResponseEntity<Response> updateById(@Validated({Update.class}) UseDept useDept){
        log.info("更新用户的部门信息");

        // 新增一条记录
        boolean result = useDeptApi.updateById(useDept);

        return updateResponse(result);
    }

    /**
     * 根据信息获取用户的部门信息单个对象
     * @param useDept 用户的部门信息
     * @return
     */
    @ApiOperation(value = "根据信息获取用户的部门信息单个对象",notes = "根据信息获取用户的部门信息单个对象")
    @GetMapping("/selectOne")
    public ResponseEntity<Response<UseDept>> selectOne(UseDept useDept){
        log.info("根据信息获取用户的部门信息单个对象");

        // 根据信息获取用户的部门信息列表
        UseDept entity = useDeptApi.selectOne(useDept);

        return responseOk(entity);
    }

    /**
     * 根据信息获取用户的部门信息列表
     * @param useDept 用户的部门信息
     * @return
     */
    @ApiOperation(value = "根据信息获取用户的部门信息列表",notes = "根据信息获取用户的部门信息列表")
    @GetMapping("/select")
    public ResponseEntity<Response<List<UseDept>>> select(UseDept useDept){
        log.info("根据信息获取用户的部门信息列表");

        // 根据信息获取用户的部门信息列表
        List<UseDept> list = useDeptApi.select(useDept);

        return responseOk(list);
    }

    /**
     * 根据信息获取用户的部门分页信息
     * @param useDept 用户的部门信息
     * @param pageParamsVo 分页参数
     * @return
     */
    @ApiOperation(value = "根据信息获取用户的部门信息分页信息",notes = "根据信息获取用户的部门分页信息")
    @GetMapping("/getPage")
    public ResponseEntity<Response<PageResultVo<UseDept>>> getPage(UseDept useDept, PageParamsVo pageParamsVo){
        log.info("根据信息获取用户的部门分页信息");

        // 根据信息获取用户的部门分页信息
        PageResultVo<UseDept> page = useDeptApi.getPage(useDept, pageParamsVo);

        return responseOk(page);
    }
}

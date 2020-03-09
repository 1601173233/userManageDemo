package com.base.common.controller;

import com.base.common.enums.HttpCode;
import com.base.common.vo.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 控制器基类,用于封装返回值和异常
 * @author huangyujie
 * @version 2019/7/11
 */
public class BaseController {
    /**
     * 返回结果
     * @param t
     * @return
     */
    protected <T>ResponseEntity<Response<T>> responseOk(T t) {
        Response<T> response = new Response<>(HttpCode.OK);
        response.setData(t);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    /**
     * 返回结果(更新)
     * @return
     */
    protected ResponseEntity<Response> updateResponse(int result) {
        /** 更新成功 */
        if(result > 1){
            return updateResponse(true);
        }else{
            return updateResponse(false);
        }
    }

    /**
     * 返回结果(更新)
     * @return
     */
    protected ResponseEntity<Response> updateResponse(boolean success) {
        Response response;

        // 如果更新到数据
        if(success) {
            response = new Response<>(HttpCode.OK);
        }else{
            // 否则提示校验失败
            response = new Response<>(HttpCode.VALID_ERROR);
        }

        return new ResponseEntity(response, HttpStatus.OK);
    }
}

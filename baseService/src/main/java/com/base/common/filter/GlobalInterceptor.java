//package com.base.common.filter;
//
//import com.baomidou.mybatisplus.extension.api.R;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.servlet.HandlerInterceptor;
//import sun.security.util.SecurityConstants;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//
///**
// *
// * @Description //TODO $全局过滤
// * @Date 21:35
// * @Author yzcheng90@qq.com
// * @From https://blog.csdn.net/qq_15273441/article/details/97939084
// **/
//@Slf4j
//public class GlobalInterceptor implements HandlerInterceptor {
//
//    @Getter
//    @Setter
//    private RedisUUIDUtils redisUUID;
//
//    @Getter
//    @Setter
//    private AuthIgnoreConfig authIgnoreConfig;
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
//        long exist =  authIgnoreConfig.getIgnoreUrls().stream().filter(url-> url.trim().equals(request.getRequestURI())).count();
//        if(exist != 0){
//            return true;
//        }
//        String secretKey = request.getHeader(SecurityConstants.SECRET_KEY);
//        if(StrUtil.isNotBlank(secretKey)){
//            String key = (String) redisUUID.get(SecurityConstants.SECRET_KEY);
//            if(!StrUtil.isBlank(key) && secretKey.equals(key)){
//                return true;
//            }
//        }
//        response.setContentType("application/json; charset=utf-8");
//        PrintWriter writer = response.getWriter();
//        writer.write(JSONUtil.toJsonStr(R.error("illegal request")));
//        return false;
//    }
//}
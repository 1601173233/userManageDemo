package com.userManager.common.util;

import com.userManager.log.api.OperationLogApi;
import com.userManager.log.entity.OperationLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 应用日志工具
 * @author huangyujie
 * @version 2020/03/18
 */
@Component
@Slf4j
public class SystemLogUtil {
    private static OperationLogApi operationLogApi;

    /**
     * 设置
     */
    @Autowired
    public static void setOperationLogApi(OperationLogApi operationLogApi) {
        SystemLogUtil.operationLogApi = operationLogApi;
    }

    /**
     * info日志
     */
    public static void info(Integer operatedId, Integer operationType, String msg, Object ... arg){
        // 输出到操作日志
        OperationLog operationLog = new OperationLog();
        operationLog.setOperationType(operationType);
        operationLog.setOperatedId(operatedId);
        operationLog.setMsg(msg);
        operationLogApi.save(operationLog);

        log.info(msg, arg);
    }

    /**
     * 日志信息格式化
     * @param str
     * @param args
     * @return
     */
    private static String format(String str, Object... args) {
        for (int i = 0; i < args.length; i++) {
            str = str.replaceFirst("\\{\\}", String.valueOf(args[i]));
        }
        return str;
    }
}

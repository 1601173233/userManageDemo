import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * Mybatics 判断函数
 * @author huangyujie
 * @version 2019/7/11
 */
public class Ognl {
    /**
     * 判断对象是否不为空(不允许字符串为空,或者容器为空)
     */
    public static boolean isNotEmpty(Object o){
        Boolean result = null;
        // 如果是字符串
        if (o instanceof CharSequence) {
            result = StringUtils.isNotEmpty((CharSequence) o);
        } else if (o instanceof List) {
            result = o != null && ((List) o).size() > 0;
        } else if (o instanceof Map) {
            result = o != null && ((Map) o).size() > 0;
        } else {
            result = o != null;
        }

        return result;
    }

    /**
     * 判断对象是否为空(isNotEmpty取反)
     */
    public static boolean isEmpty(Object o){
        return !isNotEmpty(o);
    }

    /**
     * 判断对象是否为空对象
     */
    public static boolean isNotNull(Object o){
        return o != null;
    }

    /**
     * 判断对象是否为空对象
     */
    public static boolean isNull(Object o){
        return o == null;
    }
}

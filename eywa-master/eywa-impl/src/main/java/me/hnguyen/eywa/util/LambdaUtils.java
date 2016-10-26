package me.hnguyen.eywa.util;

import java.util.function.BiFunction;

/**
 * @author hnguyen
 */
public class LambdaUtils {

    public static final BiFunction<Object, Object, Boolean> compare_object
        = (Object obj1, Object obj2) -> {
        if (obj1 == null && obj2 == null) {
            return true;
        } else if (obj1 != null) {
            return obj1.equals(obj2);
        } else {
            return obj2.equals(obj1);
        }
    };

}

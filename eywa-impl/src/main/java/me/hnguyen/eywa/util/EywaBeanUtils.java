package me.hnguyen.eywa.util;

import java.util.ArrayList;
import java.util.List;
import me.hnguyen.eywa.BaseDto;
import me.hnguyen.eywa.BaseEntity;
import me.hnguyen.eywa.config.bean.ConfigBean;
import org.springframework.beans.BeanUtils;

/**
 *
 * @author hnguyen
 */
public class EywaBeanUtils {

    public static <T extends BaseDto<E>, E extends BaseEntity<T>> List<T> toDto(List<E> entities) {
        List<T> dtos = new ArrayList<>();
        if (entities == null || entities.isEmpty()) {
            return dtos;
        }
        entities.stream().forEach((entity) -> {
            dtos.add(entity.toDto());
        });
        return dtos;
    }
    
    public static Object copyProperties(Object source, Object target){
        if(source==null){
            return null;
        }
        BeanUtils.copyProperties(source, target);
        return target;
    }

}

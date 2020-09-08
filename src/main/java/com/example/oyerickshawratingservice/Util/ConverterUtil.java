package com.example.oyerickshawratingservice.Util;

import org.springframework.beans.BeanUtils;

public class ConverterUtil {

    public static <T> T copyProperties(Object source, T destination, String... ignoreProperties) {
        BeanUtils.copyProperties(source, destination, ignoreProperties);
        return destination;
    }

    public static <T> T copyProperties(Object source, Class<T> destination, String... ignoreProperties) {
        T t = BeanUtils.instantiateClass(destination);
        return copyProperties(source, t, ignoreProperties);
    }

}

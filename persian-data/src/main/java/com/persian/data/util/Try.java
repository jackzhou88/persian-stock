package com.persian.data.util;

import java.util.Objects;
import java.util.function.Function;

/**
 * @author: dave01.zhou  Time: 2018/7/31 1:21
 */
public class Try {
    public static <T, R> Function<T, R> of(UncheckedFunction<T, R> mapper) {
        Objects.requireNonNull(mapper);
        return t -> {
            try {
                return mapper.apply(t);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static <T, R> Function<T, R> of(UncheckedFunction<T, R> mapper, R defaultR) {
        Objects.requireNonNull(mapper);
        return t -> {
            try {
                return mapper.apply(t);
            } catch (Exception ex) {
                System.err.println(ex.getMessage());
                return defaultR;
            }
        };
    }

}

package com.persian.data.util;

/**
 * @author: dave01.zhou  Time: 2018/7/31 1:17
 */
@FunctionalInterface
public interface UncheckedFunction<T, R> {
    R apply(T t) throws Exception;
}

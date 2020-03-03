package com.chen.java.lambda.stream;

import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

/**
 * @program: practice-pro
 * @class：BaseFilter
 * @description: 数据权限过滤
 * @author: lanlanhappy
 * @create: 02/19/2020 09:31:51
 **/
public interface BaseFilter {

    default Stream<String> filter(List<String> orList, List<String> auList){
//        return filter(orList, auList, auList.stream().filter());
        return Stream.empty();
    }
    default Stream<String> filter(List<String> orList, List<String> auList,
                          BiFunction<List<String>, List<String>, Stream<String>> filter){
        return filter.apply(orList, auList);
    }
}

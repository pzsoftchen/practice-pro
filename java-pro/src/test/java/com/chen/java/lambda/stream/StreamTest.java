package com.chen.java.lambda.stream;

import com.chen.java.lambda.Artist;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @program: practice-pro
 * @class：StreamTest
 * @description: Java8 Stream 测试
 * @author: lanlanhappy
 * @create: 02/08/2020 14:42:28
 **/
public class StreamTest {


    private List<Artist> artists;

    @Before
    public void init(){
        artists = new ArrayList<>();
        Artist artist = new Artist();
        artist.setName("王菲");
        artist.setOrigin("Beijing");
        artists.add(artist);
        Artist artist1 = new Artist();
        artist1.setName("刘德华");
        artist1.setOrigin("HongKong");
        artists.add(artist1);
        Artist artist2 = new Artist();
        artist2.setName("迈克");
        artist2.setOrigin("USA");
        artists.add(artist2);
    }
    /**
     * collect(toList())
     * 用于搜集 由 Stream 里的值生成一个列表
     * 寻找来自Beijing的歌手
     */
    @Test
    public void collect(){
        List<Artist> beijingArts = artists.stream().filter(artist -> artist.getOrigin().equalsIgnoreCase("Beijing")).collect(toList());
        beijingArts.forEach(e->{
            System.out.println(e.getName());
            System.out.println(e.getOrigin());
        });
    }

    /**
     * map 函数适用场景
     * 如果有一个函数可以将一种类型的值转换成另外一种类型，map 操作就可以 使用该函数，将一个流中的值转换成一个新的流
     * map函数可以将流中元素通过map逻辑转换成另外的元素，转换前后元素的类型可以不同
     * 测试场景，将给定集合的所有元素，转换成大写字母
     */
    @Test
    public void map(){

        List<String> strs = Stream.of("q","w","e","r","t","asdf")
                .map(String::toUpperCase)
                .collect(toList());
        strs.forEach(System.out::println);

        Stream.of('1','2','3','4','5')
                .map(String::valueOf)
                .mapToInt(Integer::parseInt)
                .mapToLong(i-> (long) i)
                .forEach(System.out::println);

    }

    /**
     * filter 函数适用场景
     * 通过函数名称，即可知道该函数的作用是通过一个指定的过滤的逻辑，将流中的元素按照指定的逻辑进行过滤
     * 过滤 含有字母a的元素
     */
    @Test
    public void filter(){
        List<String> strs = Stream.of("a","abc","what","how","why","have")
                .filter(str -> str.contains("a"))
                .collect(toList());
        strs.forEach(System.out::println);
    }

    /**
     * flatMap 方法可用 Stream 替换值，然后将多个 Stream 连接成一个 Stream
     *
     */
    @Test
    public void flatMap(){
        List<Integer> strs =
                Stream.of(Arrays.asList('1','2','3','4'),Arrays.asList('7','8','9'))
                .flatMap(Collection::stream)
                .map(String::valueOf)
                .map(Integer::parseInt)
                .collect(toList());

        strs.forEach(e->{
            System.out.println(e.getClass()+" : "+ e);
        });
    }

    @Test
    public void maxAndMin(){
        Integer maxOrMin = Stream.of(Arrays.asList('1','2','3','4'),Arrays.asList('7','8','9'))
                .flatMap(Collection::stream)
                .map(String::valueOf)
                .map(Integer::parseInt)
//                .max(Comparator.comparing(Integer::intValue))
                .min(Comparator.comparing(Integer::intValue))
                .get();
        System.out.println("maxOrMin: " + maxOrMin);
    }

    /**
     * reduce 操作可以实现从一组值中生成一个值
     */
    @Test
    public void reduce(){
        Integer maxOrMin = Stream.of(Arrays.asList('1','2','3','4'),Arrays.asList('7','8','9'))
                .flatMap(Collection::stream)
                .map(String::valueOf)
                .map(Integer::parseInt)
                .reduce(1, Math::max);
        System.out.println("maxOrMin: " + maxOrMin);
    }

}

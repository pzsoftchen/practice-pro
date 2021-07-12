package com.chen.java.practice.pattern.create.builder;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 4:30 下午
 */
public class BuilderTest {

    public static void main(String[] args) {
        User user = User.builder().userName("张三").password("123abc").build();
        System.out.println(user.toString());
    }
}

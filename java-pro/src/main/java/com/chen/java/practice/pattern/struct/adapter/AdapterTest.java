package com.chen.java.practice.pattern.struct.adapter;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 6:11 下午
 */
public class AdapterTest {

    public static void main(String[] args) {
        UserHandler userHandler = new UserHandler();
        UserHandlerAdapter adapter = new UserHandlerAdapter(userHandler);
        adapter.add(new UserDto("张三","abc"));
    }
}

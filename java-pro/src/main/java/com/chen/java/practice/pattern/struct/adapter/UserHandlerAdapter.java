package com.chen.java.practice.pattern.struct.adapter;

/**
 * description
 *
 * @author pengzhenchen 2021/06/25 6:10 下午
 */
public class UserHandlerAdapter {

    private UserHandler userHandler;

    public UserHandlerAdapter(UserHandler userHandler){
        this.userHandler = userHandler;
    }

    public void add(UserDto userDto){
        System.out.println(userDto.toString());
        UserBean userBean = new UserBean(userDto.getName(), userDto.getPwd());
        userHandler.add(userBean);
    }

}

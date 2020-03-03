package com.chen.java.lambda;

/**
 * @program: practice-pro
 * @class：Artist
 * @description: 创作音乐的个人或团体
 * @author: lanlanhappy
 * @create: 02/07/2020 23:52:29
 **/
public class Artist {

    /**
     * 歌手的名字或乐队的名称
     */
    private String name;
    /**
     * 乐队成员或为空
     */
    private String members;
    /**
     * 乐队来自与哪里比如：Beijing
     */
    private String origin;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMembers() {
        return members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}

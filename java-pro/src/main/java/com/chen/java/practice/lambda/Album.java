package com.chen.java.practice.lambda;

import java.util.List;

/**
 * @program: practice-pro
 * @class：Album
 * @description: 专辑
 * @author: lanlanhappy
 * @create: 02/07/2020 23:56:22
 **/
public class Album {

    /**
     * 专辑名称
     */
    private String name;
    /**
     * 专辑里的歌曲
     */
    private List<Track> tracks;
    /**
     * 参与制作专辑的人员列表
     */
    private List<Artist> musicians;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Artist> getMusicians() {
        return musicians;
    }

    public void setMusicians(List<Artist> musicians) {
        this.musicians = musicians;
    }
}

package com.chen.java.lambda.stream;

import com.chen.java.lambda.Album;
import com.chen.java.lambda.Artist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * @program: practice-pro
 * @class：StreamWork
 * @description: 练习题
 * @author: lanlanhappy
 * @create: 02/08/2020 16:50:40
 **/
public class StreamWork {

    public int addUp(Stream<Integer> stream){
        return stream.reduce(0, Integer::sum);
    }


    public List<String> getNameAndOrigin(List<Artist> artists){
        return artists
                .stream()
                .map(artist -> artist.getName()+" "+artist.getOrigin())
                .collect(toList());
    }

    public List<Album> getAlbums(List<Album> albums){
        return albums
                .stream()
                .filter(album -> album.getTracks().size() < 4)
                .collect(toList());
    }

    public long countLowerChars(String str){
        return str
                .chars()
                .mapToObj(String::valueOf)
                .filter(s -> s.equals(s.toLowerCase()))
                .count();

    }

}

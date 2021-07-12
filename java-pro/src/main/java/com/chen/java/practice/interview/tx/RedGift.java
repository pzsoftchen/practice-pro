package com.chen.java.practice.interview.tx;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  春节期间小明使用微信收到很多个红包，非常开心。在查看领取红包记录时发现，某个红包金额出现的次数超过了红包总数的一半。请帮小明找到该红包金额。写出具体算法思路和代码实现，要求算法尽可能高效。
 *  给定一个红包的金额数组gifts及它的大小n，请返回所求红包的金额。
 *  若没有金额超过总数的一半，返回0。
 *  测试：
 *  [1,2,3,2,2],5
 *  结果：
 *  2
 * </p>
 *
 * @author pengzhenchen 2021/06/19 10:20 下午
 */
public class RedGift {

    public static void main(String[] args) {
        System.out.println(gift(new int[]{1,2,3,2,2},5));
    }

    private static int gift(int[] gifts, int len){

        if (gifts.length == len) {
            Map<Integer, Integer> count = new HashMap<>(len);
            for (int i = 0; i < len; i++) {
                if (count.containsKey(gifts[i])) {
                    count.put(gifts[i], count.get(gifts[i]) + 1);
                } else {
                    count.put(gifts[i], 1);
                }
                if (count.get(gifts[i]) > len / 2) {
                    return gifts[i];
                }
            }
        }
        return 0;
    }
}


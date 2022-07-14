package org.leetcode.huiwen;

import com.sun.tools.javac.util.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuiWen {
    public static void main(String[] args) {
        String str = "Tact coa";

        boolean expect = huiwen(str);

        System.out.println(expect?"Yes":"No");
    }

    private static boolean huiwen(String str) {
        Map<String, Integer> map = new HashMap<>();

        // 统计字符出现次数
        char[] chars = str.toCharArray();
        for (char c : chars) {
            if (c != ' ') {
                String s = String.valueOf(c).toLowerCase();
                map.merge(s, 1, Integer::sum);
            }
        }

        // 最多一个字符出现单次，其他全部偶数次
        long count = map.entrySet().stream().filter(e -> e.getValue() % 2 != 0).count();

        return count <= 1;
    }
}

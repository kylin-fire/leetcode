package org.leetcode.pai;

import java.util.*;

public class Pai {
    public static void main(String[] args) {
        String s = "abcd";

        List<String> list = pai(s);

        list.stream().forEach(e -> System.out.println(e));
    }

    private static List<String> pai(String s) {
        List<String> list = new ArrayList<>();

        char[] chars = s.toCharArray();
        for (char c:chars) {
            list = insertList(list, String.valueOf(c));
        }

        return list;
    }

    private static List<String> insertList(List<String> list, String str) {
        List<String> result = new ArrayList<>();
        if (list.size() == 0) {
            result.add(str);
        } else {
            list.stream().forEach(e -> {
                List<String> newList = pai(e, str);
                result.addAll(newList);
            });
        }
        return result;
    }

    private static List<String> pai(String exist, String str) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i <= exist.length(); i++) {
            String prefix = exist.substring(0, i);
            String subfix = exist.substring(i);
            result.add(prefix + str + subfix);
        }
        return result;
    }
}

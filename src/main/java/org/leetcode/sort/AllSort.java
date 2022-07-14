package org.leetcode.sort;

import java.util.*;

public class AllSort {
    public static void main(String[] args) {
        String s = "abbc";
        String b = "cbabadcbbabbcbabaabccbabc";

        List<String> list = allSort(b, s);

        list.stream().forEach(e -> System.out.println(e));
    }

    private static List<String> allSort(String source, String target) {
        if (source == null || target == null || source.length() == 0 || target.length() == 0) {
            throw new IllegalArgumentException("parameter is blank");
        }
        List<String> result = new ArrayList<>();

        Set<Map.Entry<String, Integer>> expectEntries = toStringMap(target).entrySet();

        for (int i = 0; i <= (source.length() - target.length()); i++) {
            String substring = source.substring(i, i + target.length());

            Set<Map.Entry<String, Integer>> actualEntries = toStringMap(substring).entrySet();

            long count = expectEntries.stream().filter(e -> actualEntries.contains(e)).count();

            if (count == expectEntries.size()) {
                result.add(substring);
            }
        }

        return result;
    }

    private static Map<String, Integer> toStringMap(String str) {
        Map<String, Integer> map = new HashMap<>(str.length());

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            map.merge(s, 1, Integer::sum);
        }

        return map;
    }
}

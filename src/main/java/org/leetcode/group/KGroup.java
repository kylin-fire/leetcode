package org.leetcode.group;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KGroup {
    public static void main(String[] args) {
        int[] array = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;

        Map<Integer, Integer> map = group(array, k);

        map.entrySet().stream().forEach(e -> System.out.print("(" + e.getKey() + "," + e.getValue() + ") "));
    }

    private static Map<Integer, Integer> group(int[] array, int k) {
        if (array == null || array.length == 0) {
            return null;
        }
        int length = array.length;

        Map<Integer, Integer> map = new HashMap<>(length);

        Arrays.stream(array).forEach(e -> map.put(e,null));

        Map<Integer, Integer> result = new HashMap<>(length);
        map.entrySet().stream().filter(e -> map.containsKey(e.getKey() + k)).forEach(e -> {
            result.put(e.getKey(), e.getKey() + k);
        });

        return result;
    }
}

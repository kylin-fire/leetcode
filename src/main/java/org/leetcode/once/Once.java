package org.leetcode.once;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

public class Once {
    public static void main(String[] args) {
        String first = "pale";
        String second = "ple";

        boolean once = once(first, second);

        System.out.println(once ? "Yes" : "No");
    }

    private static boolean once(String first, String second) {
        int flength = first.length();
        int slength = second.length();

        if (Math.abs(flength - slength) > 1) {
            return false;
        }

        Set<String> firstMap = toString(first);
        Set<String> secondMap = toString(second);

        Set<String> collect = firstMap.stream().filter(e -> secondMap.contains(e)).collect(toSet());
        // 2+字符有差异
        if(firstMap.size()- collect.size()>1 || secondMap.size()- collect.size()>1){
            return false;
        }

        if(firstMap.size()-collect.size()==0){
            if(secondMap.size()-collect.size()==0){
                return true;
            } else { // ==1
                secondMap.removeAll(collect);

                secondMap.stream().forEach(e->{
                    second.in
                });
            }

        } else {

        }


        int gap = 0;


        return count <= 1;
    }

    private static Set<String> toString(String str) {
        Set<String> set = new HashSet<>(str.length());

        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            set.add(s);
        }

        return set;
    }
}

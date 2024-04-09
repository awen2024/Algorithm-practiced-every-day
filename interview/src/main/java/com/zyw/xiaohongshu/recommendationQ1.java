package com.zyw.xiaohongshu;

import java.util.*;

public class recommendationQ1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        while (in.hasNext()) {
            String str = in.next();
            if (map.containsKey(str)) {
                map.put(str, map.get(str) + 1);
            } else {
                map.put(str, 1);
            }
        }
        TreeMap<Integer, List> treeMap = new TreeMap<>(Comparator.reverseOrder());
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            if (value >= 3) {
                treeMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
            }
        }

        for (Integer key : treeMap.keySet()) {
            List<String> temp = treeMap.get(key);
            Collections.sort(temp);
            for (String str : temp) {
                System.out.println(str);
            }
        }
    }
}

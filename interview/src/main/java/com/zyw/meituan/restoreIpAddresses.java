package com.zyw.meituan;

import java.util.ArrayList;
import java.util.List;

public class restoreIpAddresses {
    List<String> temp = new ArrayList<>();
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return res;
        backTracing(s, 0);
        return res;
    }

    private void backTracing(String s, int startIndex) {
        if (temp.size() > 4) return;
        if (startIndex == s.length() && temp.size() == 4) {
            res.add(tempToStr());
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            String str = s.substring(startIndex, i + 1);
            if (!isValid(str)) {
                continue;
            }
            temp.add(str);
            backTracing(s, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    private boolean isValid(String s) {
        if (s.length() == 1) return true;
        if (s.length() > 3) return false;
        if (s.charAt(0) == '0') return false;
        if (Integer.valueOf(s) > 255) return false;
        return true;
    }

    private String tempToStr() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i < temp.size();i++){
            if (i != temp.size()) sb.append(temp.get(i)).append(".");
            else sb.append(temp.get(i));
        }
        return sb.toString();
    }
}

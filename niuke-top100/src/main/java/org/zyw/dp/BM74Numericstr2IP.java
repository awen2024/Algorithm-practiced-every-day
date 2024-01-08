package org.zyw.dp;

import java.util.ArrayList;
import java.util.List;

public class BM74Numericstr2IP {
    public ArrayList<String> restoreIpAddresses (String s) {
        // write code here
        ArrayList<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 1; i < 4 && i < n - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < n - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < n; k++) {
                    String a = s.substring(0, i), b = s.substring(i, j),
                            c = s.substring(j, k), d = s.substring(k, n);
                    if (isValid(a) && isValid(b) && isValid(c) && isValid(d)) {
                        res.add(a + "." + b + "." + c + "." + d);
                    }
                }
            }
        }
        return res;
    }

    private boolean isValid(String a) {
        if (a.length() > 1 && a.charAt(0) == '0') {
            return false;
        }
        return a.length() <= 3 && Integer.parseInt(a) <= 255;
    }
    // 回溯法+递归
    public List<String> restoreIpAddresses1(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, "", 0, result);
        return result;
    }

    private void backtrack(String s, int index, String currentIP, int dotCount, List<String> result) {
        // 判断是否达到了4个部分，并且用尽了所有字符
        if (dotCount == 4 && index == s.length()) {
            result.add(currentIP.substring(0, currentIP.length() - 1));
            return;
        }

        // 剪枝：如果剩余的部分太多或太少，不可能形成有效的IP地址
        if (dotCount >= 4 || index >= s.length()) return;

        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String part = s.substring(index, index + i);
            int val = Integer.parseInt(part);
            // 剪枝：数值必须在0到255之间，且不能有前导零
            if (val <= 255 && (i == 1 || part.charAt(0) != '0')) {
                backtrack(s, index + i, currentIP + part + ".", dotCount + 1, result);
            }
        }
    }
}

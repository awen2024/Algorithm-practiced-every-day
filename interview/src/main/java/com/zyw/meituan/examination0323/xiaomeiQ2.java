package com.zyw.meituan.examination0323;

import java.util.Scanner;

public class xiaomeiQ2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            //检查下一个字符是否相同与当前字符
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
            }
        }
        System.out.println(s.length() - sb.length());

    }
}

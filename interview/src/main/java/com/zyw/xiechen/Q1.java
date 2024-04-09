package com.zyw.xiechen;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i / 2 == 0) {
                sb.append("you");
            } else {
                sb.append("uoy");
            }
        }
        System.out.println(sb.toString());
    }
}

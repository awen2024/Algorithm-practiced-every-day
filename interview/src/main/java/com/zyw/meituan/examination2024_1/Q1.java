package com.zyw.meituan.examination2024_1;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Q1 {
    //输入例子：
    //2
    //10 5.5
    //10 6.5
    //15 3
    //输出例子：
    //12.00
    public static void main(String[] args) {
        //n
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            double originalTotal = 0;
            double discountTotal = 0;
            for (int i = 0; i < n; i++) {
                double originalPrice = scanner.nextDouble();
                double discountPrice = scanner.nextDouble();
                if (discountPrice > originalPrice||discountPrice<0||originalPrice<0) {
                    System.out.println("error");
                    return; // 发现错误立即停止程序
                }
                originalTotal += originalPrice;
                discountTotal += discountPrice;
            }
            double threshold = scanner.nextDouble();
            double reduction = scanner.nextDouble();
            if (threshold < 0 || reduction < 0 || reduction > threshold) {
                System.out.println("error");
                return;
            }


            double finalPrice;
            if (originalTotal >= threshold) {
                // 满减条件满足时，比较满减后的原价和直接使用折扣价的情况
                finalPrice = Math.min(originalTotal - reduction, discountTotal);
            } else {
                // 不满足满减条件，只能选择折扣价
                finalPrice = discountTotal;
            }

            // 使用BigDecimal格式化输出
            BigDecimal outputPrice = new BigDecimal(finalPrice).setScale(2, RoundingMode.HALF_UP);
            System.out.println(outputPrice);
        }
    }
}

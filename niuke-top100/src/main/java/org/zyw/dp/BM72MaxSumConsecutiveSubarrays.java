package org.zyw.dp;

public class BM72MaxSumConsecutiveSubarrays {
    public int FindGreatestSumOfSubArray (int[] array) {
        // write code here
        int len=array.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for (int i=0;i<len;i++) {
            sum+=array[i];
            if (sum>max) {
                max=sum;
            }
            if (sum<0) {
                sum=0;
            }
        }
        return max;
    }

}

package com.zyw.xiechen;

import java.util.*;

public class Q4 {
    static final int MOD=1000000007;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        int maxNum = Arrays.stream(arr).max().getAsInt();
        List<Integer> primes = getPrime(maxNum);
        //质因数幂次累加
        HashMap<Integer, Long> primePow = new HashMap<>();
        for (int num : arr) {
            for (Integer p : primes) {
                if (p>num) break;
                int count = 0;
                for (long i = p; i <= num; i *= p) {
                    count += num / i;
                }
                if (count > 0) {
                    primePow.put(p, (primePow.getOrDefault(p, 0L) + count)%(MOD-1));
                }
            }
        }
        long res = 1;
        for (long pow : primePow.values()) {
            res = res * (pow + 1) % MOD;
        }
        System.out.println(res);

    }

    private static List<Integer> getPrime(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for (int p = 2; p * p <= n; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    prime[i] = false;
                }
            }
        }
        List<Integer> primeNum = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i]) {
                primeNum.add(i);
            }
        }
        return primeNum;
    }
}

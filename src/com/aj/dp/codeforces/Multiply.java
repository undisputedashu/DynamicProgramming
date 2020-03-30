package com.aj.dp.codeforces;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://codeforces.com/problemset/problem/1061/C
 */
public class Multiply {
	private static int size = 1000001;
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int a[] = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = sc.nextInt();
 
        method2(a, n);//its slow gives tle
//        method1(n, a);
        sc.close();
    }
	
	private static void method2(int[] a, int n) {
		int t[] = new int[n+1];
		Arrays.fill(t, 0);
		t[0] = 1;
		
		for (int i=0;i<n;i++) {
			for (int j=n;j>=1;j--) {
				if (a[i] % j == 0) t[j] = t[j] + t[j-1];
			}
		}
		
		int sum = 0;
		for (int i=1;i<=n;i++) sum = sum + t[i];
		System.out.println(sum);
	}

	static void method1(int n, int[] a) {
		int divCnt[] = new int[size];
        for(int i = size-1; i >= 1; --i) {
            for(int j = i; j <= size-1; j += i)
                divCnt[j]++;
        }
 
        int div[][] = new int[size][];
        for(int i = 1; i <= size-1; ++i)
            div[i] = new int[divCnt[i]];
 
        int ptr[] = new int[size];
        for(int i = size-1; i >= 1; --i) {
            for(int j = i; j <= size-1; j += i)
                div[j][ptr[j]++] = i;
        }
 
        long mod = (long)1e9 + 7;
        
        long ans[] = new long[size];
        ans[0] = 1;
 
        for(int i = 0; i < n; ++i) {
            for(int j : div[a[i]]) {
                ans[j] = (ans[j] + ans[j - 1]) % mod;
            }
        }
 
        long fans = 0;
        for(int i = 1; i <= size-1; ++i) {
            fans = (fans + ans[i]) % mod;
        }
 
        System.out.print(fans);
	}	
}
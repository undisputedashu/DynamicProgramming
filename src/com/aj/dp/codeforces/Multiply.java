package com.aj.dp.codeforces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * https://codeforces.com/problemset/problem/1061/C
 */
public class Multiply {
	private static int size = 1000001;
	private static long mod = (long)1e9 + 7;
	public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
 
        int n = sc.nextInt();
 
        int a[] = new int[n];
        for(int i = 0; i < n; ++i)
            a[i] = sc.nextInt();

        method3(a, n);
//        method2(a, n);//its slow gives tle
//        method1(n, a);
        sc.close();
    }
	
	private static void method3(int[] a, int n) {
		Map<Integer, List<Integer>> divs = new HashMap<>();
		for (int i=0;i<n;i++) {
			populate(a[i], divs, n);
		}
		
		long t[] = new long[n+1];
		Arrays.fill(t, 0);
		t[0] = 1;
		
		for (int i=0;i<n;i++) {
			for (int x : divs.get(a[i])) {
				t[x] = (t[x] + t[x-1])%mod;
			}
		}
		
		long sum = 0;
		for (int i=1;i<=n;i++) sum = (sum + t[i])%mod;
		System.out.println(sum);
	}

	private static void populate(int x, Map<Integer, List<Integer>> divs, int n) {
		if (divs.containsKey(x)) return;
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		for (int i=1;i<=Math.sqrt(x);i++) {
			if (x % i == 0) {
				int a = i, b = x/i;
				//if a or b is greater than n its not required to maintain data about it
				if (a<=n) set.add(a);
				if (b<=n) set.add(b);
			}
		}
		list.addAll(set);
		Collections.sort(list, Collections.reverseOrder());
		divs.put(x, list);
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

	private static void method1(int n, int[] a) {
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
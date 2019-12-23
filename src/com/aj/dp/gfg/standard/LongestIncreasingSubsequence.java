
package com.aj.dp.gfg.standard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 * @author ashu
 *
 */
public class LongestIncreasingSubsequence {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int i=0;i<n;i++) a[i] = in.nextInt();
			
			//Recursive solution
			lisRecursive(a, n); //its recursive solution it can be modified a little to give optimized memoized solution
			System.out.println(max);//Memoization is easy and should be used when we are unable to find bottom up solution
			
			//Memoized solution
			int d[] = new int[n+1];
			d[0] = 0;
			d[1] = 1;
			Arrays.fill(d, -1);
			lisMemoized(a, n, d);//It uses recursive solution, just stores computed result in passed table
			int max = 0;
			for (int i=1;i<=n;i++) {
				if (d[i] > max) {
					max = d[i];
				}
			}
			System.out.println(max);
			
			//DP solution
			max = lisDp(a, n);
			System.out.println(max);
		}
		in.close();
	}


	private static int lisDp(int[] a, int n) {
		int t[] = new int[n];
		Arrays.fill(t, 1);
		
		int max = 1;
		for (int i=1;i<n;i++) {
			
			for (int j=0;j<i;j++) {
				if (a[j]<a[i] && t[j]+1>t[i])
					t[i] = t[j] + 1;
			}
			
			if (t[i] > max) max = t[i];
		}
		return max;
	}


	private static int lisMemoized(int[] a, int n, int d[]) {
		if (n == 1) return 1;
		if (d[n] != -1) return d[n];
		
		int res = 1;
		for (int i=1;i<n;i++) {
			int curr = lisMemoized(a, i, d);
			if (a[n-1] > a[i-1] && curr + 1 > res) {
				res = curr+1;
			}
		}
		d[n] = res;
		return res;
	}

	private static int max = 1;
	private static int lisRecursive(int[] a, int n) {
		if (n == 1) return 1;
		
		int res = 1;
		for (int i=1;i<n;i++) {
			int curr = lisRecursive(a, i);
			if (a[n-1] > a[i-1] && curr + 1 > res) {
				res = curr+1;
			}
		}
		if (res > max) max = res;
		return res;
	}
	
}
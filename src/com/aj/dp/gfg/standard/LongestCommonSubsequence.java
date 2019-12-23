package com.aj.dp.gfg.standard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/longest-common-subsequence-dp-4/
 * @author ashu
 */
public class LongestCommonSubsequence {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int m = in.nextInt(), n = in.nextInt();
			String s1 = in.next(), s2 = in.next();
			
			int cnt = lcsRecursive(s1, m, s2, n);
			System.out.println(cnt);
			
			int d[][] = new int[m+1][n+1];
			for (int i=0;i<=m;i++) Arrays.fill(d[i], -1);
			lcsMemoized(s1,m,s2,n,d);
			System.out.println(d[m][n]);
			
			int count = lcsDp(s1,m,s2,n);
			System.out.println(count);
		}
		in.close();
	}

	private static int lcsDp(String s1, int m, String s2, int n) {
		int t[][] = new int[m+1][n+1];
		
		for (int i=1;i<=m;i++) {
			for (int j=1;j<=n;j++) {
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					t[i][j] = t[i-1][j-1] + 1;
				} else {
					t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
				}
			}
		}
		return t[m][n];
	}

	private static int lcsMemoized(String s1, int m, String s2, int n, int[][] d) {
		if (d[m][n] != -1) return d[m][n]; 
		if (m == 0 || n == 0) {
			d[m][n] = 0;
			return 0;
		}
		if (s1.charAt(m-1) == s2.charAt(n-1)) {
			d[m][n] = 1 + lcsMemoized(s1,m-1,s2,n-1, d);
			return d[m][n];
		}
		d[m][n] = Math.max(lcsMemoized(s1,m,s2,n-1, d), lcsMemoized(s1,m-1,s2,n, d));
		return d[m][n];
	}

	private static int lcsRecursive(String s1, int m, String s2, int n) {
		if (m == 0 || n == 0) return 0;
		if (s1.charAt(m-1) == s2.charAt(n-1))
			return 1 + lcsRecursive(s1,m-1,s2,n-1);
		return Math.max(lcsRecursive(s1,m,s2,n-1), lcsRecursive(s1,m-1,s2,n));
	}
	
}
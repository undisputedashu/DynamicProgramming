package com.aj.dp.gfg.standard;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/edit-distance-dp-5/
 * @author ashu
 */
public class EditDistance {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int m = in.nextInt(), n = in.nextInt();
			String s1 = in.next(), s2 = in.next();
			
			int cnt = edRecursive(s1,m,s2,n);
			System.out.println(cnt);
			
			int d[][] = new int[m+1][n+1];
			for (int i=0;i<=m;i++) Arrays.fill(d[i], -1);
			cnt = edMemoized(s1,m,s2,n,d);
			System.out.println(d[m][n]);
			
			cnt = edDp(s1,m,s2,n);
			System.out.println(cnt);
		}
		in.close();
	}

	private static int edDp(String s1, int m, String s2, int n) {
		int t[][] = new int[m+1][n+1];
		
		for (int i=0;i<=m;i++) {
			for (int j=0;j<=n;j++) {
				if (i == 0) t[i][j] = j;
				else if (j == 0) t[i][j] = i;
				else if (s1.charAt(i-1) == s2.charAt(j-1)) {
					t[i][j] = t[i-1][j-1];
				} else {
					t[i][j] = 1 + min(t[i][j-1], t[i-1][j], t[i-1][j-1]);
				}
				
			}
		}
		return t[m][n];
	}

	private static int edMemoized(String s1, int m, String s2, int n, int[][] d) {
		if (d[m][n] != -1) return d[m][n];
		
		if (m == 0) {
			d[m][n] = n;
			return n;
		}
		if (n == 0) {
			d[m][n] = m;
			return m;
		}
		if (s1.charAt(m-1) == s2.charAt(n-1)) {
			d[m][n] = edMemoized(s1,m-1,s2,n-1,d);
			return d[m][n];
		}
		d[m][n] = 1 + min(edMemoized(s1,m,s2,n-1,d), edMemoized(s1,m-1,s2,n,d), edMemoized(s1,m-1,s2,n-1,d));
		return d[m][n];
	}

	private static int edRecursive(String s1, int m, String s2, int n) {
		if (m == 0)
			return n;
		if (n == 0) 
			return m;
		if (s1.charAt(m-1) == s2.charAt(n-1))
			return edRecursive(s1,m-1,s2,n-1);
		return 1 + min(edRecursive(s1,m,s2,n-1), edRecursive(s1,m-1,s2,n), edRecursive(s1,m-1,s2,n-1));
	}

	private static int min(int x, int y, int z) {
		if (x<=y && x<=z) return x; 
        if (y<=x && y<=z) return y; 
        else return z; 
	}
	
}
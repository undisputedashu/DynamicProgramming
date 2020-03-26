package com.aj.dp.tc.intermediate;

import java.util.Scanner;

/**
 * https://practice.geeksforgeeks.org/problems/count-all-possible-paths-from-top-left-to-bottom-right/0
 */
public class CountPathsInMatrix {

	private static long MOD = (long) (Math.pow(10, 9) + 7);
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt(), m = in.nextInt();
			long s[][] = new long[n][m];
			for (int i=0;i<n;i++) {
				for (int j=0;j<m;j++) {
					long x = (i == 0) ? 0 : s[i-1][j];
					long y = (j == 0) ? 0 : s[i][j-1];
					if (i == 0 && j == 0) s[i][j] = 1;
					else s[i][j] = (x+y)%MOD;
				}
			}
			System.out.println(s[n-1][m-1]);
		}
		in.close();
	}
	
}
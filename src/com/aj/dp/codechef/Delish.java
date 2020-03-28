package com.aj.dp.codechef;

import java.util.Scanner;

public class Delish {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			long d[] = new long[n];
			
			for (int i=0;i<n;i++) {
				d[i] = in.nextLong();
			}
			
			long left[][] = new long[2][n];
			left[0][0] = d[0];
			left[1][0] = d[0];
			
			for (int i=1;i<n;i++) {
				left[0][i] = Math.max(left[0][i-1], 0) + d[i];
				left[1][i] = Math.min(left[1][i-1], 0) + d[i];
			}
			
			long right[][] = new long[2][n];
			right[0][n-1] = d[n-1];
			right[1][n-1] = d[n-1];
			for (int i=n-2;i>=0;i--) {
				right[0][i] = Math.max(right[0][i+1], 0) + d[i];
				right[1][i] = Math.min(right[1][i+1], 0) + d[i];
			}
			
			long ans = Integer.MIN_VALUE;
			for (int i=0;i<n-1;i++) {
				ans = Math.max(ans, Math.abs(left[0][i] - right[1][i+1]));
				ans = Math.max(ans, Math.abs(left[1][i] - right[0][i+1]));
			}
			
			System.out.println(ans);
		}
		in.close();
	}
	
}
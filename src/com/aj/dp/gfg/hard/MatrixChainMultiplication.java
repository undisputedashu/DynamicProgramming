package com.aj.dp.gfg.hard;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainMultiplication {

	public static void main(String args[]) {
		solve();
		//test();
	}

	private static void test() {
		int a[] = {10,30,5,60};
		int n = a.length;
		int cnt = get(a, 1, n-1);
		System.out.println(cnt);
	}

	private static int get(int[] a, int i, int j) {
		if (i == j) return 0;
		int min = Integer.MAX_VALUE;
		
		for (int k=i;k<j;k++) {
			int cnt = get(a,i,k) + get(a,k+1,j) + a[i-1]*a[k]*a[j];
			if (cnt < min)
				min = cnt;
		}
		return min;
	}

	private static void solve() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int i=0;i<n;i++) a[i] = in.nextInt();
			int x[][] = new int[n][n];
			for (int i=0;i<n;i++) Arrays.fill(x[i], -1);
			int cnt = gets(a, 1, n-1, x);
			System.out.println(cnt);
		}
		in.close();
	}

	private static int gets(int[] a, int i, int j, int[][] x) {
		if (i == j) return 0;
		if (x[i][j] != -1) return x[i][j];
		
		int min = Integer.MAX_VALUE;
		for (int k=i;k<j;k++) {
			int cnt = gets(a,i,k,x) + gets(a,k+1,j,x) + a[i-1]*a[k]*a[j];
			if (cnt < min) min = cnt;
		}
		
		x[i][j] = min;
		return min;
	}
	
}
package com.aj.dp.gfg.hard;

import java.util.Arrays;
import java.util.Scanner;

public class PalindromePartitioning {

	private static int max = Integer.MAX_VALUE;
	public static void main(String args[]) {
//		test();
		solve();
	}

	private static void solve() {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-->0) {
			String s = in.next();
			int n = s.length();
			
			int x[][] = new int[n+1][n+1];
			for (int i=0;i<=n;i++) Arrays.fill(x[i], -1);
	
//			for (int i=0;i<n;i++) {
//				for (int j=i+1;j<=n;j++) {
//					if (check(s,i,j)) x[i][j] = 1;
//				}
//			}
			int cnt = gets(s, 0, n, x);
			System.out.println(cnt);
		}
		in.close();
	}

	private static int gets(String st, int s, int e, int[][] x) {
		if (s>=e) return max;
		if (x[s][e] != -1) return x[s][e];
		if (check(st,s,e)) return 0;
		int min = max;
		for (int i=s+1;i<e;i++) {
			int curr = gets(st,s,i,x) + gets(st,i,e,x);
			if (curr != max && curr+1<min) 
				min = curr + 1;
		}
		x[s][e] = min;
		return min;
	}

	private static void test() {
		String s = "ababbbabbababa";
		int n = s.length();
		int cnt = get(s, 0, n);
		System.out.println(cnt);
	}

	private static int get(String st, int s, int e) {
		if (s>=e) return max;
		if (check(st, s, e)) return 0;
		
		int min = max;
		for (int i=s+1;i<e;i++) {
			int curr = get(st,s,i) + get(st,i,e);
			if (curr != max && curr+1<min)
				min = curr+1;
		}
		return min;
	}

	private static boolean check(String st, int s, int e) {
		e--;
		while (s<e) {
			if (st.charAt(s) != st.charAt(e)) return false;
			s++;
			e--;
		}
		return true;
	}

}
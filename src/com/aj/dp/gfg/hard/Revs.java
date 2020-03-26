package com.aj.dp.gfg.hard;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 1
6
2 1 2 0 1 1
 */
public class Revs {
	
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int a[] = new int[n];
			for (int i=0;i<n;i++) {
				a[i] = in.nextInt();
			}
			
			int x[] = new int[n+1];
			Arrays.fill(x, -1);
			int jumps = gets(a, 0, x);
			if (jumps == max) System.out.println("-1");
			else System.out.println(jumps);
		}
		in.close();
	}

	private static int gets(int[] a, int s, int[] x) {
		int n = a.length;
		if (s<0 || s>=n) return max;
		if (a[s] == 0) return max;
		if (s+a[s]>=n-1) return 1;
		if (x[s] != -1) return x[s];
		
		int min = max;
		for (int i=s+1;i<=s+a[s];i++) {
			int curr = gets(a,i,x);
			if (curr != max && curr + 1 < min)
				min = curr + 1;
		}
		x[s] = min;
		return min;
	}

	private static int max = Integer.MAX_VALUE;
	private static int get(int[] a, int s, int n) {
		if (s<0 || s>=n) return max;
		if (a[s] == 0) return max;
		if (s + a[s] >= n-1) return 1;
		
		int min = Integer.MAX_VALUE;
		for (int i=s+1;i<=a[s];i++) {
			int curr = get(a,i,n);
			if (curr != max && curr + 1 < min)
				min = curr + 1;
		}
		return min;
	}
	
}
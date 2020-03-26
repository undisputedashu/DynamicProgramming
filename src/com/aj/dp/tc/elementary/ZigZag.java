package com.aj.dp.tc.elementary;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.geeksforgeeks.org/longest-zig-zag-subsequence/
 */
public class ZigZag {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t-- > 0) extracted(in);
		in.close();
	}

	private static void extracted(Scanner in) {
//		int a[] = { 1, 17, 5, 10, 13, 15, 10, 5, 16, 8 };
//		//answer is 7. 1,17,10,13,10,16,8
//		int n = a.length;
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i=0;i<n;i++) a[i] = in.nextInt();
		
		int t[] = new int[n];
		Arrays.fill(t, 1);
		
		int inc[] = new int[n];
		int dec[] = new int[n];
		
		Arrays.fill(inc, 0);
		Arrays.fill(dec, 0);
		inc[0] = 1; dec[0] = 1;
		
		for (int i=1;i<n;i++) {
			if (a[i] > a[i-1]) inc[i] = 1;
			else if (a[i] < a[i-1]) dec[i] = 1;
		}
		
		int ans = 1;
		
		for (int i=1;i<n;i++) {
			for (int j=0;j<i;j++) {
				if (a[i]>a[j] && dec[j] == 1) {
					t[i] = Math.max(t[i], t[j] + 1);
				} else if (a[i] < a[j] && inc[j] == 1) {
					t[i] = Math.max(t[i], t[j] + 1);
				}
			}
			ans = Math.max(ans, t[i]);
		}
		
		System.out.println(ans);
	}
	
}
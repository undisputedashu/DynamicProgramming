package com.aj.dp.codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * https://www.codechef.com/problems/ALTARAY
 */
public class AltArray {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			long a[] = new long[n];
			for (int i=0;i<n;i++) a[i] = in.nextLong();
			long x[] = new long[n];
			Arrays.fill(x, 1);
			int ind = n-2;
			while (ind>=0) {
				if (a[ind]*a[ind+1] < 0) x[ind] = x[ind+1] + 1;
				ind--;
			}
			for (int i=0;i<n;i++) System.out.print(x[i] + " ");
			System.out.println();
		}
		in.close();
	}
	
}
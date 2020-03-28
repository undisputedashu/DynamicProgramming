package com.aj.dp.codechef;

import java.util.Arrays;
import java.util.Scanner;
/**
 * https://www.codechef.com/problems/DBOY
 */
public class Dboy {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int h[] = new int[n];
			int max = 0;
			for (int i=0;i<n;i++) {
				h[i] = in.nextInt();
				if (h[i] > max) max = h[i];
			}
			
			int k[] = new int[n];
			for (int i=0;i<n;i++) k[i] = in.nextInt();
			
			int s = 2*max+1;
			int x[] = new int[s];
			Arrays.fill(x, Integer.MAX_VALUE);
			x[0] = 0;
			
			for (int i=1;i<s;i++) {
				int min = Integer.MAX_VALUE;
				for (int j=0;j<n;j++) {
					if (k[j]<=i) {
						int ind = i-k[j];
						if (x[ind] != Integer.MAX_VALUE && x[ind] + 1 < min)
							min = x[ind] + 1;
					}
				}
				x[i] = min;
			}
			
			int sum = 0;
			for (int i=0;i<n;i++) {
				sum = sum + x[2*h[i]];
			}
			System.out.println(sum);
		}
		in.close();
	}
	
}
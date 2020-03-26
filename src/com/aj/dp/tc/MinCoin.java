package com.aj.dp.tc;

import java.util.Arrays;

public class MinCoin {

	public static void main(String args[]) {
		int c[] = {1,3,5};
		int n = c.length;
		int s = 11;

		int max = Integer.MAX_VALUE;
		int t[] = new int[s+1];
		Arrays.fill(t, max);
		t[0] = 0;
		
		for (int i=1;i<=s;i++) {
			int min = max;
			for (int j=0;j<n;j++) {
				if (i-c[j]>=0) {
					if (t[i-c[j]] != max && t[i-c[j]] + 1 < min)
						min = t[i-c[j]] + 1;
				}
			}
			t[i] = min;
		}
		
		for (int i=0;i<=s;i++) System.out.println(i + "  " + t[i]);
	}
}

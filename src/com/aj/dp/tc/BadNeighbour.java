package com.aj.dp.tc;

/**
 * https://community.topcoder.com/stat?c=problem_statement&pm=2402&rd=5009
 */
public class BadNeighbour {

	private static final int min = Integer.MIN_VALUE;
	public static void main(String args[]) {
		int a[] = { 94, 40, 49, 65, 21, 21, 106, 80, 92, 81, 679, 4, 61,  
				  6, 237, 12, 72, 74, 29, 95, 265, 35, 47, 1, 61, 397,
				  52, 72, 37, 51, 1, 81, 45, 435, 7, 36, 57, 86, 81, 72 };	
		int n = a.length;
		int ans = 0;
		if (n <= 3) {
			ans = max(a, n);
		} else {
			ans = get(a,n);
		}
		System.out.println(ans);
	}

	private static int get(int[] a, int n) {
		int t[] = new int[n];
		int e = a[n-1];

		a[n-1] = min;
		for (int i=0;i<n;i++) t[i] = a[i];
		int max1 = max(a,3);
		for (int i=2;i<n;i++) {
			int max = t[i];
			for (int j=0;j<i-1;j++) {
				if (max < t[i] + t[j]) {
					max = t[i] + t[j];
				}
			}
			t[i] = max;
			if (max1 < t[i]) max1 = t[i];
		}

		a[n-1] = e;
		a[0] = min;
		for (int i=0;i<n;i++) t[i] = a[i];
		int max2 = max(a,3);
		for (int i=2;i<n;i++) {
			int max = t[i];
			for (int j=0;j<i-1;j++) {
				if (max < t[i] + t[j]) {
					max = t[i] + t[j];
				}
			}
			t[i] = max;
			if (max2 < t[i]) max2 = t[i];
		}
		return Math.max(max1, max2);
	}

	private static int max(int[] a, int n) {
		int max = Integer.MIN_VALUE;
		for (int i=0;i<n;i++) {
			if (max < a[i]) max = a[i];
		}
		return max;
	}
	
}
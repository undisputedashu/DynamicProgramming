package com.aj.dp.gfg.standard;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/min-cost-path-dp-6/
 * @author ashu
 * check differnce in recursive and dp approach
 * these minor tweaks can be used.
 * Starting point and end point decisions.
 */
public class MinCostPath {

	private static int max = Integer.MAX_VALUE;
	public static void main(String args[]) {
		int a[][] = {
				{1,2,3},
				{4,8,2},
				{1,5,3}
		};
		int cnt = getRecursive(a, 0, 0);
		System.out.println(cnt);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		cnt = getMem(a, 0, 0, map);
		System.out.println(cnt);
		
		cnt = getDp(a);
		System.out.println(cnt);
	}

	private static int getDp(int[][] a) {
		int m = a.length, n = a[0].length;
		int t[][] = new int[m+1][n+1];
		
		for (int i=1;i<=m;i++) {
			t[i][0] = t[i-1][0] + a[i-1][0];
		}
		for (int j=1;j<=n;j++) {
			t[0][j] = t[0][j-1] + a[0][j-1];
		}
		
		for (int i=1;i<=m;i++) {
			for (int j=1;j<=n;j++) {
				t[i][j] = min(t[i-1][j], t[i][j-1], t[i-1][j-1]) + a[i-1][j-1];
			}
		}
		return t[m][n];
	}

	private static int getMem(int[][] a, int i, int j, Map<String, Integer> map) {
		StringBuilder sb = new StringBuilder();
		sb.append(i).append(":").append(j);
		String key = sb.toString();
		if (map.containsKey(key)) return map.get(key);
		
		int m = a.length, n = a[0].length;
		if (i>= m || i<0) return max;
		if (j>= n || j<0) return max;
		
		if (i == m-1 && j == n-1)
			return a[i][j];
		int value = a[i][j] + min(getMem(a,i+1,j,map), getMem(a,i,j+1,map), getMem(a,i+1,j+1,map));
		map.put(key, value);
		return value;
	}

	private static int getRecursive(int[][] a, int i, int j) {
		int m = a.length, n = a[0].length;
		if (i>= m || i<0) return max;
		if (j>= n || j<0) return max;
		
		if (i == m-1 && j == n-1)
			return a[i][j];
		
		return a[i][j] + min(getRecursive(a,i+1,j), getRecursive(a,i,j+1), getRecursive(a,i+1,j+1));
	}
	
	private static int min(int a,int b,int c) {
		if (a<=b && a<=c) return a;
		if (b<=a && b<=c) return b;
		return c;
	}
	
}
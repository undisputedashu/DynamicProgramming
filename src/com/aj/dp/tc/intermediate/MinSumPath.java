package com.aj.dp.tc.intermediate;

/**
 * https://leetcode.com/problems/minimum-path-sum/submissions/
 */
public class MinSumPath {

	public static void main(String args[]) {
		int a[][] = {
		             {1,3,5},
		             {1,5,1},
		             {4,2,1}
		};
		MinSumPath msp = new MinSumPath();
		int ans = msp.minPathSum(a);
		System.out.println(ans);
	}

	public int minPathSum(int[][] a) {
		int m = a.length, n = a[0].length;
		int t[][] = new int[m][n];
		for (int i=0;i<m;i++) {
			for (int j=0;j<n;j++) {
				int x = (i == 0) ? Integer.MAX_VALUE : t[i-1][j];
				int y = (j == 0) ? Integer.MAX_VALUE : t[i][j-1];
				if (i == 0 && j == 0) t[i][j] = a[i][j];
				else t[i][j] = a[i][j] + Math.min(x, y);
			}
		}
		return t[m-1][n-1];
	}
	
}
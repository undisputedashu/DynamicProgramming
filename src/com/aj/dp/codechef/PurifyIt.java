package com.aj.dp.codechef;

import java.util.Arrays;
import java.util.Scanner;


public class PurifyIt {

	private static String s,a="1010",b="0101";
	private static int max = (int)(Math.pow(10, 9));
	private static int dp[][][] = new int[1010][4][4];
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while (t-- > 0) {
			s = in.next();
			int ans = getFromDp(s);//getMin();//get(s, 0, 0, 0);
			System.out.println(ans);
		}
		in.close();
	}

	private static int getFromDp(String s) {
		int n = s.length();
		int zero[] = new int[n+1];
		int one[] = new int[n+1];
		Arrays.fill(zero, 0);
		Arrays.fill(one, 0);
		
		for (int i=1;i<=n;i++) {
			int d = s.charAt(i-1) - '0';
			if (d == 0) zero[i] = zero[i-1] + 1;
			else zero[i] = zero[i-1];
		}
		
		for (int i=1;i<=n;i++) {
			int d = s.charAt(i-1) - '0';
			if (d == 1) one[i] = one[i-1] + 1;
			else one[i] = one[i-1];
		}
		
		int min = n;
		
		//for every i and j, we will form 3 blocks of form 010 or 101 and compute minimum deletion
		//3 blocks will be 1,i-1   and i,j-1  and j,n 
		for (int i=1;i<=n;i++) {
			for (int j=i;j<=n;j++) {
				//form 3 blocks in the form 010
				//number of ones in 1 to i-1 we need to remove it
				int o1 = one[i-1];
				//number of zeroes in i to j-1, remove it
				int z1 = Math.abs(zero[j-1] - zero[i]);//using abs for handling case i == j
				//number of ones in j to n, remove it
				int o2 = one[n] - one[j];
				int diff = o1 + z1 + o2;
				min = Math.min(min, diff);
				
				//form 3 blocks of form 101
				z1 = zero[i-1];
				o1 = Math.abs(one[j-1] - one[i]);
				int z2 = zero[n] - zero[j];
				diff = z1+o1+z2;
				min = Math.min(min, diff);
			}
		}
		
		return min;
	}

	private static int dp() {
		int n = s.length();
		int p[][] = new int[2][n+1];
		for (int i = 1; i <= n; i ++)
			for (int w = 0; w <= 1; w ++)
				p[w][i] = p[w][i - 1] + (s.charAt(i-1)-'0' == w ? 1 : 0);
		
		int min = n;
		for (int w = 0; w <= 1; w ++)
			for (int i = 1; i <= n; i ++)
				for (int j = i; j <= n; j ++)
					min = Math.min(min, p[w][i - 1] + (j - i + 1) - (p[w][j] - p[w][i - 1]) + (p[w][n] - p[w][j]));
		return min;
	}

	private static int getMin() {
		for (int i=0;i<1010;i++)
			for (int j=0;j<4;j++)
				Arrays.fill(dp[i][j], -1);
		return getMin(0,0,0);
	}

	private static int getMin(int pos, int x, int y){
		if(Math.max(x,y) == 4)return max;
		if(pos==s.length()) return 0;
		int r=dp[pos][x][y];
		if(r>=0) return r;
		
		r = 1+getMin(pos+1,x,y);
		int i = s.charAt(pos)==a.charAt(x) ? 1 : 0;
		int j = s.charAt(pos)==b.charAt(y) ? 1 : 0;
		r = Math.min(r,getMin(pos+1, x+i, y+j));
		
		dp[pos][x][y] = r;
		return r;
	}

	private static int get(String st, int s, int x, int y) {
		if (Math.max(x, y)>=4) return max;
		if (s == st.length()) return 0;
		
		int p = 1 + get(st,s+1,x,y);
		char ch = st.charAt(s);
		int i = ch == a.charAt(x) ? x+1 : x;
		int j = ch == b.charAt(y) ? y+1 : y;
		int q = get(st, s+1, i, j);
		return Math.min(p, q);
	}
	
}
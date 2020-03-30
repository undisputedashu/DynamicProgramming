package com.aj.dp.codeforces;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
/**
 * https://codeforces.com/problemset/problem/977/F
 */
public class ConsecutiveSequence {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int a[] = new int[n];
		for (int i=0;i<n;i++) a[i] = in.nextInt();
		
		method2(a, n);//O(n)
		//method1(n, a);tle as O(n^2) solution
		in.close();
	}

	private static void method2(int[] a, int n) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();
		map.put(a[0], 1);
		int max = 1, ind = 0;
		for (int i=1;i<n;i++) {
			int key = a[i];
			int val = map.getOrDefault(key-1, 0);
			val++;
			map.put(a[i], val);
			if (val>max) {
				max = val;
				ind = i;
			}
		}
		
		System.out.println(max);
		if (max == 1) {
			System.out.println(ind+1);
		} else {
			int l = ind;
			Stack<Integer> st = new Stack<Integer>();
			st.push(l+1);
			l--;
			while (l>=0) {
				if (a[l] == a[ind]-1) {
					st.push(l+1);
					ind = l;
				}
				l--;
			}
			
			while (!st.isEmpty()) System.out.print(st.pop() + " ");
		}
	}

	static void method1(int n, int[] a) {
		int t[] = new int[n];
		Arrays.fill(t, 1);
		int max = 1, ind = 0;
		for (int i=1;i<n;i++) {
			for (int j=0;j<i;j++) {
				if (a[j] == a[i]-1 && t[j]+1 > t[i])
					t[i] = t[j] + 1;
			}
			if (max < t[i]) {
				max = t[i];
				ind = i;
			}
		}
		System.out.println(max);
		if (t[ind] == 1) {
			System.out.println(ind+1);
		} else {
			int l = ind;
			Stack<Integer> st = new Stack<Integer>();
			st.push(l+1);
			l--;
			while (l>=0) {
				if (a[l] == a[ind]-1) {
					st.push(l+1);
					ind = l;
				}
				l--;
			}
			
			while (!st.isEmpty()) System.out.print(st.pop() + " ");
		}
	}
	
}
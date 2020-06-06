package com.lab515.Task;

import java.util.*;

/**
 * 推到吧骨牌（Push the dominoes）
 */
public class Two {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		char[] chs = s.next().toCharArray();
		int lenth = chs.length;
		int[] values = new int[lenth];
		
		int value = 0;
		for(int i = 0; i < lenth;i++)
		{
			if(chs[i] == 'R')
			{
				value = lenth;
			}
			else
			{
				value = Math.max(value - 1, 0);
			}
			values[i] += value;
		}
		value = 0;
		for(int i = lenth - 1; i >= 0; --i)
		{
			if(chs[i] == 'L')
			{
				value = lenth;
			}
			else if (chs[i] == 'R')
			{
				value = 0;
			}
			else
			{
				value = Math.max(value - 1, 0);
			}
			values[i] -= value;
		}
		
		StringBuilder m = new StringBuilder();
		for(int i : values)
		{
			m.append(i > 0 ? 'R' : i < 0 ? 'L' : '.');
		}
		System.out.println(m);
	}
}

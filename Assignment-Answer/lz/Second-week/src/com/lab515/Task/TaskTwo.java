package com.lab515.Task;

import java.util.Scanner;

/**
 * 谁获得奖品(当然是我啦)
 * @author 86134
 * 
 */
public class TaskTwo {
	
	public static void champion(int n, int m)
	{
		boolean []persons = new boolean[n]; // 初始化都为false，找到后值为true
		int code = 1;
		int idx = 0;
		int size = n;
		while (size > 1)
		{
			if (!persons[idx])
			{ // 未被淘汰的
				if(code == m)
				{
					persons[idx] = true;
					code = 0; // 重新计数
					size--; // 总大小减1
				}
				code++; //合法的编号加1
			}
			idx++; // 数组下标递增，如果到结尾，就重置idx，重新开始循环
			if (idx == n)
			{
				idx = 0;
			}
		}
		
		for (int i = 0; i < n; i++)
		{
			if(!persons[i])
				System.out.println(i+1);
		}
	}
	
	public static void main(String []args)
	{
		Scanner in = new Scanner(System.in);
		
		int n = in.nextInt();
		int m = in.nextInt();
		champion(n, m);
	}
}

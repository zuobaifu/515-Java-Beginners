package com.lab515.Task;

/**
 * 推到吧骨牌（Push the dominoes）
 */
import java.util.Scanner;

public class Two {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int judge = 0; // 存放距离量用于判断被向哪推到还是没有推倒
		int length;
		String dominoes = new String();
		dominoes = sc.next();
		length = dominoes.length(); // 存放输入字符串的长度
		int []arr = new int[length]; // 声明一个数组用于存放每个骨牌judge的值
		
		// 从左向右遍历，计算未被推到的骨牌与距离其最近的向右倒的骨牌之间的距离
		for (int i = 0; i < length; i++)
		{
			if(dominoes.charAt(i) == 'R')
			{
				judge = 1;
				// arr[i] = judge;
			}
			else if(dominoes.charAt(i) == 'L')
			{
				judge = 0;
			}
			else if(judge > 0)
			{ // 骨牌没有倒
				arr[i] = judge++;
			}
		}
		
		judge = 0;
		// 从右向左遍历，计算未被推到的骨牌与距离其最近的向左倒的骨牌之间的距离，并根据上一次遍历的情况进行推倒判断
		for(int i = length - 1; i >= 0; i--)
		{
			if(dominoes.charAt(i) == 'R')
			{
				judge = 0;
			}
			else if(dominoes.charAt(i) == 'L')
			{
				judge = 1;
			}
			else if(judge > 0)
			{
				if(arr[i] == 0)
				{ // 没有被向右的骨牌推
					arr[i] = -judge;
				}
				else if(arr[i] > judge)
				{
					arr[i] = -judge;
					judge++;
				}
				else if(arr[i] == judge)
				{
					arr[i] = 0;
				}
			}
		}
		
		StringBuilder str = new StringBuilder();
		
		for (int i = 0; i < length; i++)
		{
			if(arr[i] == 0)
			{
				str.append(dominoes.charAt(i));
			}
			else if(arr[i] > 0)
			{
				str.append('R');
			}
			else
			{
				str.append('L');
			}
		}
		System.out.println(str);
	}
}


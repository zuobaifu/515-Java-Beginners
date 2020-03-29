package com.my;
import java.util.Scanner;// 包含输入的工具包
/**
 * 数字分类
 * @author zhenli798
 *
 */
public class TaskTwo {

	public static void main(String []args)
	{
		/**
		 * 给定一系列正整数，请按要求对数字进行分类，并输出以下 5 个数字：
 		 * A1 = 能被 5 整除的数字中所有偶数的和； 
 		 * A2 = 将被 5 除后余 1 的数字按给出顺序进行交错求和，即计算  -  +  -  ···； 
 		 * A3 = 被 5 除后余 2 的数字的个数；
 		 * A4 = 被 5 除后余 3 的数字的平均数，精确到小数点后 1 位；
 		 * A5 = 被 5 除后余 4 的数字中最大数字。
		 */
		Scanner input = new Scanner(System.in);// 创建扫描仪对象
		
		int len = 0;// 数组长度
		int []arr;// 声明一个数组
		len = input.nextInt();// 获取用户输入的数字个数
		arr = new int [len]; // 创建数组对象
		
		for(int i = 0; i < len; i++)
		{// 输入各数字
			arr[i] = input.nextInt();
		}
		
		int A1 = 0;// 存放能被5整除的数字中所有偶数的和
		int A2 = 0;// 将被5除后余1的数字按-+顺序进行交错求和的值
		int A3 = 0;// 被5除后余2的数字的个数
		double A4 = 0;// 被5除后余3的数字的平均数，精确到小数点后一位
		int A5 = 0;// 被5除后余4的数字中最大数字
		
		int k = 1;// 计算被5除后余1的数字的交错求和的规律
		int n1 = 0;// 统计被5和2整除偶数的个数
		int n2 = 0;// 统计被5除后余1数字个数
		int n4 = 0;// 统计被5除后余3的数字的个数
		int n5 = 0;// 统计被5除后余4的数字个数
		int sum = 0; // 统计被5除后余3的数字总和
		int max = 0; // 被5除后余4的数字中最大数字
		for(int i = 0; i < len; i++)
		{
			if(arr[i]%5 ==0 && arr[i]%2 == 0)
			{
				A1 += arr[i];
				n1++;
			}
			else if(arr[i]%5 == 1)
			{
				if(k%2 == 0)
					A2 -= arr[i];
				else
					A2 += arr[i];
				k++;
				n2++;
			}
			else if(arr[i]%5 == 2)
			{
				A3++;
			}
			else if(arr[i]%5 == 3)
			{
				sum += arr[i];
				n4++;
			}
			else if(arr[i]%5 == 4)
			{
				if(arr[i] > max)
					max = arr[i];
				n5++;
			}
		}
		A4 = sum/(n4*1.0);
		A5 = max;
		
		//输出
		if(n1 != 0)
			System.out.print(A1 + " ");
		else
			System.out.print("N ");
		if(n2 != 0)
			System.out.print(A2 + " ");
		else
			System.out.print("N ");
		if(A3 != 0)
			System.out.print(A3 + " ");
		else 
			System.out.print("N ");
		if(n4 != 0)
			System.out.printf("%.1f ", A4);
		else
			System.out.print("N ");
		if(n5 != 0)
			System.out.print(A5);
		else
			System.out.print("N");
	}
}

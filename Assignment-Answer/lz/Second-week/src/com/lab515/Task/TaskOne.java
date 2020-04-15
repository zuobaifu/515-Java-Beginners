package com.lab515.Task;

import java.util.Scanner;

/**
 * 打印螺旋矩阵
 * @author 86134
 *
 */
public class TaskOne {

	public static void main(String []args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("请输入要打印的矩阵阶数：");
		
		int n = scan.nextInt(); // 获取边长
		int [][]a = new int[n][n]; // 定义一个二维数组(矩阵)
		int length = n; // 保存初始边长
		int num = 0; // 定义num初始下标
		int rowFirst = 1; // 定义第一个圈第一个数，固定为1
		int i, j; // 循环控制
		
		while (n > 0)
		{
			a[num][num] = rowFirst; // 给当前圈的初始位置赋值
			
			if(n >1){
				for (i = num, j = num + 1; j < n + num; j++)
				{
					a[i][j] = a[i][j -1] + 1; // 自左向右
				}
				for(i = num + 1, j = num + n - 1; i < n + num; i++)
				{
					a[i][j] = a[i-1][j] + 1; // 自上向下
				}
				for (i = num + n - 1, j = num + n -2; j >= num; j--)
				{
					a[i][j] = a[i][j+1] + 1; // 自右向左
				}
				for (i = num + n - 2, j = num; i > num; i--)
				{
					a[i][j] = a[i+1][j] + 1; // 自下向上
				}
			}else{
				break;
			}
			rowFirst = rowFirst + 4*(n-1); // 计算下一圈初始数字
			n = n - 2; // 每完成一圈，边长减2
			num++; // 初始下标自增1
		}
		
		for ( i = 0; i < length; i++)
		{
			for (j = 0; j < length; j++)
			{
				if(j != 0)
				{
					// System.out.print(" "); // 规范输出
					System.out.print("\t"); // 好看一些
				}	
				System.out.print(a[i][j]); // 打印数组元素
			}
			System.out.println(); // 换行
		}
	}
}

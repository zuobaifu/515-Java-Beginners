package com.lab515.Task;

/**
 * 螺旋矩阵
 */
import java.util.Scanner;
import static java.lang.Math.*;
public class TaskOne {
    public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n;
		n = s.nextInt();
		int[][] arr = new int[n][n];
		int a = 1;
		int num;//循环次数
		if(n % 2 == 0)
		{
			num = n/2;//偶数循环次数
		}
		else
		{
			num = n/2 + 1;//奇数圈循环次数
		}
		for(int i = 0;i < num;i++)
		{
			//开局左到右
			for(int j = i;j < n - i;j++)
			{
				arr[i][j] = a++;
			}
			
			//右边从上到下
			for(int k = i+1;k < n-i;k++)
			{
				arr[k][n-i-1] = a++;
			}
			
			//从右往左
			for(int l = n-i-2;l >= i;l--)
			{
				arr[n-i-1][l] = a++;
			}
			
			//从下到上
            for(int m = n - i - 2; m > i; m--)
            {
                arr[m][i] = a++;
            }
		}
		for(int i = 0;i < n;i++)
		{
			for(int j = 0;j < n;j++)
			{
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

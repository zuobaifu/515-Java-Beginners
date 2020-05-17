package com.lab515.Task;

/**
 * 螺旋矩阵
 */
import java.util.Scanner;

public class TaskOne {
public static int[][] myJuzhen(int n)
	{
		int [][] Juzhen = new int [n][n];//定义n*n的二维数组
		int direction = 0;
		int num = n*n;//矩阵共有n*n个数
		int i = 0,j = 0;
		for (int p = 1; p <= num; p++)
		{
			Juzhen [i][j] = p;
			if(direction == 0)
			{
				if(j + 1 < n && Juzhen[i][j+1] == 0)
				{
					j++;
				}
				else
				{
					i++;
					direction ++;
					continue;
				}
			}
			if(direction == 1)
			{
				if(i + 1 < n && Juzhen[i+1][j] == 0)
				{
					i++;
				}
				else
				{
					j--;
					direction ++;
					continue;
				}
			}
			if(direction == 2)
			{
				if(j - 1 >= 0 && Juzhen[i][j-1] == 0)
				{
					j--;
				}
				else
				{
					i--;
					direction ++;
					continue;
				}
			}
			if(direction == 3)
			{
				if(i - 1 >= 0 && Juzhen [i-1][j] == 0)
				{
					i--;
				}
				else
				{
					j++;
					direction = 0;
					continue;
				}
			}
		}return Juzhen;
	}
	public static void main (String[] args)
	{
		Scanner a = new Scanner (System.in);
		int n = a.nextInt();
		int[][] arr = myJuzhen(n);
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(arr[i][j] + " ");
            }
	}
	
}
}

package com.lab515.Task;

/**
 * 谁获得奖品
 */
import java.util.Scanner;

public class TaskTwo {
public static void main (String[] args)
	{
		Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int m = a.nextInt();
		int [] num = new int [n];
		for(int i = 0; i < n; i++)
		{
			num[i] = i + 1;
		}
		int cnt = 0;
		int out = 0;
		for(int i = 0; i < n; i = (i+1)%n)
		{

				if(num[i] != 0)
					cnt++;
				
				if(cnt == m)
				{
					num[i] = 0;
					cnt = 0;
					out++;
				}
				if(out == n-1)
					break;
					
			
		}
		for(int i=0;i<n;i++)
		{
			if(num[i] != 0)
			System.out.print(num[i] + " ");
		}
	}
}

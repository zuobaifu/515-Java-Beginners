package com.lab515.Task;

/**
 * 被 3 整除（Be divided exactly by 3）
 */

import java.util.Scanner;

public class One {
	public static void main(String[] args)
	{
		Scanner s = new Scanner(System.in);
		int start = s.nextInt();
		int end = s.nextInt();
		if(start > end)
		{
			System.out.println(0);
			return;
		}
		int cnt = 0;
		for(long i = start; i <= end; i++)
		{
			if(i%3 == 0 || i%3 == 2)
				cnt++;
		}
		System.out.println(cnt);
	}
}

package com.lab515.Task;

import java.util.Scanner;
/**
 * 被 3 整除（Be divided exactly by 3）
 */
public class One {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int l = sc.nextInt();
        int r = sc.nextInt();
        int count = 0;//计数
        int arr[] = new int[r];
        for(int i = 0;i < r;i++)
        {
            arr[i] = 0;
        }
        for(int i = 0;i < r;i++)
        {
            for(int j = 0;j <= i;j++)
            {
                arr[i] = (arr[i] * 10)+j+1;
            }
        }
        for(int i = l-1;i <= r-1;i++)
        {
            if(arr[i] % 3 == 0)
            {
                count++;
            }
        }
        System.out.println(count);
    }
	
}

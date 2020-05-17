package com.lab515.Task;

/**
 * 被 3 整除（Be divided exactly by 3）
 */
import java.util.Scanner;

public class One {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a, b; // 存放有关起始索引值和结束索引值信息
		int sum = 0; // 存放中间值
		int num = 0; //存放被3整除数的个数
		int []arr; // 声明int型数组
		a = sc.nextInt();
		b = sc.nextInt();
		
		arr = new int[b]; // 创建int数组对象
		for(int i = 1; i <= b; i++)
		{
			sum = sum * 10 + i;
			arr[i - 1] = sum;
		}
		for(int i = a; i <= b; i++)
		{
			if(arr[i-1]%3 == 0)
			{
				num++;
			}
		}
		System.out.println(num);
		// System.out.println(arr[4]);
	}

}

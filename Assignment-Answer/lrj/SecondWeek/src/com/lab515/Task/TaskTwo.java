package com.lab515.Task;

/**
 * 谁获得奖品
 */
import java.util.Scanner;
import java.util.ArrayList;
import static java.lang.Math.*;
public class TaskTwo {
    public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		int n,m;
		System.out.print("请输入人数n:");
		n = s.nextInt();
		System.out.print("请输入报数m:");
		m = s.nextInt();
		ArrayList<Integer> arr = new ArrayList<>();//不太会用这个
		for(int i = 1;i <= n;i++)
		{
			arr.add(i);
		}
		int a = -1,b = 0;//a为数组对应的位置，b为报数的值
		boolean flag = true;
		while(flag)
		{
			a++;
			b++;
			if(b==m)//报到相应数的时候重置排序
			{
				arr.remove(a);
				b = 0;
				a--;
			}
			if(a == (arr.size() - 1))//当数组相应位置超标时形成循环
			{
				a = -1;
			}
			if(arr.size() == 1)//剩最后一个，输出
			{
				System.out.println(arr.get(0));
				break;
			}
		}
	}
}

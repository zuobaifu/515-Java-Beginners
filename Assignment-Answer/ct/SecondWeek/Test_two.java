package com.lab515.Task;

import java.util.Scanner;

import java.util.LinkedList;

public class Test_two {

	static LinkedList<Integer> list = new LinkedList<Integer>();
	static int number=-1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n,m;
		System.out.print("请输入人数n：");
		n = input.nextInt();
		System.out.print("请输入报数m：");
		m = input.nextInt();
		for(int i=1;i<=n;i++)
		{
			list.add(i);
		}
		while(list.size()!=1)
		{
			for(int i=0;i<m;i++)
			{
				number=number+1;
				if(number>=list.size())
				{
					number = number-list.size();
				}
			}
			removeList();
		}
		System.out.println(list.get(0));
	}
	
	public static void removeList()
	{
		list.remove(number);
		number = number-1;
		if(number==-1)
		{
			number = list.size()-1;
		}
	}

}

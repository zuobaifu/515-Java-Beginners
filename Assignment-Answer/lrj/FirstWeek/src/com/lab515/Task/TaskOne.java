package com.lab515.Task;
import java.util.Scanner;
/**
 * 说反话（Say the opposite）
 */
public class TaskOne {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
		String str=s.nextLine();
		String arr[]=str.split(" ");
		int i=arr.length-1;
		for(;(i)>0;i--)
		{
			System.out.print(arr[i]+" ");
		}
		System.out.println(arr[i]);
    }
}

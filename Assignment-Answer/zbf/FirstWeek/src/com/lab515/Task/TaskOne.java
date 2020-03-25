package com.lab515.Task;

/**
 * 说反话（Say the opposite）
 */
 import java.util.Scanner;
public class TaskOne {

    public static void main(String[] args) {
		String str = new String();
        Scanner sc = new Scanner(System.in);
        str = sc.nextLine();
        String[] str1 = str.split(" ");
        for(int i = str1.length - 1;i >= 0;i--)
        {
            System.out.print(str1[i]);
            System.out.print(" ");
        }
    }
}

package com.lab515.Task;

/**
 * 数字分类（Number classification）
 */
 import java.util.Scanner;
public class TaskTwo {

    public static void main(String[] args) {
		int n = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int A1 = 0;
        int A2 = 0;
        int m = 0;
        int A3 = 0;
        double A4 = 0.0;
        int k = 0;
        int A5 = 0;
        for (int i = 0; i < n; i++)
        {
            if(arr[i] % 2 == 0 && arr[i] % 5 == 0)
            {
                A1 += arr[i];
            }
            if(arr[i] % 5 == 1)
            {
                A2 += (Math.pow(-1,m) * arr[i]);
                m++;
            }
            if(arr[i] % 5 == 2)
            {
                A3++;
            }
            if(arr[i] % 5 == 3)
            {
                A4 += arr[i];
                k++;
            }
            if(arr[i] % 5 == 4)
            {
                if(arr[i] > A5)
                {
                    A5 = arr[i];
                }
            }
        }
        String t = "123";
        if(A4 != 0)
        {
            A4 = A4 / k;
            t=new java.text.DecimalFormat("#.0").format(A4);
        }
        if(A1 == 0)
        {
            System.out.print("N"+" ");
        }
        else
        {
            System.out.print(A1+" ");
        }
        if(A2 == 0)
        {
            System.out.print("N"+" ");
        }
        else
        {
            System.out.print(A2+" ");
        }
        if(A3 == 0)
        {
            System.out.print("N"+" ");
        }
        else
        {
            System.out.print(A3+" ");
        }
        if(A4 == 0)
        {
            System.out.print("N"+" ");
        }
        else
        {
            System.out.print(t+" ");
        }
        if(A5 == 0)
        {
            System.out.print("N"+" ");
        }
        else
        {
            System.out.print(A5+" ");
        }
    }
}

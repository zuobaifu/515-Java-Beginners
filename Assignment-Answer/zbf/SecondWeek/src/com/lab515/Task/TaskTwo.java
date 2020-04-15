package com.lab515.Task;

/**
 * 谁获得奖品
 */
public class TaskTwo {
	public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        int n,m;
        int k = 0;
        int j = 0;//出列人数
        System.out.print("请输入人数n : ");
        n = sc.nextInt();
        System.out.print("请输入报数m : ");
        m = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0;i < n;i++)
        {
            arr[i] = i+1;
        }
        for(int i = 0;i < n;i++)
        {
            if(arr[i] != 0)
            {
                k++;
            }
            if(k == m)
            {
                k = 0;
                arr[i] = 0;
                j++;
            }
            if(i == n - 1)
            {
                i = -1;
            }
            if(j == n - 1)
            {
                break;//如果出列人数比总人数少一
            }
        }
        for(int i = 0;i < n;i++)
        {
            if(arr[i] != 0)
            {
                System.out.print(arr[i]);
            }
        }
    }
}

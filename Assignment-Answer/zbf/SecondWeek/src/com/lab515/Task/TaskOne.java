package com.lab515.Task;

/**
 * 螺旋矩阵
 */
public class TaskOne {
	public static void main(String[] args) {
        int n = 0;
        int num = 1;
        int circle;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n / 2 == 0)
        {
            circle = n / 2;
        }
        else
        {
            circle = n / 2 + 1;
        }
        int arr[][] = new int[n][n];
            for(int i = 0;i < circle;i++)
            {
                //从左到右
                for(int j = i;j <= n - i - 1;j++)
                {
                    arr[i][j] = num++;
                }
                //从上到下
                for(int k = i + 1;k <= n - i - 1;k++)
                {
                    arr[k][n - i - 1] = num++;
                }
                //从右到左
                for(int m = n - i - 2;m >= i;m--)
                {
                    arr[n - i - 1][m] = num++;
                }
                //从下到上
                for(int l = n - i - 2;l > i;l--)
                {
                    arr[l][i] = num++;
                }
            }
            //输出
            for(int i = 0;i < n;i++)
            {
                for(int j = 0;j < n;j++)
                {
                    if(j < n - 1)
                    {
                        System.out.print(arr[i][j]+" ");
                    }
                    else
                    {
                        System.out.print(arr[i][j]);
                    }
                }
                if(i < n - 1)
                System.out.print(" ");
            }
        }
}

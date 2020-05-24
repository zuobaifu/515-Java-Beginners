package com.lab515.Task;

import java.util.Scanner;

/**
 * 推到吧骨牌（Push the dominoes）
 */

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch[] = new char[1000];
        String str = sc.next();
        ch = str.toCharArray();
        char ch1[] = new char[1000];//定义一个储存转换后的字符数组
        int a = 0;int k = 0;int a1 = 0;//a>0代表右倾，a<0代表左倾,a=0代表战立;k记录上一个"L"或"R"的下标,a1记录上一个是"L"还是"R"
        for(int i = 0;i < str.length();i++)
        {
            //左倾a<0
            if(ch[i] == 'L')
            {
                a = -1;
            }
            //站立a=0
            if(ch[i] == '.')
            {
                a = 0;
            }
            //右倾a>0
            if(ch[i] == 'R')
            {
                a = 1;
            }
            //此时对于"L"全是"."进行转换
            if(a1 == 0 && a < 0)
            {
                for(int j = 0;j <= i;j++)
                {
                    ch1[j] = 'L';
                }
            }
            //此时对于"R"全是"."进行转换
            if(a1 == 0 && a > 0)
            {
                for(int j = 0;j < i;j++)
                {
                    ch1[j] = '.';
                }
                ch1[i] = 'R';
            }
            //此时对于"L"或"R"右侧是"."进行转化
            if(a1 != 0 && a == 0)
            {
                for(int j = k+1;j <= i;j++)
                {
                    if(a1 > 0)
                    {
                        ch1[j] = 'R';
                    }
                    if(a1 < 0)
                    {
                        ch1[k] = 'L';
                        ch1[j] = '.';
                    }
                }
            }
            //此时对两侧是"L"或"R"进行转换
            //但要注意中间"."的个数依据"."的个数奇偶性进行分类讨论
            if(a != 0 && a1 != 0)
            {
                if((i + k) % 2 == 0)
                {
                    ch1[(i + k) / 2] = '.';
                    for(int j = k;j < ((i + k) / 2);j++)
                    {
                        if(a1 > 0)
                        {
                            ch1[j] = 'R';
                        }
                        if(a1 < 0)
                        {
                            ch1[k] = 'L';
                            if(j != k)
                            {
                                ch1[j] = '.';
                            }
                        }
                    }
                    for(int j = ((i + k) / 2) + 1;j < i;j++)
                    {
                        if(a > 0)
                        {
                            ch1[i] = 'R';
                            ch1[j] = '.';
                        }
                        if(a < 0)
                        {
                            ch1[j] = 'L';
                        }
                    }
                }
                else
                 {
                     for(int j = k;j <= (k+i-1) / 2;j++)
                     {
                         if(a1 > 0)
                         {
                             ch1[j] = 'R';
                         }
                         if(a1 < 0)
                         {
                             ch1[j] = 'L';
                         }
                     }
                     for(int j = ((k+i-1) / 2)+1;j <= i;j++)
                     {
                         if(a > 0)
                         {
                             ch1[j] = 'R';
                         }
                         if(a < 0)
                         {
                             ch1[j] = 'L';
                         }
                     }
                 }
            }
            //做这个判断是为了记录上一个"L"或"R"下标
            if(a != 0)
            {
                a1 = a;
                k = i;
            }
        }
		//输出转换后的字符数组
        for(int i = 0;i < str.length();i++)
        {
            System.out.print(ch1[i]);
        }
    }
}

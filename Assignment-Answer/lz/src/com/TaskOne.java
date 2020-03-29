package com.my;
import java.util.Scanner;// 包含输入的工具包
/**
 * 将一连串英语单词倒序输出
 * @author zhenli798
 *
 */
public class TaskOne {
	public static void main(String []args)
	{
		Scanner scan = new Scanner(System.in);// 创建输入扫描仪 
		String str;// 声明一个字符串
		str = scan.nextLine();// 获取用户输入的一行字符串
		char [] chr = str.toCharArray();// 将字符串转化成字符数组
		
		int end = chr.length-1; // 每个单词最后一个字母索引值
		int begin;// 每个单词首字母索引值
		for(int i = chr.length-1; i >= 0; i--)
		{
			if((chr[i] == 32)||i == 0)
			{// 是空格或者i为0的情况下
				if(i != 0)
					begin = i+1;// 每个单词的首字母索引值就变成空格索引值+1
				else
					begin = i;// 单词首字母索引值为0
				for(int k = begin; k <= end; k++)
				{
					System.out.print(chr[k]);// 输出单词
				}
				end = i-1;// 
			}
			if(chr[i] == 32)
				System.out.print(chr[i]);// 输出空格
		}
	}
}

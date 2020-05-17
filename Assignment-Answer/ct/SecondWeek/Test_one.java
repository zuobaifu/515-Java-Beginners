package com.lab515.Task;

import java.util.Scanner;
 
public class Test_one {
//-----固定的索引---------
	static int rowNumTop=0;
	static int colNumLeft=-1;
	static int rowNumBottom;
	static int colNumRight;
//------改变的索引--------
	static int colNumTop=1;
	static int rowNumRight=1;
	static int colNumBottom;
	static int rowNumLeft;
//----------------------
	static int number=1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int n;
		System.out.print("请输入螺旋矩阵的长度:");
		n =input.nextInt(); 
		int[][] num = new int[n][n];
		int z;
		int d=1;
		//编历
		 colNumRight=n;
		 rowNumBottom=n;
		 rowNumLeft=n-2;
		 colNumBottom=n-2;
		for(int i=n;i>0;i--)
		{
			 if(i==n)
			 { 
				 for(int l=0;l<i;l++)
				 {
					 num[0][l]=number;
					 number++;
				 }
			 }
			 else
			 {
				 z=0;
				 for(int k=0;k<2;k++)//循环转向
				 { 
					z++;
					seekIndex(num,i,z,d);			
				 }
				 d++;
			 }
		}
		//输出
		for(int[] sum : num)
		{
			for(int sum1 : sum)
			{
				System.out.print(sum1+" ");
			}
		}
		
	}
	//找不变的索引
	public static void seekIndex(int[][] a,int n,int m,int judge)
	{
		if(m==1)
		{
			if (judge%2==0)
			{//减
				 colNumLeft =colNumLeft+1;
				assignmentCol(a,colNumLeft,1, n);
			}
			else
			{//加
				colNumRight =colNumRight-1;
				assignmentCol(a,colNumRight,2,n);
			}
		}
		else if (m==2)
		{
			 if(judge%2==0)
			 {//加
				 rowNumTop =rowNumTop+1;
				 assignmentRow(a,rowNumTop,1,n);
			 }
			 else
			 {//减
				 rowNumBottom =rowNumBottom-1;
				 assignmentRow(a,rowNumBottom,2,n);
			 }
		}
	}
	
	//赋值
	public static void assignmentRow(int[][] a,int x,int n,int m)
	{
		switch(n)
		{
			case 1:
				int y=colNumTop;
				for (int i=0;i<m;i++)
				{
					a[x][y]=number;
					number++;
					y++;
				}
				colNumTop =colNumTop+1;
				break;
			case 2 :
				int Y=colNumBottom;
				for (int i=0;i<m;i++)
				{
					a[x][Y]=number;
					number++;
					Y--;
				}
				colNumBottom =colNumBottom-1;
				break;
			default:
				break;
		}
	}
	public static void assignmentCol(int[][] a,int y,int n,int m)
	{
		switch(n)
		{
			case 1:
				int x=rowNumLeft;
				for (int i=0;i<m;i++)
				{
					a[x][y]=number;
					number++;
					x--;
				}
				rowNumLeft =rowNumLeft-1;
				break;
			case 2 :
				int X =rowNumRight;
				for (int i=0;i<m;i++)
				{
					a[X][y]=number;
					number++;
					X++;
				}
				rowNumRight = rowNumRight+1;
				break;
			default:
				break;
		}
	}
}

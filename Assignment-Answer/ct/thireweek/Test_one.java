package cn.foflab.Thirdweek;

import java.util.Scanner;

public class Test_one {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int x ,y ;
		int num=0,sum=0;
		x = input.nextInt();
		y = input.nextInt();
		for(  ; x<=y ; x++ )//Ç¶Ì×Ñ­»·ÇóºÍ
		{
			num=0;
			for(int i=1 ; i<=x ; i++)
			{
				num += i ;
			}
			if(num%3==0)
				sum++;
		}
		 System.out.print(sum);
	}

}

package cn.foflab.firstweek.one;
import java.util.Scanner;

public class Test_two {
		public static void main(String[] args) {
			int n;
			Scanner input = new Scanner(System.in);
			n = input.nextInt();
			int[] number = new int[n];
			int sum1 = 0;
			int sum2 = 0;
			int num = 0;
			double avg = 0;
			int a = 0;
			int max = 0;
			int judge1 = 0;
			int judge2 = 0;
			for(int i=0;i<n;i++)
			{
				number[i] = input.nextInt();
			}
			for(int i=0;i<n;i++)
			{
				//A1
				if( (number[i]%5==0) && (number[i]%2==0) )
				{
					sum1 += number[i];
				}
				
				//A2
				if(number[i]%5==1)
				{
					if(judge1%2==0)
					{
						sum2 += number[i];
					}
					else
					{
						sum2 -= number[i];
					}
					judge1++;
				}
				
				//A3
				if(number[i]%5==2)
				{
					num++;
				}
				
				//A4
				if(number[i]%5==3)
				{
					avg += number[i];
					a++;
				}
				
				//A5
				if(number[i]%5==4)
				{
					if(judge2==0)
					{
						max = number[i];
						judge2++;
					}
					else
					{
						if(max<number[i])
						{
							max = number[i];
						}
					}
				}
			}
			avg = avg/a;
			//精确两位小数。
			avg = (double)((int)(avg*100))/100 ;
			//两位变一位。
			avg = (double)((int)(avg*10+0.5))/10;
			
			System.out.println(sum1+" "+sum2+" "+num+" "+avg+" "+max);
			 
			
		}
}

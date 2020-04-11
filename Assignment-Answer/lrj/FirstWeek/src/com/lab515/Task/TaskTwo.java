package com.lab515.Task;
import java.util.Scanner;
import static java.lang.Math.*;
/**
 * 数字分类（Number classification）
 */
public class TaskTwo {

    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
		int arr[]={0,0,0,0,0};
		int n=s.nextInt();
		int m,k=0;
		double c1=0;
		for(int i=0;i<n;i++){
			m=s.nextInt();
			switch(m%5) {
			case 0:{
				if(m%2==0)
					arr[0]+=m;
				break;
			}
			case 1:{
				arr[1]+=pow(-1,k)*m;
				k++;
				break;
			}
			case 2:{
				arr[2]++;
				break;
			}
			case 3:{
				arr[3]+=m;
				c1++;
				break;
			}
			case 4:{
				if(m>arr[4])
					arr[4]=m;
				break;
			}
			}
		}
		for(int i=0;i<5;i++) {
			if(arr[i]==0) {
				System.out.print("N");
			}
			else {
				if(i==3) {
					System.out.print(String.format("%.1f", arr[i]/c1));
				}
				else {
					System.out.print(arr[i]);
				}
			}
			if(i<4)
				System.out.print(" ");
		}
    }
}

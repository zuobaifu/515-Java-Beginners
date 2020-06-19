package com.lab515.Task;
import java.util.Scanner;
/**
 * 被 3 整除（Be divided exactly by 3）
 */
public class One {
    public static void main(final String[] args) {
        final Scanner s = new Scanner(System.in);
		int l,r,num = 0;
		l = s.nextInt();
		r = s.nextInt();
		for(int i = l;i <= r;i++)
		{
			if(i % 3 != 1)
				num++;
		}
		System.out.println(num);
		
	}
}

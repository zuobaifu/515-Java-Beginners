package com.lab515.Task;

/**
 * 说反话（Say the opposite）
 */
public class TaskOne {

    public static void main(String[] args) {
			Scanner a = new Scanner(System.in); 
			String str = a.nextLine();
			String[] strs = str.split(" ");
			for (int i = strs.length - 1;i>=0;i--)
			{
				if(i!=0)
				{
					System.out.print(strs[i] + " ");
				}
				else
				{
					System.out.println(strs[i]);
				}
			}
			a.close();

    }
}

package com.lab515.Task;

/**
 * 数字分类（Number classification）
 */
public class TaskTwo {

    public static void main(String[] args) {
	Scanner a = new Scanner(System.in);
		int n = a.nextInt();
		int [] nums = new int [n];
		int [] counts = new int [5];
		for(int i = 0;i<n;i++)
		{
			nums[i] = a.nextInt();
		}
		boolean c = true;
		int count = 0;
		for (int i = 0;i< nums.length;i++)
		{
			switch (nums[i]%5)
			{
			    case 0:
			    	if (nums[i]%2 == 0)
			    	{
			    		counts[0] += nums[i];
			    	}
			    	break;
			    case 1:
			    	if (c) 
			    	{
			    		counts[1] += nums[i];
			    		c = false;
			    	}
			    	else
			    	{
			    		counts[1] -= nums[i];
			    		c = true;
			    	}
			    	break;
			    case 2:
			    	counts[2]++;
			    	break;
			    case 3:
			    	counts[3] += nums[i];
			    	count ++;
			    	break;
			    case 4:
			    	if(nums[i]>counts[4])
			    	{
			    		counts[4] = nums[i];
			    	}
			    	break;
			}
		}
		for (int i=0;i<5;i++)
		{
			if(i == 4)
			{
				if(counts[i] == 0)
				{
					System.out.print("N");
				}
				else
				{
					System.out.print(counts[i]);
				}
			}
			else if(i == 3)
				{
					if(count != 0)
					{
						System.out.printf("%.1f",(double)counts[3]/count);
						System.out.print(" ");
					}
					else
					{
						System.out.print("N");
					}
					
				}
			else{
				if(counts[i] == 0)
				{
					System.out.print("N");
				}
				else
				{
					System.out.print(counts[i] + " ");
				}
			}
		}
    }
}

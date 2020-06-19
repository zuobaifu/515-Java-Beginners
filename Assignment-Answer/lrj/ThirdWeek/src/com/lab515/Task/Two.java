package com.lab515.Task;

/**
 * 推到吧骨牌（Push the dominoes）
 */
public class Two {
    public static void main(String[] args) 
	{
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		int id = -1,hr = 0,hd = 0;//id是下标，hr表示前面有没有R,hd两个R间有没有.
		char [] arr = str.toCharArray();//关键
		for(int i = 0;i < str.length();i++)
		{
			if(arr[i] == '.')
			{
				if(hr == 1)
					hd = 1;
			}
			else if(arr[i] == 'L')
			{
				if(hr == 0)
				{
					for(int j = id + 1;j <= i;j++)//把左边一段变L
					{
						arr[j] = 'L';
					}
					id = i;
				}
				else//RL之间的
				{
					int a = id,b = i;
					while(a < b)
					{
						arr[a] = 'R';
						arr[b] = 'L';
						a++;
						b--;
					}
					hr = 0;//重置
					id = i;
					hd = 0;
				}
			}
			else//扫到R
			{
				if(hd == 1)
				{
					for(int j = id +1;j < i;j++)
					{
						if(arr[j] == '.')
						{
							arr[j] = 'R';
						}
					}
				}
				id = i;
				hr = 1;
			}
		}
		if(hr == 1)//要是后面只有R和.了，就一波走完
		{
			for(int i = id + 1;i < str.length();i++)
			{
				arr[i] = 'R';
			}
		}
		System.out.println(arr);
	}
}

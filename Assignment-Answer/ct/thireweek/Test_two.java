package cn.foflab.Thirdweek;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Test_two {
	static ArrayList<Character> list =  new ArrayList<Character>();
	static LinkedList<String> arrstr = new LinkedList<String>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String str ;
		int num = 0;
		str = input.nextLine();
		for(int i=0;i<str.length();i++)
		{
			list.add(str.charAt(i));
		}
		for(int i=0;i<list.size();)
		{
			 switch (list.get(i))
			 {
			 	case 'L' :
			 		num=1;
			 		arrstr.add("L");
			 		break;
			 	case 'R' :
			 		num=1;
			 		arrstr.add("R");
			 		break;
			 	case '.' :
			 		num=1;
			 		while(true)
			 		{
			 			if(i!=list.size()-1 && i+num != list.size() && list.get(i+num) == '.')
			 			{
			 				num++;
			 			}
			 			else
			 				break;
			 		}
			 		arrstr.add(addString(num-1,".","."));
			 }
			 i = i + num;
		}
		arrstr.addFirst(" ");
		arrstr.add(" ");		
		for(int i=1;i<arrstr.size()-1;i++)
		{
			if(arrstr.get(i)!="L"&&arrstr.get(i)!="R")
			{
				if( (arrstr.get(i-1)==" "&& arrstr.get(i+1)=="L") || (arrstr.get(i-1) == arrstr.get(i+1) && arrstr.get(i+1)=="L") )
				{
					arrstr.set( i , addString( seekSum( arrstr.get(i) )-1 , "L","L") );
				}
				else if ( (arrstr.get(i-1)=="R"&& arrstr.get(i+1)==" ") || (arrstr.get(i-1) == arrstr.get(i+1) && arrstr.get(i+1)=="R") )
				{
					arrstr.set( i , addString( seekSum( arrstr.get(i) )-1 ,"R","R") );
				}
				else if(arrstr.get(i-1)=="R"&&arrstr.get(i+1)=="L" && seekSum(arrstr.get(i))!=1 )
				{
					arrstr.set(i, changeString( "R" , "L" , seekSum(arrstr.get(i)) ) );
				}
			 }
			else
				continue;
		}
		arrstr.removeFirst();
		arrstr.removeLast();
		for(String S : arrstr)
		{
			System.out.print(S);
		}
}
public static String changeString(String a,String b,int n)
{
	String x;
	switch (n%2)
	{
	case 0 :
		x = addString(n/2,addString(n/2-1,a,a),b);
		break;
	case 1 :
		x = addString(n/2, addString( 1, addString(n/2-1,a,a) , ".") , b ) ;
		break;
	default :
		x = "error";
		break;
	}
	return x;
}	
public static int seekSum(String a)
{
	int n=0;
	while(a.indexOf(".")>=0)
	{
		a = a.substring(a.indexOf(".") + 1 );
		n++;
	}
	return n;
}	
public static String addString(int n,String s,String b)
{
	for(int i=1;i<=n;i++)
	{
		 s = s + b;
	}
	return s ;
}
}
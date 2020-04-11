

package cn.foflab.firstweek.one;

//import java.util.Arrays;

import java.util.Scanner;

public class Test_one {
	 public static void main(String[] args) {
	     Scanner input = new Scanner(System.in);
	     String Str = input.nextLine();
	     int[] index= new int[40];
	     index[0] = 0;
	     int i=1;
	     int m=1;
	     int n=0;
	     int j=0;
	     String[] strs = new String[40];
	     
	     // ÕÒ¿Õ¸ñ
	     while(m!=0)
	     {
	    	 index[i] = Str.indexOf(" ", m);
	    	 m = index[i] +1 ;
	    	 i++;
	     }
	     index[i-1]=Str.length();
	     
	     //ÇÐ¸î×Ö·û´®
	    for( ;j<i-1;j++)
	    {
	    	if(n==0)
	    	{
	    		strs[j] = Str.substring(index[j], index[j+1]);
	    		n++;
	    	}
	    	else
	    	{
	    		strs[j] = Str.substring(index[j]+1, index[j+1]);
	    	}
	    	 
	    }
	    
	    //ÄæÐòÊä³ö
	      for(int k=(j-1);k>=0;k--)
	      {
	    	  if(k==0)
	    	  {
	    		   System.out.print(strs[k]);
	    	  }
	    	  else
	    	  {
	    		  System.out.print(strs[k]);
	    	  	  System.out.print(" ");
	    	  }	  
	      }   
	    }     	
 }


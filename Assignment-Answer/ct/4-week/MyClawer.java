package cn.lab.MAVEN.spider;

import org.apache.http.HttpEntity;
 import org.apache.http.NameValuePair;
 import org.apache.http.client.entity.UrlEncodedFormEntity;
 import org.apache.http.client.methods.CloseableHttpResponse;
 import org.apache.http.client.methods.HttpGet;
 import org.apache.http.client.methods.HttpPost;
 import org.apache.http.impl.client.CloseableHttpClient;
 import org.apache.http.impl.client.HttpClients;
 import org.apache.http.message.BasicNameValuePair;
 import org.apache.http.util.EntityUtils;
 import java.util.ArrayList;
 import java.util.List;
 import java.util.regex.Matcher;
 import java.util.regex.Pattern;
 			//因为网易云有加密，用普通get请求会得到一段不合条理且没有关键信息的源码。
    	  	//通过对网页源码的Network，找到评论在http://music.163.com/weapi/v1/resource/comments/R_SO_4_1436910205?csrf_token=文件里  1436910205为歌曲id.
    	  	//用post对该文件进行获取。
 public class MyClawer {
    
      public static void main(String[] args) throws Exception {
    	  
    	                                                                  //1436910205 为歌曲id 可改变来获取其他歌曲评论。
    	 String u = "http://music.163.com/weapi/v1/resource/comments/R_SO_4_1436910205?csrf_token=" ;
         printHot(u);
     } 
  
      public static ArrayList getcommit(String a){
          ArrayList<String> commitList = new ArrayList<String>() ;
          ArrayList<String> List = new ArrayList<String>();
          int n=1;
          while(true)
          {  
        	  //少于十条自动结束
        	  if(n==11||a.indexOf("time")==-1)
        		  break;
        	  commitList.add(a.substring(a.indexOf("content\":\"")+10, a.indexOf("\",\"time")));
        	  a = a.substring(a.indexOf("time")+4);
        	  n++;  
          }
          
          //替换特殊符号
          for(int i=0;i<commitList.size();i++)
          {
        	  List.add(commitList.get(i).replace("\\n", ""));
          }
          
         return  List ;
     }
      
   public static void printHot(String u) throws Exception{
         CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;
         HttpPost httpPost = new HttpPost(u) ;
         
         //User-Agent会告诉网站服务器，访问者是通过什么工具来请求的,以下为Chrome浏览器查看User-Agent的结果：
         httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
                                       
         List<NameValuePair> list=new ArrayList<NameValuePair>();
         
         //添加传送参数
         list.add(new BasicNameValuePair("params","RlBC7U1bfy/boPwg9ag7/a7AjkQOgsIfd+vsUjoMY2tyQCPFgnNoxHeCY+ZuHYqtM1zF8DWIBwJWbsCOQ6ZYxBiPE3bk+CI1U6Htoc4P9REBePlaiuzU4M3rDAxtMfNN3y0eimeq3LVo28UoarXs2VMWkCqoTXSi5zgKEKbxB7CmlBJAP9pn1aC+e3+VOTr0"));
         list.add(new BasicNameValuePair("encSecKey","76a0d8ff9f6914d4f59be6b3e1f5d1fc3998317195464f00ee704149bc6672c587cd4a37471e3a777cb283a971d6b9205ce4a7187e682bdaefc0f225fb9ed1319f612243096823ddec88b6d6ea18f3fec883d2489d5a1d81cb5dbd0602981e7b49db5543b3d9edb48950e113f3627db3ac61cbc71d811889d68ff95d0eba04e9"));
         
         httpPost.setEntity(new UrlEncodedFormEntity(list));
         
         //创建请求
          CloseableHttpResponse response=closeableHttpClient.execute(httpPost);
          
          HttpEntity entity=response.getEntity();
          //取文件
          String filecontent = EntityUtils.toString(entity,"utf-8") ;
          
         ArrayList<String> Commits= getcommit(filecontent);
        for(int i=0;i<Commits.size();i++)
        {
        	System.out.println(Commits.get(i));
        	System.out.println();
        }
     } 
 }
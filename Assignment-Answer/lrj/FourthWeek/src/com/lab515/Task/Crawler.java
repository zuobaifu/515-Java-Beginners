package com.lab515.Task;

/**
 * 爬虫
 */
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

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Crawler {
    public static void GetPage(String url) throws Exception
	{
		CloseableHttpClient closeableHttpClient = HttpClients.createDefault() ;//创建httpClient实例
		         HttpPost httpPost = new HttpPost(url) ;//建立httppost对象
		         httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
		
		         List<NameValuePair> list=new ArrayList<NameValuePair>();//建立一个NameValuePair数组，用于存储欲传送的参数，密文每次都得换！！！
		         list.add(new BasicNameValuePair("params","AoKrRf4msRjA14syYuWsvifyM2j4c0cbV+RFiHF72FgO2WMs2i+8THNpnX/7o1ojkUILA2n+SDCq4ubZs8C9S/kewwB1G/LRy6DbVf9rxbag17Faw+fQuIUyxLM4JqEtfo/Qn6vZGULscAPFqcoY6R4zUEjvW9oD/lGyZuHGRwpLaKGivt4gA0ouwwBODgPB"));
		         list.add(new BasicNameValuePair("encSecKey","2eb42350b10a3d4a767d4532208c6109ec6511ee2ff1c5c412f7ec84a3a8e8d2db2915aa79b2592867091f1fe02c0eb53997577c6fb7261d38b2b7f95854a02c841e7f0e558e8dc19f882426b7aea8f1ed6168b056afc02af8ec15b9407f6944afa9b5f1d0937e740640f911d0cefebddd40121877360ea94538a6066ad1c25b"));
		 
		         httpPost.setEntity(new UrlEncodedFormEntity(list));//设置编码
		         CloseableHttpResponse response=closeableHttpClient.execute(httpPost);//发送Post,并返回一个HttpResponse对象
		 
		         HttpEntity entity=response.getEntity();
		         String ux = EntityUtils.toString(entity,"utf-8") ;
		         //System.out.println(ux);
		         ArrayList<String> s= getbook(ux);
		         for(int i=0;i<s.size();i++){//不太懂这里该怎么改
		        	         String []arr = s.get(i).split("\"") ;
		        	         System.out.println(arr[2]);
		        	          }
	}
	
	public static void main(String[] args) throws Exception
	{
		String url = "https://music.163.com/weapi/v1/resource/comments/R_SO_4_1418726489?csrf_token=";
		GetPage(url);
	}
	public static ArrayList getbook(String read)//把评论分割加入数组
	{
		ArrayList<String> arrayList = new ArrayList<String>() ;
		 
		         String con = "content(.*?)\"}" ;
		         Pattern ah = Pattern.compile(con);
		         Matcher mr = ah.matcher(read);
		         while(mr.find()) {
		             if (!arrayList.contains(mr.group())) {
		                 arrayList.add(mr.group());
		             }
		         }
		         return  arrayList ;
	}
}

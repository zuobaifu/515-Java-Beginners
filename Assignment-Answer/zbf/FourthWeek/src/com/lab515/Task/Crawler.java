package com.lab515.Task;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
/**
 * 爬虫
 */
public class Crawler {
	public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://music.163.com/weapi/v1/resource/comments/R_SO_4_1363553512?csrf_token=");
        httpPost.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.101 Safari/537.36");
        //声明list集合封装参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();

        //设置具体的请求地址
        params.add(new BasicNameValuePair("params","kRzACrBr9yvCLtP3LDvGIwikt64KvjhgRzUItM/GoPl+BPATyrobPKKGhbGJYQnL+LIK8X5DpRa9oWdNzNDtDc6fKqqwNoxE5lHH5pmaMTHUG7GzzGn9UMxD0ckHWv9HexA08nZ3hxoaBItMMW/cM1GOz8oRN3ZW2b1aLTOw0NHF5I5rD0DTxnqfjBvNfcHb"));
        params.add(new BasicNameValuePair("encSecKey","cad4dd32583fe767a1f62029f01e565f5e31f9576769ad35ea780e9b71e63a5df420843d18149231bd06eaa5fa0f3f64e4b656fdcea320e3c0452a71d35fabfade2f30dc95f37b12863363e0fa43f55befa8f40e56ac5a9aad2bb4bb5ee2dc64c133eca07f483f3afcd3b9aee88025ff8732aa12301505a29b6cd6af33733126"));
        //创建表单的entity对象
        UrlEncodedFormEntity formEntity = null;
        try {
             formEntity = new UrlEncodedFormEntity(params,"utf8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //设置表单的entity对象到post请求中
        httpPost.setEntity(formEntity);
        CloseableHttpResponse response = null;
        try {
             response = httpClient.execute(httpPost);
             if(response.getStatusLine().getStatusCode() == 200)
             {
                 HttpEntity httpEntity = response.getEntity();
                 String content = EntityUtils.toString(response.getEntity(), "utf-8");
                 JSONObject jsonObject = JSONObject.parseObject(content);
                 JSONArray hotComments = jsonObject.getJSONArray("hotComments");
                 for(int i = 0 ;i< 10;i++) {
                     System.out.println("热评"+ (i+1) + ":" + hotComments.getJSONObject(i).getString("content"));
                 }
             }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

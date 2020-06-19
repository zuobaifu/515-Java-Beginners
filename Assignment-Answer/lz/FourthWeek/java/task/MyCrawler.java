package task;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class MyCrawler {
	public static void printHot(String u) throws Exception{
		
		// ����httpclient����
		CloseableHttpClient httpClient = HttpClients.createDefault();
		// ����httppost���󣬷���post����
		HttpPost httpPost = new HttpPost(u);
		httpPost.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.61 Safari/537.36");
		
		List<NameValuePair> list = new ArrayList<NameValuePair>();
		list.add(new BasicNameValuePair("params", "xJUJqp9YkO6GxC+PpZBoOBdf2z+QgHUGLxENggA1gMWNSQaPOwNqiOqWEUdwLfFp1oNYJHzpOr/V3JhgoSfUrkbJGvVwZiYnQ5e6S3UAm2UtwxACLXpGG1KkJURKYHgVFlibFjcpfHPb1xkuU+IMwf+Bsis29HJ4rG5+oHYLdyEHr97f0oYXvmlUJZD1Sljw"));
		list.add(new BasicNameValuePair("encSecKey", "0e632a4385150070c27c7e651f91ec9d0630cd1bf7d8c563501ddab8214555e539a14f2134139a46a4770a5421637d7cfc18521637db6221989dc33b910ca7614bb3437092a0a9e9756743d24ba7f7865c3ec21b6d93549f2e8ec74a5708159e489ec00c31d9451cd7084769cc0c8caefb2f364deb017bc59020bee87217711b"));

		// �����ݱ���ɺ������ݴ��ͳ�ȥ
		httpPost.setEntity(new UrlEncodedFormEntity(list));
		
		// ʹ��httpclient�������󣬻�ȡһ��response
		CloseableHttpResponse response = httpClient.execute(httpPost);
		
		// ������Ӧ����ȡ����
		HttpEntity entity = response.getEntity();
		String ux = EntityUtils.toString(entity,"utf-8") ;
		
		ArrayList<String> s = getBook(ux);
		
		// ���༸�β�����ʮ��������������������������û�������ȶ���ʮ��������
		for (int i = 0; i < 10; i++)
		{
			String []arr = s.get(i).split("\"");
			System.out.println(arr[2]);
		}
	}

	public static void main(String []args) throws Exception{
		String u = "https://music.163.com/weapi/v1/resource/comments/R_SO_4_449818741?csrf_token=";
		printHot(u);
	}
	public static ArrayList<String> getBook(String ux) {
		// ���������������һ����̬����arrayList�У����ظö�̬����
		 ArrayList<String> arrayList = new ArrayList<String>();
		 
		 String con = "content(.*?)\"}" ;
		 Pattern ah = Pattern.compile(con);
		 Matcher mr = ah.matcher(ux);
		 while(mr.find()) {
			 if (!arrayList.contains(mr.group())) {
				 arrayList.add(mr.group());
			 }
		 }
		return arrayList;
	}
}
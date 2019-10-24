package dong.com.JavaInterfaceAotoTest;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/** 

* @Description: 该类主要是通过httpclient 模拟get、post有参和无参的http请求
*      
用HttpClient发送请求、接收响应很简单，一般需要如下几步即可。

1. 创建HttpClient对象。

2. 创建请求方法的实例，并指定请求URL。如果需要发送GET请求，创建HttpGet对象；如果需要发送POST请求，创建HttpPost对象。

3. 如果需要发送请求参数，可调用HttpGet、HttpPost共同的setParams(HetpParams params)方法来添加请求参数；对于HttpPost对象而言，也可调用setEntity(HttpEntity entity)方法来设置请求参数。

4. 调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse。

5. 调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；调用HttpResponse的getEntity()方法可获取HttpEntity对象，该对象包装了服务器的响应内容。程序可通过该对象获取服务器的响应内容。

6. 释放连接。无论执行方法是否成功，都必须释放连接
* 
* 
* 
* @author: zhangdongdong
* @Date: 2019年10月18日 下午4:53:16
 

*/


public class TestHttpClient {
	
	/**
	 * 
	 *@description  该方法用来模拟 无参的 get的请求
	 *2019年10月22日上午9:48:03
	 */
	@Test
	public void testGestReq()  {
		//create htttpClient对象
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		//create 一个get请求
		HttpGet httpGet =new HttpGet("http://www.baidu.com");
		//create 一个响应对象
		CloseableHttpResponse response=null;
		try {
			//发起get请求
			 response = httpClient.execute(httpGet);
			 //从响应对象中获取响应实体
			HttpEntity httpEntity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(httpEntity, "UTF-8");
				System.out.println("收到响应:" + result);
			}
			else {
				System.out.println("err:" + response.getStatusLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 *@description 该方法模拟一个带参数的get请求
	 *2019年10月22日上午10:12:43
	 */
	@Test
	public void testGetReqWithParms() {
		
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		URI uri=null;
		try {
			List<NameValuePair> parms =new ArrayList<NameValuePair>();
			parms.add(new BasicNameValuePair("id", "1001"));
			parms.add(new BasicNameValuePair("name", "lisi"));
			uri = new URIBuilder().setScheme("http").setHost("www.baidu.com").setParameters(parms).build();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		HttpGet getReq= new HttpGet(uri);
		
		CloseableHttpResponse response =null;
		
		try {
			response= httpClient.execute(getReq);
			//获取响应实体
			HttpEntity responsEntity = response.getEntity();
			
			if (response.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
				String result = EntityUtils.toString(responsEntity,"UTF-8");
				System.out.println("收到的响应："+ result);
			} else {
				
				System.out.println("error:"+response.getStatusLine());
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * 
	 *@description 该方法模拟post 无参请求 
	 *2019年10月22日下午2:34:13
	 */
	@Test
	public void testPostReq() {
	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
	HttpPost postReq= new HttpPost("http://10.10.51.150:6666/postreq1");
	CloseableHttpResponse response =null;
	
	try {
		response= httpClient.execute(postReq);
		HttpEntity entity = response.getEntity();
		if (response.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
			String result = EntityUtils.toString(entity);
			System.out.println("收到响应："+ result);
		}else {
			System.out.println("error:"+response.getStatusLine());
		}
	}  catch (IOException e) {
		e.printStackTrace();
	}
	
		
	}
	
	/**
	 * 
	 * @description 该方法模拟请求参数为form格式的 post请求 
	 * 2019年10月23日下午2:02:11
	 */
	@Test
	public void testPostReqWithParms() {
		// create 一个httpclient对象，模拟客户端
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost posReq = new HttpPost("http://10.10.51.150:6666/postreq");
		// create 一个post请求
		try {
			List<NameValuePair> parms = new ArrayList<NameValuePair>();
			parms.add(new BasicNameValuePair("id", "001"));
			parms.add(new BasicNameValuePair("name", "lisi"));
			HttpEntity entity =new UrlEncodedFormEntity(parms);
			posReq.setEntity(entity);
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		// create 一个response 对象接受响应
		CloseableHttpResponse response = null;
		try {
			response = httpClient.execute(posReq);
			HttpEntity responsEntity = response.getEntity();
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String result = EntityUtils.toString(responsEntity);
				System.out.println("收到响应：" + result);
			} else {
				System.out.println("error:" + response.getStatusLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 *@description  该方法模拟 请求参数为json格式的post请求
	 *2019年10月23日下午2:55:21
	 */
	@Test
	public void testPostReqWithJsonParms() {
		//create 一个httpclient对象，模拟客户端
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		//create 一个post请求
		HttpPost posReq= new HttpPost("http://10.10.51.150:6666/req/postJsonparms");
		String jsonString="{\"funcode\":\"xxzz\",\"reqDate\":\"20191018\",\"reqTime\":\"125511\"}";
		StringEntity sentity = new StringEntity(jsonString, "utf-8");
		posReq.setEntity(sentity);
		posReq.setHeader("Content-Type", "application/json;charset=utf-8");
		//create 一个response 对象接受响应
		CloseableHttpResponse response= null;
		try {
			response = httpClient.execute(posReq);
			HttpEntity rsponsEntity = response.getEntity();
			if (response.getStatusLine().getStatusCode()==HttpStatus.SC_OK) {
				String result = EntityUtils.toString(rsponsEntity);
				System.out.println("收到响应："+ result);
				JSONObject jsonObject = JSON.parseObject(result);
				assertEquals(jsonObject.get("retCode"), "0000");
				
			} else {
				System.out.println("error:"+response.getStatusLine());
			}
		}  catch (IOException e) {
			e.printStackTrace();
		}
	}

}

package com.yd.common.utils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.yd.common.data.CIPResponseMsg;

/**
 * 发送HTTP请求工具类
 * @author Rong.zhu
 *
 */
public class HttpUtils {
	private final static int CONNECT_TIMEOUT_VALUE = 20000;//请求(连接)超时:20秒
	private final static int SOCKET_TIMEOUT_VALUE = 60000;//响应超时:60秒,一定要设置，否则可能导致当前线程一直处于等待状态
	
	private static RequestConfig requestConfig;
	private static ResponseHandler<String> responseHandler;
	
	static{
		requestConfig = RequestConfig.custom()
				.setConnectTimeout(CONNECT_TIMEOUT_VALUE)//请求超时:connect timed out. connect refused
		        .setSocketTimeout(SOCKET_TIMEOUT_VALUE) //响应超时:response timed out 
		        .build();
		
		responseHandler = new ResponseHandler<String>() {
            public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
                int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    return entity != null ? EntityUtils.toString(entity, "UTF-8") : null;
                } else {
                    throw new ClientProtocolException("request failed,unexpected response status: " + status);
                }
            }
        };
	}
	
	
	public static CIPResponseMsg post(String url, Object sendData )throws Exception {
		HttpPost httppost = new HttpPost(url);
		httppost.setConfig(requestConfig);
		StringEntity entity = new StringEntity(JSONUtils.convertObject2Json(sendData),ContentType.create("application/json","UTF-8"));
		
		httppost.setEntity(entity);
        CloseableHttpClient httpClient = null;
        String responseBody = null;
        try{
        	httpClient = HttpClients.createDefault();
        	responseBody = httpClient.execute(httppost, responseHandler);
        }finally{
        	if(httpClient != null) {
        		httpClient.close();
        	}
        }
		return JSONUtils.convertJson2Object(responseBody, CIPResponseMsg.class);
	}
	
	/**
	 * 发送POST请求,该方法将会对参数进行UTF-8编码
	 * @param url
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public static String post(String url, Map<String, String> params) throws Exception {
		//封装请求参数
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if(params != null) {
			Set<Entry<String, String>> entrySet = params.entrySet();
			for(Entry<String, String> entry : entrySet) {
				nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
			}
		}
		//对参数进行转码（特殊字符）
		UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvps, "UTF-8"); 
		HttpPost httppost = new HttpPost(url);
		httppost.setConfig(requestConfig);
		httppost.setEntity(entity);
        CloseableHttpClient httpClient = null;
        String responseBody = null;
        try{
        	httpClient = HttpClients.createDefault();
        	responseBody = httpClient.execute(httppost, responseHandler);
        }finally{
        	if(httpClient != null) {
        		httpClient.close();
        	}
        }
		return responseBody;
	}
	
	
	/**
	 * 发送GET请求,该方法将会对参数进行UTF-8编码
	 * @param url
	 * @return
	 * @throws Exception
	 */
	public static String get(String url) throws Exception {
		StringBuffer encodedUrl = new StringBuffer();
		if(url.contains("?")) {
			encodedUrl.append(url.substring(0,url.lastIndexOf("?"))).append("?");
			String paramstr = url.substring(url.lastIndexOf("?")+1);
			String[] params = paramstr.split("&");
			for(String param: params) {
				String pkey = param.substring(0,param.lastIndexOf("="));
				String pvalue = param.substring(param.lastIndexOf("=")+1);
				encodedUrl.append(pkey).append("=").append(URLEncoder.encode(pvalue,"UTF-8")).append("&");//UTF-8转码
			}
			String temp = encodedUrl.toString();
			temp.substring(0, temp.lastIndexOf("&"));
			encodedUrl = new StringBuffer(temp);
		}else {
			encodedUrl.append(url);
		}
		HttpGet httpGet = new HttpGet(encodedUrl.toString());
		CloseableHttpClient httpClient = null;
        String responseBody = null;
        try{
        	httpClient = HttpClients.createDefault();
        	responseBody = httpClient.execute(httpGet, responseHandler);
        }finally{
        	if(httpClient != null) {
        		httpClient.close();
        	}
        }
		return responseBody;
	}

}

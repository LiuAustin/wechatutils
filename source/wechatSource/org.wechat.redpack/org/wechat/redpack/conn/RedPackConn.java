package org.wechat.redpack.conn;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyStore;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * 请注意,该类中的方法依赖以下几个jar
 * httpclient4.3.4.jar 
 * httpcore-4.3.2.jar
 * commons-logging-1.1.3.jar
 * @author Andy
 *
 */
public class RedPackConn {
	private static final String SENDREDPACK="https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";		//发送现金红包
	private static final String GETHBINFO="https://api.mch.weixin.qq.com/mmpaymkttransfers/gethbinfo";			//获取红包信息  (现金和裂变都是该接口)
	private static final String SENDGROUPREDPACK="https://api.mch.weixin.qq.com/mmpaymkttransfers/sendgroupredpack";	//发送裂变红包
	public static final String KEYSTORETYPE="PKCS12";				//密匙类型
	
	
	/**
	 * 获取安全连接的方法,使用该方法进行连接
	 * @param certPath			证书的路径
	 * @param macid				商户号id
	 * @return		返回安全连接  (该安全连接添加了商户号,证书后的安全连接,
	 * 				在微信API中制定需要证书的地方则通过该方法进行执行)
	 */
	private static CloseableHttpClient getSecureConn(String certPath,String macid){
		char[] array = macid.toCharArray();
		FileInputStream instream = null;
		CloseableHttpClient httpClient = null;
		KeyStore keyStore = null;
	    try {
		    keyStore  = KeyStore.getInstance(KEYSTORETYPE);
	        instream = new FileInputStream(new File(certPath));
	        keyStore.load(instream, array);
        }catch(Exception ex){
        	ex.printStackTrace();
        } finally {
        	try{
        		instream.close();
        	}catch(Exception ex){
        		ex.printStackTrace();
        	}
        }
        try{
	        SSLContext sslcontext = SSLContexts.custom().loadKeyMaterial(keyStore,array).build();
	        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory( sslcontext,new String[] { "TLSv1" }, null,SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
	        httpClient = HttpClients.custom()
	                .setSSLSocketFactory(sslsf)
	                .build();
        }catch(Exception ex){
        	ex.printStackTrace();
        }
		return httpClient;
	}
	
	/**
	 * 执行安全连接
	 * @param data	   请求数据的参数
	 * @param path
	 * @param charter
	 * @param certPath
	 * @param macid
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public static String executeConn(String data,String path,String certPath,String macid) throws ClientProtocolException, IOException{
		String result="";
		CloseableHttpClient httpclient = getSecureConn(certPath,macid);
        try{
        	result = execute(httpclient,path,data);
        }catch(Exception ex){
        	ex.printStackTrace();
        }
        return result;
    }
	
	/**
	 * 返回普通连接	
	 * @param data	请求时所带的参数
	 * @param path	请求的路径
	 * @return
	 */
	public static String executeConn(String data,String path){
		String result = "";
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			result = execute(httpclient,path,data);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * 执行网络请求
	 * @param httpclient	待执行的请求client,其中包括安全cleint
	 * @param path			请求路径
	 * @param data			请求数据
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	private static String execute(CloseableHttpClient httpclient,String path,String data) throws ClientProtocolException, IOException{
		String result = "";
		try {
            HttpPost httpPost = new HttpPost(path);
            StringEntity rentity = new StringEntity(data);
            rentity.setContentEncoding("UTF-8");
            rentity.setContentType("application/json;charset=utf8");
            httpPost.setEntity(rentity);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            StringBuffer buffer = new StringBuffer();
            try {
                HttpEntity entity = response.getEntity();
                System.out.println(response.getStatusLine());
                if (entity != null) {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
                    String text;
                    while ((text = bufferedReader.readLine())!= null) {
                        buffer.append(text);
                    }
                }
                result = buffer.toString();
                EntityUtils.consume(entity);
            } finally {
                response.close();
            }
        } finally {
            httpclient.close();
        }
        return result;
	}
	
	/**
	 * 发送红包方法 	(注意该方法如果请求参数中有中文,则会出现签名错误有待解决)
	 * @param data		 			请求对象的json数据集	
	 * @param certPath				证书的路径, 
	 * @param macid					商户号
	 * @return						请求结果后的返回信息
	 */
	public static String sendRedInfo(String data,String certPath,String macid){
		String result="";
		try {
			result = executeConn(data,SENDREDPACK,certPath,macid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
    }
	
	/**
	 * 获取红包信息
	 * @param data		请求参数对象
	 * @param certPath	证书路径
	 * @param macid		商户编号
	 * @return		返回请求后的信息
	 */
	public static String getRedInfoList(String data,String certPath,String macid){
		String result = "";
		try {
			result = executeConn(data,GETHBINFO,certPath,macid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 发送裂变红包
	 * @param data		请求参数对象
	 * @param cretPath	证书的路径
	 * @param macid	   	 商户编号
	 * @return
	 */
	public static String sendGroupRedBack(String data,String cretPath,String macid){
		String result="";
		try {
			result = executeConn(data,SENDGROUPREDPACK,cretPath,macid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}

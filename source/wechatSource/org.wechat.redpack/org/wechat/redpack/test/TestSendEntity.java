package org.wechat.redpack.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.SSLContext;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.params.CoreProtocolPNames;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.common.utils.CharsetUtils;
import org.wechat.common.utils.ConvertXMLUtils;
import org.wechat.common.utils.Signature;
import org.wechat.common.utils.XStreamFactory;
import org.wechat.redpack.request.RedpackRequest;
import org.wechat.redpack.respose.SendredpackRespose;
import org.wechat.redpack.utils.SendRedPackUtils;

import com.thoughtworks.xstream.XStream;

public class TestSendEntity {
	
	/**
	 * 请求实体测试成功
	 */
	@Test
	public void testSendEntity(){
		RedpackRequest request = sendEntity();
		String sign = Signature.getSignForObject(request,"7cfefba351c3db469ffdff3bf9d80be9");
		request.setSign(sign);
		XStream st = XStreamFactory.initSplitLine();
		st.alias("xml",RedpackRequest.class);
		String data = st.toXML(request);
		System.out.println("data-->"+data);
		try {
			String result = getSendInfo(data);
			SendredpackRespose packRespose = (SendredpackRespose) ConvertXMLUtils.getObjectFromXML(result, SendredpackRespose.class);
			System.out.println(packRespose.getErr_code());
		} catch (KeyManagementException | UnrecoverableKeyException
				| KeyStoreException | NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 测试发送红包
	 * @throws KeyStoreException 
	 * @throws IOException 
	 * @throws NoSuchAlgorithmException 
	 * @throws UnrecoverableKeyException 
	 * @throws KeyManagementException 
	 */
	private String getSendInfo(String data) throws KeyStoreException, IOException, KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException{
			String reuslt="";
		    KeyStore keyStore  = KeyStore.getInstance("PKCS12");
	        FileInputStream instream = new FileInputStream(new File("D:/apiclient_cert.p12"));
	        try {
	            keyStore.load(instream, "10012936".toCharArray());
	        }catch(Exception ex){
	        	ex.printStackTrace();
	        } finally {
	            instream.close();
	        }
	        // Trust own CA and all self-signed certs
	        SSLContext sslcontext = SSLContexts.custom()
	                .loadKeyMaterial(keyStore, "10012936".toCharArray())
	                .build();
	        // Allow TLSv1 protocol only
	        SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory( sslcontext,new String[] { "TLSv1" }, null,SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
	        CloseableHttpClient httpclient = HttpClients.custom()
	                .setSSLSocketFactory(sslsf)
	                .build();
	        try {
	            HttpPost httpPost = new HttpPost("https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack");
	            StringEntity rentity = new StringEntity(CharsetUtils.convertToUTF8(data));
	            rentity.setContentEncoding("UTF-8");
	            rentity.setContentType("application/json;charset=utf8");
	            httpPost.setEntity(rentity);
	            System.out.println("executing request" + httpPost.getRequestLine());
	            CloseableHttpResponse response = httpclient.execute(httpPost);
	            StringBuffer buffer = new StringBuffer();
	            try {
	                HttpEntity entity = response.getEntity();
	                System.out.println(response.getStatusLine());
	                if (entity != null) {
	                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(entity.getContent()));
	                    String text;
	                    while ((text = bufferedReader.readLine())!= null) {
	                        buffer.append(text+"\n");
	                    }
	                }
	                reuslt = buffer.toString();
	                EntityUtils.consume(entity);
	            } finally {
	                response.close();
	            }
	        } finally {
	            httpclient.close();
	        }
	        return reuslt;
	    }
	
	/**
	 * 获取请求参数String
	 * @return
	 */
	public RedpackRequest sendEntity(){
		RedpackRequest request = new RedpackRequest();
		request.setAct_name("test Activity"); 
		request.setClient_ip("192.168.0.1");
		request.setMch_billno("10012936201509258000000000");
		request.setMch_id("10012936");
		request.setNonce_str("1111");
		request.setRe_openid("o8ed_jv3vIC6l7Y8WQybls0xl8n0");
		request.setRemark("This is remark");
		request.setSend_name("sanyangxiyi");
		request.setSign("");
		request.setTotal_amount(100);
		request.setTotal_num(1);
		request.setWishing("zhufu");
	    request.setWxappid("wx7c50b0eb849348d3");
	    //String xmlData = ConvertXMLUtils.toXMLDataAndSplit(request);
	    return request;
	}
	
}

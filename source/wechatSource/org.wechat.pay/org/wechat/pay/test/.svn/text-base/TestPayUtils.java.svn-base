package org.wechat.pay.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.junit.Test;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.common.utils.ConvertJsonUtils;
import org.wechat.common.utils.ConvertXMLUtils;
import org.wechat.pay.request.UnifiedOrderRequest;
import org.wechat.pay.response.PayResponseResult;
import org.wechat.pay.response.UnifiedNoticeResponse;
import org.wechat.pay.utils.FormatDateUtils;
import org.wechat.pay.utils.PayUtils;
import org.wechat.pay.utils.RandomStringGenerator;

public class TestPayUtils {
	
	@Test
	public void testPayUtils(){
		String appid = "wx7c50b0eb849348d3";
		String appkey ="7cfefba351c3db469ffdff3bf9d80be9";
		UnifiedOrderRequest request = new UnifiedOrderRequest();
		request.setAppid("wx7c50b0eb849348d3");
		request.setMch_id("10012936");
		request.setDevice_info("WEB");					//可选
		request.setNonce_str("4735293714");
		request.setBody("这是测试商品描述");		
		request.setDetail("111");						//可选
		request.setAttach("这是测试api");						//可选
		request.setOut_trade_no(RandomStringGenerator.getOrderRandomId());
		request.setFee_type("CNY");				
		request.setTotal_fee("1");
		request.setSpbill_create_ip("8.8.8.8");
		request.setTime_start(FormatDateUtils.createOrderStartTime());				//可选
		request.setTime_expire("");				//可选
		request.setGoods_tag("WX");				//可选
		request.setNotify_url("http://testmall.duapp.com/payNotice");
		request.setTrade_type("JSAPI");
		request.setProduct_id("1111");			//可选	
		request.setOpenid("o8ed_jv3vIC6l7Y8WQybls0xl8n0");	
		WechatResult wechatResult = PayUtils.PaySignRequest(request, appid, appkey);
		String data = ConvertJsonUtils.toJsonString(wechatResult);
		System.out.println(data);
	}
	
	/**
	 * 测试支付工具
	 */
	@Test
	public void testPayNoticeUtils(){
		PayResponseResult result = new PayResponseResult();
		result.setReturn_code("111");
		result.setReturn_msg("msg");
		String data = PayUtils.payNoticData(result);
		System.out.println(data);
	}
	
	@Test
	public void testFileInputStream(){
		File file = new File("D:\\test.txt");
		try {
			FileInputStream input = new FileInputStream(file);
			String data = ConvertXMLUtils.InputStreamToGBK(input);
			WechatResult result = PayUtils.wechatPayNotice(data);
			/*UnifiedNoticeResponse response = new UnifiedNoticeResponse();
			WechatResult result = ConvertXMLUtils.InputStreamToJavaObject(input,response,ConvertXMLUtils.CHARSET_GBK);*/
			if(result.isSuccess()){
				UnifiedNoticeResponse	response = (UnifiedNoticeResponse) result.getObj();
				System.out.println(response.getAppid());
			}else{
				System.out.println("object is null!");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

package org.wechat.redpack.conn;

import java.io.IOException;

/**
 * 发放代金券
 * @author Andy
 *
 */
public class CouponConn {
	
	/**
	 * 发送代金卷的请求path
	 */
	private static final String COUPONPATH="https://api.mch.weixin.qq.com/mmpaymkttransfers/send_coupon";
	/**
	 * 获取代金卷请求path
	 */
	private static final String QUERCOUPON="https://api.mch.weixin.qq.com/mmpaymkttransfers/query_coupon_stock";
	
	/**
	 * 发送代金卷
	 * @param data		请求对象xml数据包
	 * @param apikey	apikey
	 * @param certPath	证书路径
	 * @param macid		商户编号
	 * @return			请求成功后的返回xml数据包
	 */
	public static String sendCoupon(String data,String apikey,String certPath,String macid){
		String result = "";
		try {
			result = RedPackConn.executeConn(data, COUPONPATH, certPath, macid);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 获取代金卷的方法
	 * (该方法不需要加密)
	 * @param data		请求对象xml数据包
	 * @param apikey
	 * @param certPath
	 * @param macid
	 * @return
	 */
	public static String getCouponStock(String data){
		String result="";
		try{
			result = RedPackConn.executeConn(data, QUERCOUPON);
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return result;
	}
}

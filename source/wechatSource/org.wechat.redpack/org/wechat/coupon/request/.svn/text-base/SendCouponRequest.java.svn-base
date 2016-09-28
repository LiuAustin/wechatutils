package org.wechat.coupon.request;

import org.wechat.pay.annotation.NotSign;

/**
 * 发送代金卷请求对象
 * @author Andy
 */
public class SendCouponRequest extends QueryCouponStock implements java.io.Serializable{

	@NotSign
	private static final long serialVersionUID = 1L;
	private int openid_countl;			//openid 记录数
	private String partner_trade_no;	//商户单据号
	private String openid;				//用户openid
	
	public int getOpenid_countl() {
		return openid_countl;
	}
	public void setOpenid_countl(int openid_countl) {
		this.openid_countl = openid_countl;
	}
	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}
	public String getOpenid() {
		return openid;
	}
	public void setOpenid(String openid) {
		this.openid = openid;
	}
}

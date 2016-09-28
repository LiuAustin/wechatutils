package org.wechat.redpack.request;

import org.wechat.pay.annotation.NotSign;

/**
 * 创建现金红包的请求实体
 * 
 * @author Andy
 * 
 */
public class RedpackRequest extends BaseRedPackRequest implements
		java.io.Serializable {
	
	@NotSign
	private static final long serialVersionUID = 1L;
	private String wxappid;			//公众账号appid
	private String send_name; // 商户名称
	private String re_openid; // 用户openid
	private int total_amount; // 付款金额
	private int total_num; // 红包发送总人数
	private String wishing; // 红包祝福语
	private String client_ip; // Ip地址
	private String act_name; // 活动名称
	private String remark; // 备注

	
	public String getWxappid() {
		return wxappid;
	}

	public void setWxappid(String wxappid) {
		this.wxappid = wxappid;
	}

	public String getSend_name() {
		return send_name;
	}

	public void setSend_name(String send_name) {
		this.send_name = send_name;
	}

	public String getRe_openid() {
		return re_openid;
	}

	public void setRe_openid(String re_openid) {
		this.re_openid = re_openid;
	}

	public int getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(int total_amount) {
		this.total_amount = total_amount;
	}

	public int getTotal_num() {
		return total_num;
	}

	public void setTotal_num(int total_num) {
		this.total_num = total_num;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getClient_ip() {
		return client_ip;
	}

	public void setClient_ip(String client_ip) {
		this.client_ip = client_ip;
	}

	public String getAct_name() {
		return act_name;
	}

	public void setAct_name(String act_name) {
		this.act_name = act_name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}

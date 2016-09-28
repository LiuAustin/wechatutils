package org.wechat.redpack.request;

import org.wechat.pay.annotation.NotSign;

/**
 * 
 * 查询现金红包/裂变红包接口
 * @author Andy
 * 
 */
public class GethbinfoRequest extends BaseRedPackRequest implements
		java.io.Serializable {

	@NotSign
	private static final long serialVersionUID = 1L;			//不参与签名
	private String appid;		//微信分配的公众账号ID
	private String bill_type; // 订单类型

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getBill_type() {
		return bill_type;
	}

	public void setBill_type(String bill_type) {
		this.bill_type = bill_type;
	}
}

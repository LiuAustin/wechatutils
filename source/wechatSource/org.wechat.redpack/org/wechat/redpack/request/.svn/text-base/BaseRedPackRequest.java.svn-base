package org.wechat.redpack.request;

import org.wechat.common.entity.results.BaseXmlObj;
import org.wechat.pay.annotation.NotSign;

/**
 * 发送红包中的请求基类   (其中包括 现金红包/现金红包查询     裂变红包创建/裂变红包查询)
 * @author Andy
 */
public class BaseRedPackRequest extends BaseXmlObj implements java.io.Serializable{
	@NotSign
	private static final long serialVersionUID = 1L;
	private String nonce_str;		//随机字符串
	private String sign;			//签名
	private String mch_billno;		//商户订单号
	private String mch_id;			//商户号

	
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getMch_billno() {
		return mch_billno;
	}
	public void setMch_billno(String mch_billno) {
		this.mch_billno = mch_billno;
	}
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
}
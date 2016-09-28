package org.wechat.redpack.request;

import org.wechat.pay.annotation.NotSign;

/**
 * 创建裂变红包请求实体
 * 
 * @author Andy
 * 
 */
public class GroupredpackRequest extends BaseRedPackRequest implements
		java.io.Serializable {

	@NotSign
	private static final long serialVersionUID = 1L;
	private String send_name; // 商户名称
	private String re_openid; // 用户openid
	private int total_amount; // 总金额             金额必须要大于3
	private int total_num; // 红包发送总人数	数量为最少为3个
	private String amt_type = "ALL_RAND"; // 红包金额设置方 （默认由微信随机计算）
	private String wishing; // 红包祝福语
	private String act_name; // 活动名称
	private String remark; // 备注
	private String wxappid; // 微信appid

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

	public String getAmt_type() {
		return amt_type;
	}

	public void setAmt_type(String amt_type) {
		this.amt_type = amt_type;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
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

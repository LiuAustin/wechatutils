package org.wechat.redpack.respose;

import java.util.List;

/**
 * 查询红包的返回的对象实体
 * 
 * @author Andy
 * 
 */
public class GethbinfoRespose extends BaseRedPackRespose implements
		java.io.Serializable {

	private static final long serialVersionUID = 1L;
	private String mch_billno; // 商户订单号
	private String mch_id; // 商户号
	private String detail_id; // 红包单号
	private String status; // 红包状态
	private String send_type; // 发送类型
	private String hb_type; // 红包类型
	private int Total_num; // 红包个数
	private int Total_amount; // 红包金额
	private String reason; // 余额不足
	private String Send_time; // 红包发送时间
	private String Refund_time; // 红包退款时间
	private int Refund_amount; // 红包退款金额
	private String wishing; // 祝福语
	private String Remark; // 活动描述
	private String Act_name; // 活动名称
	private List<HbListItem> hblist; // 裂变红包领取列表
	private String openid; // 用户openid
	private int amount; // 金额
	private String rcv_time; // 接收时间

	public GethbinfoRespose() {
		super();
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

	public String getDetail_id() {
		return detail_id;
	}

	public void setDetail_id(String detail_id) {
		this.detail_id = detail_id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSend_type() {
		return send_type;
	}

	public void setSend_type(String send_type) {
		this.send_type = send_type;
	}

	public String getHb_type() {
		return hb_type;
	}

	public void setHb_type(String hb_type) {
		this.hb_type = hb_type;
	}

	public int getTotal_num() {
		return Total_num;
	}

	public void setTotal_num(int total_num) {
		Total_num = total_num;
	}

	public int getTotal_amount() {
		return Total_amount;
	}

	public void setTotal_amount(int total_amount) {
		Total_amount = total_amount;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSend_time() {
		return Send_time;
	}

	public void setSend_time(String send_time) {
		Send_time = send_time;
	}

	public String getRefund_time() {
		return Refund_time;
	}

	public void setRefund_time(String refund_time) {
		Refund_time = refund_time;
	}

	public int getRefund_amount() {
		return Refund_amount;
	}

	public void setRefund_amount(int refund_amount) {
		Refund_amount = refund_amount;
	}

	public String getWishing() {
		return wishing;
	}

	public void setWishing(String wishing) {
		this.wishing = wishing;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getAct_name() {
		return Act_name;
	}

	public void setAct_name(String act_name) {
		Act_name = act_name;
	}

	public List<HbListItem> getHblist() {
		return hblist;
	}

	public void setHblist(List<HbListItem> hblist) {
		this.hblist = hblist;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getRcv_time() {
		return rcv_time;
	}

	public void setRcv_time(String rcv_time) {
		this.rcv_time = rcv_time;
	}

}

package org.wechat.redpack.respose;

/**
 * 红包列表选项
 * 
 * @author Andy
 * 
 */
public class HbListItem implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private String openid; // 用户openid
	private String status; // 状态
	private int amount; // 金额
	private String rcv_time; // 接收时间

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

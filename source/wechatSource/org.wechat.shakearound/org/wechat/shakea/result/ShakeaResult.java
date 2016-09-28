package org.wechat.shakea.result;

/**
 * 摇一摇返回结果
 * 
 * @author Andy
 * 
 */
public class ShakeaResult implements java.io.Serializable{

	private Object data; // 错误数据
	private int errcode; // 错误码
	private String errmsg; // 错误消息

	public ShakeaResult() {
		super();
	}

	public ShakeaResult(Object data, int errcode, String errmsg) {
		super();
		this.data = data;
		this.errcode = errcode;
		this.errmsg = errmsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}

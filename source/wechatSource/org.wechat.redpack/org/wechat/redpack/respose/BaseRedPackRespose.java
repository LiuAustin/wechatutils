package org.wechat.redpack.respose;

import org.wechat.common.entity.results.BaseXmlObj;

/**
 * 现金红包/裂变红包返回结果基类
 * @author Andy
 *
 */
public class BaseRedPackRespose extends BaseXmlObj implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private String return_code;	//返回状态吗
	private String return_msg;	//返回信息
	//以下字段在return_code为SUCCESS的时候返回
	private String sign;		  //签名   
	private String result_code;	 //业务结果
	private String err_code;	 //错误代码
	private String err_code_des; //错误代码描述
	
	public String getReturn_code() {
		return return_code;
	}
	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}
	public String getReturn_msg() {
		return return_msg;
	}
	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getResult_code() {
		return result_code;
	}
	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}
	public String getErr_code() {
		return err_code;
	}
	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}
	public String getErr_code_des() {
		return err_code_des;
	}
	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}
}

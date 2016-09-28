package org.wechat.shakea.result;

/**
 * 申请结果参数
 * @author Andy
 * 
 */
public class Auditstatus implements java.io.Serializable {
	private long apply_time; // 时间戳
	private String audit_status; // 审核状态 0：审核未通过、1：审核中、2：审核已通过；审核会在三个工作日内完成
	private String audit_comment; // 审核备注
	private long audit_time; // 审核确定时间戳

	public Auditstatus() {
		super();
	}

	public Auditstatus(long apply_time, String audit_status,
			String audit_comment, long audit_time) {
		super();
		this.apply_time = apply_time;
		this.audit_status = audit_status;
		this.audit_comment = audit_comment;
		this.audit_time = audit_time;
	}

	public long getApply_time() {
		return apply_time;
	}

	public void setApply_time(long apply_time) {
		this.apply_time = apply_time;
	}

	public String getAudit_status() {
		return audit_status;
	}

	public void setAudit_status(String audit_status) {
		this.audit_status = audit_status;
	}

	public String getAudit_comment() {
		return audit_comment;
	}

	public void setAudit_comment(String audit_comment) {
		this.audit_comment = audit_comment;
	}

	public long getAudit_time() {
		return audit_time;
	}

	public void setAudit_time(long audit_time) {
		this.audit_time = audit_time;
	}
}

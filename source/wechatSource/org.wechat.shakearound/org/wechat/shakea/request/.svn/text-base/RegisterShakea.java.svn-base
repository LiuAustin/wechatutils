package org.wechat.shakea.request;

/**
 * 申请摇一摇
 * 
 * @author Andy
 * 
 */
public class RegisterShakea implements java.io.Serializable {
	private String name; // 联系人姓名
	private String phone_number; // 联系人电话
	private String email; // 联系人邮箱
	private String industry_id; // 平台定义的行业代号
	private String[] qualification_cert_urls; // 相关资质文件的图片url，图片需先上传至微信侧服务器，用“素材管理-上传图片素材”接口上传图片，返回的图片URL再配置在此处；
	private String apply_reason; // 申请理由

	public RegisterShakea() {
		super();
	}

	public RegisterShakea(String name, String phone_number, String email,
			String industry_id, String[] qualification_cert_urls,
			String apply_reason) {
		super();
		this.name = name;
		this.phone_number = phone_number;
		this.email = email;
		this.industry_id = industry_id;
		this.qualification_cert_urls = qualification_cert_urls;
		this.apply_reason = apply_reason;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndustry_id() {
		return industry_id;
	}

	public void setIndustry_id(String industry_id) {
		this.industry_id = industry_id;
	}

	public String[] getQualification_cert_urls() {
		return qualification_cert_urls;
	}

	public void setQualification_cert_urls(String[] qualification_cert_urls) {
		this.qualification_cert_urls = qualification_cert_urls;
	}

	public String getApply_reason() {
		return apply_reason;
	}

	public void setApply_reason(String apply_reason) {
		this.apply_reason = apply_reason;
	}

}

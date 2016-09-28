package org.wechat.shakea.conn;

import java.util.TreeMap;

import org.wechat.common.conn.Connection;
import org.wechat.common.utils.ConvertJsonUtils;
import org.wechat.shakea.request.RegisterShakea;
import org.wechat.shakea.result.Auditstatus;
import org.wechat.shakea.result.ShakeaResult;

import com.alibaba.fastjson.JSONObject;

/**
 * 摇一摇接口
 * (还有待完善)
 * @author Andy
 *
 */
public class ShakeConn {
	//申请摇一摇
	private static final String SHAKERECOND="https://api.weixin.qq.com/shakearound/account/register";
	//获取申请摇一摇审核状态
	private static final String AUDITSTATUS="https://api.weixin.qq.com/shakearound/account/auditstatus";
	/**
	 * 申请摇一摇(未测试)
	 * @param request	申请摇一摇请求参数
	 * @param access_token　授权token
	 * @return
	 */
	public static String ShakeRegister(RegisterShakea request,String access_token){
		Connection connection = new Connection();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",access_token);
		String postData = ConvertJsonUtils.toJsonString(request);
		String result = connection.HttpsDefaultExecute("POST", SHAKERECOND, params, postData);
		return result;
	}
	
	/**
	 * 申请摇一摇 (未测试)
	 * @param request 	申请摇一摇请求参数
	 * @param access_token	授权token
	 * @return	返回结果集
	 */
	public static ShakeaResult ShakeRegisterResult(RegisterShakea request,String access_token){
		String data = ShakeRegister(request,access_token);
		ShakeaResult result = ConvertJsonUtils.jsonToJavaObject(data,ShakeaResult.class);
		return result;
	}
	
	/**
	 * 获取审核状态(未测试)
	 * @param access_token	授权token
	 * @return  ShakeaResult.getErrcode==0时,ShakeaResult.obj=Auditstatus对象
	 */
	public static ShakeaResult AuditstatusMethod(String access_token){
		Connection conn = new Connection();
		TreeMap<String,String> params = new TreeMap<String,String>();
		params.put("access_token",access_token);
		String data = conn.HttpsDefaultExecute("GET", AUDITSTATUS,params,"");
		ShakeaResult result = ConvertJsonUtils.jsonToJavaObject(data,ShakeaResult.class);
		if(result.getErrcode()==0){			//判断获取成功
			String dataItem = JSONObject.parseObject(data).getString("data");
			Auditstatus status = ConvertJsonUtils.jsonToJavaObject(dataItem,Auditstatus.class);
			result.setData(status);
		}
		return result;
	}
}

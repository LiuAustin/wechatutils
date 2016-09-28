package org.wechat.redpack.utils;

import org.apache.log4j.Logger;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.common.utils.ConvertXMLUtils;
import org.wechat.common.utils.Signature;
import org.wechat.common.utils.XStreamFactory;
import org.wechat.redpack.conn.RedPackConn;
import org.wechat.redpack.request.BaseRedPackRequest;
import org.wechat.redpack.request.GethbinfoRequest;
import org.wechat.redpack.request.GroupredpackRequest;
import org.wechat.redpack.request.RedpackRequest;
import org.wechat.redpack.respose.GethbinfoRespose;
import org.wechat.redpack.respose.HbListItem;
import org.wechat.redpack.respose.SendredpackRespose;

import com.thoughtworks.xstream.XStream;

/**
 * 发送红包的工具类
 * @author Andy
 *
 */
public class SendRedPackUtils {
	public static final String SUCCESS="SUCCESS";		//成功标识
	public static final String FAIL="FAIL";				//失败标识
	private static Logger log = Logger.getLogger(SendRedPackUtils.class);
	
	/**
	 * 发送红包方法
	 * @param request	发送红包的请求对象实体
	 * @param apikey	商户中的apikey
	 * @param certPath	api证书路径
	 * @param macid		商户号
	 * @return
	 */
	private String sendRedUtils(BaseRedPackRequest request,String apikey,String certPath,String macid){
		String result="";
		String sign = Signature.getSignForObject(request,apikey);
		request.setSign(sign);
		XStream st = XStreamFactory.initSplitLine();
		st.alias("xml",RedpackRequest.class);
		String data = st.toXML(request);
		result =RedPackConn.sendRedInfo(data, certPath, macid);
		log.info("sendRedUtils:["+result+"]");
		return result;
	}
	
	/**
	 * 发送红包(简化结果集后的方法)
	 * @param request	发送红包的请求对象
	 * @param apikey	apikey
	 * @param certPath	正式路径
	 * @param macId		商户号
	 * @return	result.isSusccess==true 则表示为发送成功，否则为发送失败， result.msg 为提示信息,result.obj为 request对象
	 */
	public WechatResult sendRed(RedpackRequest request,String apikey,String certPath,String macId){
		String  data =  sendRedUtils(request,apikey,certPath,macId);
		WechatResult result = convertResult(data,request);
		return result;
	}
	
	/**
	 * 将返回值封装成WechatResult 
	 * (应用于现金红包和裂变红包)
	 * @param respose	请求成功后返回的xml格式的数据包
	 * @param request	请求对象 (方便追踪)
	 * @return	result.isSusccess==true 则表示为发送成功，否则为发送失败， result.msg 为提示信息,result.obj为 request对象
	 */
	private WechatResult convertResult(String data,BaseRedPackRequest request){
		WechatResult result = new WechatResult();
		SendredpackRespose respose = (SendredpackRespose) ConvertXMLUtils.getObjectFromXML(data, SendredpackRespose.class);
		if(respose.getReturn_code().equalsIgnoreCase(SUCCESS)&&respose.getResult_code().equalsIgnoreCase(SUCCESS)){			//表示成功
			result.setSuccess(true);
		}
		result.setMsg(respose.getReturn_msg());
		result.setObj(request);
		return result;
	}
	
	/**
	 * 发送裂变红包
	 * @param request	请求参数对象
	 * @param apiKey	api密匙(注意此处是商户号中的密匙，并不是appkey)
	 * @param certPath	证书的路径
	 * @param macId		商户号
	 * @return  result.isSusccess==true 则表示为发送成功，否则为发送失败， result.msg 为提示信息,result.obj为 request对象
	 */
	public WechatResult sendGroupRedPack(GroupredpackRequest request,String apiKey,String certPath,String macId){
		String sign = Signature.getSignForObject(request,apiKey);
		request.setSign(sign);
		XStream xstream = XStreamFactory.initSplitLine();
		xstream.alias("xml",GroupredpackRequest.class);
		String data = xstream.toXML(request);
		String resultData = RedPackConn.sendGroupRedBack(data, certPath, macId);
		WechatResult result  = convertResult(resultData,request);
		return result;
	}
	
	/**
	 * 获取红包信息
	 * @param request	获取红包信息请求对象实体
	 * @param certPath	证书所在路径
	 * @param macId		商户号
	 * @return
	 */
	public WechatResult getHbInfo(GethbinfoRequest request,String certPath,String macId,String apiKey){
		WechatResult result = new WechatResult();
		String sign = Signature.getSignForObject(request,apiKey);
		request.setSign(sign);
		XStream st = XStreamFactory.initSplitLine();
		st.alias("xml",GethbinfoRequest.class);
		String data = st.toXML(request);
		String strData =RedPackConn.getRedInfoList(data, certPath,macId);
		System.out.println("data-->"+strData);
		GethbinfoRespose respose = (GethbinfoRespose) ConvertXMLUtils.getObjectFromCollectionXML(strData,GethbinfoRespose.class,HbListItem.class);
		System.out.println(respose.getAmount());
		log.info(strData);	
		return result;
	}
}

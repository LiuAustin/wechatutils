package org.wechat.user.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.wechat.common.entity.results.WechatResult;
import org.wechat.user.conn.UserConnection;
import org.wechat.user.entity.UserOpenListInfo;
import org.wechat.user.entity.WeixinUser;
import org.wechat.user.utils.UserConvertUtils;

/**
 * 测试工具类
 * @author Andy
 *
 */
public class TestUserConvertUtils {
	private static String accessToken;
	
	@Before
	public void init(){
		accessToken="3OJyILY3WJZHQI-2_jT3rszqQZId2WyFZi18AHdulq8Xlk9EsHxc6jTtZFQrN4K4OeAslDwfTUPGwKGGS4kdkb_DW3kX2T1K0NPgLlr4jdw";
	}
	/**
	 * 测试工具类
	 */
	@Test
	public void testJsonUtils(){
		String data = UserConnection.getUserOpenList(accessToken,"");
		WechatResult result = UserConvertUtils.getOpenIdList(data);
		if(result.isSuccess()){
			UserOpenListInfo listinfo = (UserOpenListInfo) result.getObj();
			System.out.println(listinfo.getCount());
			for(String str:listinfo.getOpenid()){
				System.out.println(str);
			}
		}
	}
	
	/**
	 * 获取微信用户信息
	 */
	@Test
	public void testGetWeixinUserList(){
		long startTime =System.currentTimeMillis();
		List<WeixinUser> list = UserConnection.batchgetUserList(accessToken,"");
		System.out.println(list.size());
		long stopTime =System.currentTimeMillis();
		System.out.println("执行时间---->"+(stopTime-startTime)/1000+"秒");
	}
}

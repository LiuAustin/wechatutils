package org.wechat.common.test;

import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * 测试json格式的字符串
 * @author Andy
 *
 */
public class TestJsonString {

	@Test
	public void testJsonData(){
		String[] array={"openid01","openid02","openid03","openid03","openid02"};
		String jsonData = JSONObject.toJSONString(array);
		System.out.println(jsonData);
		List<String> list  = JSONArray.parseArray(jsonData, String.class);
		System.out.println(list.size());
	}
}

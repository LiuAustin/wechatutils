package org.wechat.user.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * 测试集合
 * @author Andy
 *
 */
public class TestList {
	
	
	@Test
	public void testList(){
		List<String> list = new ArrayList<String>();
		for(int i = 0;i<100;i++){
			list.add("list---->"+i);
		}
		List<String> newList = list.subList(0,100);
		System.out.println(newList.size());
	}
}	

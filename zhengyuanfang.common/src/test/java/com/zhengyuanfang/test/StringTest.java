package com.zhengyuanfang.test;

import org.junit.Test;

import com.zhengyuanfang.util.StringUtil;

public class StringTest {
	@Test
	public void name() {
		String str = StringUtil.toHtml("9月5日一大早，又有了新情况。\n\r上午9点多，传出中美经贸高级别磋商牵头人通话的消息。\r9月5日上午，中共中央政治局委员、国务院副总理、中美全面经济对话中方牵头人刘鹤应约与美国贸易代表莱特希泽、财政部长姆努钦通话。\n");
		System.out.println(str);
	}
}

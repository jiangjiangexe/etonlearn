/**
 *
 */
package com.jiang.etonlearn.cache;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.interceptor.KeyGenerator;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @author Luojy
 */
public class MyKeyGenerator implements KeyGenerator {
	private static final Logger log = LoggerFactory.getLogger(MyKeyGenerator.class);

	 private static final String POUND_STR = "#";

	@Override
	public Object generate(Object target, Method method, Object... params) {
		String key = StringUtils.join(POUND_STR, method, POUND_STR, Arrays.toString(params));
		log.debug("ehcache使用預設自設的key==>" + key + ",hashCode:" + key.hashCode());
		return key.hashCode();
	}
}

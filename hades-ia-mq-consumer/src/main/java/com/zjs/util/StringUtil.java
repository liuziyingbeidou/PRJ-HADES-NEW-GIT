package com.zjs.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.util.StringUtils;


/**
 * 字符串工具类，继续自 org.apache.commons.lang.StringUtils
 * <P>
 * <h1>API : <font
 * color="#FF0000">http://commons.apache.org/proper/commons-lang/
 * javadocs/api-release/index.html</font></h1>
 * <p>
 * http://blog.csdn.net/chinarenzhou/article/details/4090499
 * 
 * @author Jiangjinlong
 * @version 2013-6-8 下午5:04:12
 */
public class StringUtil extends StringUtils {
	private static final Log log = LogFactory.getLog(StringUtil.class);
	private static Properties dbconfig;

	public static String getDBUserName() {
		if (dbconfig == null) {
			try {
				dbconfig = PropertiesLoaderUtils.loadAllProperties("important.properties");
			} catch (IOException e) {
				log.error("important.properties初始化失败" + e.toString(), e);
				e.printStackTrace();
			}
		}
		return dbconfig.getProperty("bosDataSource.db.name") == null ? "" : dbconfig.getProperty("bosDataSource.db.name").toString() + ".";
	}

	/**
	 * 获取本地ip地址 Title: getLocalIP
	 * 
	 * Description:
	 * 
	 * @return
	 */
	public static String getLocalIP() {
		try {
			return InetAddress.getLocalHost().getHostAddress();
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 获取32位随机码 Title: getUUID
	 * 
	 * Description:
	 * 
	 * @return
	 */
	public static String getUUID() {
		try {
			return (UUID.randomUUID().toString().replaceAll("-", "").toUpperCase());
		} catch (Exception e) {
			return "";
		}
	}

	/**
	 * 取摸的条件 Title: getCondition
	 *
	 * Description:将服务器实例列表转为以逗号间隔的字符串
	 * 
	 * @param queueList
	 * @return
	 */
	public static StringBuffer getCondition(List<?> queueList) {
		StringBuffer condition = new StringBuffer();
		for (int i = 0; i < queueList.size(); i++) {
			if (i > 0) {
				condition.append(",");
			}
			condition.append(queueList.get(i));
		}
		return condition;
	}

	/**
	 * 判断一个或多个对象是否为非空
	 * 
	 * @param values
	 *            可变参数，要判断的一个或多个对象
	 * @return 只有要判断的一个或多个对象都不为空则返回true,否则返回false
	 */
	public static boolean isNotNull(Object... values) {
		if (!isNotNullAndNotEmpty(values)) {
			return false;
		}
		for (Object value : values) {
			boolean flag = true;
			if (value instanceof Object[]) {
				flag = isNotNullAndNotEmpty((Object[]) value);
			} else if (value instanceof Collection<?>) {
				flag = isNotNullAndNotEmpty((Collection<?>) value);
			} else {
				flag = (null != value);
			}
			if (!flag) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 判断对象数组是否为空并且数量大于0
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndNotEmpty(Object[] value) {
		boolean bl = false;
		if (null != value && 0 < value.length) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 判断对象集合（List,Set）是否为空并且数量大于0
	 * 
	 * @param value
	 * @return
	 */
	public static Boolean isNotNullAndNotEmpty(Collection<?> value) {
		boolean bl = false;
		if (null != value && 0 < value.size()) {
			bl = true;
		}
		return bl;
	}

	/**
	 * 
	 * Title: splitList
	 *
	 * Description:拆分list，按500条拆分
	 * 
	 * @param list
	 * @return
	 */
	public static List<List<String>> splitList(List<String> list) {
		List<List<String>> lists = new ArrayList<List<String>>();
		List<String> subList = new ArrayList<String>();
		int size = list.size();
		int sum = 500;
		int count = size / sum;
		int yu = size % sum;
		if (count == 0) {
			lists.add(list);
		} else {
			if (size % sum != 0) {
				count++;
			}
			for (int i = 0; i < count; i++) {
				if (sum * (i + 1) <= size) {
					subList = list.subList(sum * i, sum * (i + 1));
				} else {
					subList = list.subList(sum * i, sum * (i) + yu);
				}
				lists.add(subList);
			}
		}
		return lists;

	}

	/**
	 * 判断字符串是否为空或长度为0或由空格组成
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isBlank(String str) {
		return (str == null || "null".equals(str) || str.trim().length() <= 0);
	}

	/**
	 * 判断两个字符串内容是否相同
	 * 
	 * @param actualStr
	 *            真实字符
	 * @param expectedStr
	 *            期望字符
	 */
	public static boolean isEquals(String actualStr, String expectedStr) {
		return (actualStr == null ? expectedStr == null : actualStr.equals(expectedStr));
	}

	/**
	 * 将null转成空字符串""
	 * 
	 * @param str
	 */
	public static String nullToEmpty(String str) {
		return (str == null || "null".equals(str) ? "" : str);
	}
	/**
	 * 将null转成空字符串"0"
	 * 
	 * @param str
	 */
	public static String nullToZero(String str) {
		return (str == null || "null".equals(str) ? "0" : str);
	}

	/**
	 * 首字母大写
	 * 
	 * @param str
	 * @return
	 */
	public static String capitalizeFirstLetter(String str) {
		if (isBlank(str)) {
			return str;
		}
		char c = str.charAt(0);
		return (!Character.isLetter(c) || Character.isUpperCase(c)) ? str : new StringBuilder(str.length()).append(Character.toUpperCase(c))
				.append(str.substring(1)).toString();
	}

	/**
	 * 将字符串转成utf-8编码
	 * 
	 * @param str
	 * @return
	 */
	public static String utf8Encode(String str) {
		if (!isEmpty(str) && str.getBytes().length != str.length()) {
			try {
				return URLEncoder.encode(str, "UTF-8");
			} catch (UnsupportedEncodingException e) {
				throw new RuntimeException("UnsupportedEncodingException occurred. ", e);
			}
		}
		return str;
	}

	/**
	 * 字符串纯数字判断
	 * 
	 * @param str
	 *            字符串
	 * @return
	 */
	public static boolean isNumeric(String str) {
		Pattern pattern = Pattern.compile("[0-9]*");
		return pattern.matcher(str).matches();
	}

	/**
	 * 将字符串里面的 小写字母转成大写的
	 */
	public static String toUpString(String str) {
		StringBuffer sb = new StringBuffer();
		if (str != null) {
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (Character.isLowerCase(c)) {
					sb.append(Character.toUpperCase(c));
				} else {
					sb.append(c);
				}
			}
		}
		return sb.toString();
	}

	/** 格式化IP地址 */
	public static String intToIp(int ip) {
		return (ip & 0xFF) + "." + ((ip >> 8) & 0xFF) + "." + ((ip >> 16) & 0xFF) + "." + ((ip >> 24) & 0xFF);
	}

	/**
	 * 传入Object对象自动转为String
	 * 
	 * @param obj
	 * @return
	 */
	public static String objNullToEmpty(Object obj) {
		return (obj == null || "null".equals(obj) ? "" : obj.toString());
	}

	/**
	 * 
	 * @description 获取一段字符串的字符个数（包含中英文，一个中文算2个字符）
	 * 
	 * @param content
	 * 
	 * @return
	 */

	public static int getCharacterNum(final String content) {

		if (null == content || "".equals(content)) {

			return 0;

		} else {

			return (content.length() + getChineseNum(content));

		}

	}

	/**
	 * 
	 * @description 返回字符串里中文字或者全角字符的个数
	 * 
	 * @param s
	 * 
	 * @return
	 */

	public static int getChineseNum(String s) {

		int num = 0;

		char[] myChar = s.toCharArray();

		for (int i = 0; i < myChar.length; i++) {

			if ((char) (byte) myChar[i] != myChar[i]) {

				num++;

			}

		}

		return num;

	}

	/**
	 * 是否是纯数字
	 * 
	 * @param s
	 * @return
	 */
	public static boolean btone(String s) {
		Pattern pattern = Pattern.compile("[0-9]{1,}");
		Matcher matcher = pattern.matcher((CharSequence) s);
		return matcher.matches();
	}

	/**
	 * 去除String字符串包含的空格
	 * 
	 * @param s
	 * @return
	 */
	public static String replaceSpace(String s) {
		return s.replaceAll(" ", "").trim();
	}

	/**
	 * 
	 * Title: splitList
	 *
	 * Description:拆分list，按100条拆分
	 * 
	 * @param <T>
	 * 
	 * @param list
	 * @return
	 */
	public static <T> List<List<T>> separateList(List<T> list) {
		List<List<T>> lists = new ArrayList<List<T>>();
		List<T> subList;
		int size = list.size();
		int sum = 100;
		int count = size / sum;
		int yu = size % sum;
		if (count == 0) {
			lists.add(list);
		} else {
			if (size % sum != 0) {
				count++;
			}
			for (int i = 0; i < count; i++) {
				if (sum * (i + 1) <= size) {
					subList = list.subList(sum * i, sum * (i + 1));
				} else {
					subList = list.subList(sum * i, sum * (i) + yu);
				}
				lists.add(subList);
			}
		}
		return lists;

	}

}

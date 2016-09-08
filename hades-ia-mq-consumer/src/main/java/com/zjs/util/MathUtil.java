package com.zjs.util;

import java.math.BigDecimal;
import java.util.Random;

/**
 * 浮点数运算工具类
 * @author 杜倬
 * @version 
 */
public class MathUtil {
	// 默认除法运算精度
	private static final int DEF_DIV_SCALE = 8;

	/**
	 * 加法
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
		UFDouble b1 = new UFDouble(v1);
		UFDouble b2 = new UFDouble(v2);
		return b1.add(b2).toBigDecimal();
	}

	/**
	 * 提供精确的加法运算。
	 * 
	 * @param v1
	 *            被加数
	 * @param v2
	 *            加数
	 * @return 两个参数的和
	 */
	public static BigDecimal add(double v1, double v2) {
		UFDouble b1 = new UFDouble(v1);
		UFDouble b2 = new UFDouble(v2);
		return b1.add(b2).toBigDecimal();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		UFDouble b1 = new UFDouble(v1);
		UFDouble b2 = new UFDouble(v2);
		return b1.sub(b2).toBigDecimal();
	}

	/**
	 * 提供精确的减法运算。
	 * 
	 * @param v1
	 *            被减数
	 * @param v2
	 *            减数
	 * @return 两个参数的差
	 */
	public static BigDecimal sub(double v1, double v2) {
		UFDouble b1 = new UFDouble(v1);
		UFDouble b2 = new UFDouble(v2);
		return b1.sub(b2).toBigDecimal();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
		UFDouble b1 = new UFDouble(v1);
		UFDouble b2 = new UFDouble(v2);
		return b1.multiply(b2).toBigDecimal();
	}

	/**
	 * 提供精确的乘法运算。
	 * 
	 * @param v1
	 *            被乘数
	 * @param v2
	 *            乘数
	 * @return 两个参数的积
	 */
	public static BigDecimal mul(double v1, double v2) {
		UFDouble b1 = new UFDouble(v1);
		UFDouble b2 = new UFDouble(v2);
		return b1.multiply(b2).toBigDecimal();
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static BigDecimal div(double v1, double v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算，当发生除不尽的情况时，精确到 小数点以后10位，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @return 两个参数的商
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2) {
		return div(v1, v2, DEF_DIV_SCALE);
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		UFDouble b1 = new UFDouble(v1);
		UFDouble b2 = new UFDouble(v2);
		return b1.div(b2, scale, UFDouble.ROUND_HALF_UP).toBigDecimal();
	}

	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static BigDecimal div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("The scale must be a positive integer or zero");
		}
		UFDouble b1 = new UFDouble(v1);
		UFDouble b2 = new UFDouble(v2);
		return b1.div(b2, scale, UFDouble.ROUND_HALF_UP).toBigDecimal();
	}

	/**
	 * 当传入对象为null时转换为0
	 * @param v
	 * @return
	 */
	public static BigDecimal getBigDecimalValueWhenNullisZero(BigDecimal v) {
		if (v == null)
			return new BigDecimal(0);
		return v;
	}

	/**
	 * 当传入对象为null时转换为0
	 * @param v
	 * @return
	 */
	public static BigDecimal getBigDecimalValue4DoubleWhenNullisZero(Double v) {
		if (v == null)
			return new BigDecimal(0);

		return new BigDecimal(v).setScale(DEF_DIV_SCALE, UFDouble.ROUND_HALF_UP);
	}

	/**
	 * 当传入对象为null时转换为0
	 * @param v
	 * @return
	 */
	public static Double getDoubleValueWhenNullisZero(BigDecimal v) {
		if (v == null)
			return new Double(0);
		return v.doubleValue();
	}

	/**
	 * 当传入对象为null时转换为0
	 * @param v
	 * @return
	 */
	public static Short getShortValueWhenNullisZero(BigDecimal v) {
		if (v == null)
			return 0;
		return v.shortValue();
	}

	/**
	 * 当传入对象为null时转换为0
	 * @param v
	 * @return
	 */
	public static Short getShortValueWhenNullisZero(Integer v) {
		if (v == null)
			return 0;
		return v.shortValue();
	}

	/**
	 * <p>Title: random<／p>
	 * <p>Description:获取count位随机数 <／p>
	 * @param count
	 * @return
	 */
	public static String random(int count) {
		StringBuffer sb = new StringBuffer();
		String str = "0123456789";
		Random r = new Random();
		for (int i = 0; i < count; i++) {
			int num = r.nextInt(str.length());
			sb.append(str.charAt(num));
			str = str.replace((str.charAt(num) + ""), "");
		}
		return sb.toString();
	}
}

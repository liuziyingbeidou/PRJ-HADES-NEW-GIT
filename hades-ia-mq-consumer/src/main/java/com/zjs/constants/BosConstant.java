package com.zjs.constants;

/**
 * bos系统常量
 * 
 * @author ErikZhang
 * 
 *         2015-3-24下午2:09:54
 */
public class BosConstant {

	/**
	 * 出库交接单类型
	 */
	public final static Integer OUTBUSITYPE_INNERCITY = 3051;// 市内物流交接单
	public final static Integer OUTBUSITYPE_LONGDISTANCE = 3052;// 长途物流交接单
	public final static Integer OUTBUSITYPE_SENDTAKEN = 3053;// 发货交接单
	public final static Integer OUTBUSITYPE_GJDISTANCE = 3056;// 国际物流交接单
	public final static Integer OUTBUSITYPE_BIGLOGISTIC = 3057;// 大物流交接单

	/**
	 * 单位类型
	 */
	public final static String CORP_TYPE_FRANCHISEE = "BOSCORP00000000A0016";// 加盟商
	public final static String CORP_TYPE_COUNTY_AGENT = "BOSCORP00000000A0018";// 地线周边代理
	public final static String CORP_TYPE_INDEPENDENT = "BOSCORP00000000A0007";// 独立运转中心
	public final static String CORP_TYPE_DLD = "BOSCORP00000000A0001";// 代理点

	/**
	 * 运营方式
	 */
	public final static String RUNTYPE_SELF = "自营";// 5031
	public final static String RUNTYPE_EPIBOLY = "外包";// 5032
	public final static String RUNTYPE_JOIN = "加盟";// 5033

	/**
	 * 运营方式503X
	 */
	public static final String RUNTYPE_SELF_CODE = "5031";// 自营
	public static final String RUNTYPE_EPIBOLY_CODE = "5032";// 外包
	public static final String RUNTYPE_JOIN_CODE = "5033";// 加盟

	/**
	 * 枚举：班车-线路类型 编码：101X
	 */
	public final static String LINETYPE_LINK = "干线"; // 5051
	public final static String LINETYPE_RIM = "周边"; // 5055
	public final static String LINETYPE_SUB = "支线"; // 5052
	public final static String LINETYPE_PROVINCE = "省内"; // 5053
	public final static String LINETYPE_TEMP = "临时"; // 5056
	public final static String LINETYPE_CITY = "市内"; // 5054

	/**
	 * 枚举：班车-线路类型 编码：101X
	 */
	public final static Integer LINETYPE_LINK_CODE = 5051; // 干线
	public final static Integer LINETYPE_RIM_CODE = 5055; // 周边
	public final static Integer LINETYPE_SUB_CODE = 5052; // 支线
	public final static Integer LINETYPE_PROVINCE_CODE = 5053; // 省内
	public final static Integer LINETYPE_TEMP_CODE = 5056; // 临时
	public final static Integer LINETYPE_CITY_CODE = 5054; // 市内

	public final static String LINETYPE_LINK_CODE_STIRNG = "5051"; // 干线
	public final static String LINETYPE_RIM_CODE_STIRNG = "5055"; // 周边
	public final static String LINETYPE_SUB_CODE_STIRNG = "5052"; // 支线
	public final static String LINETYPE_PROVINCE_CODE_STIRNG = "5053"; // 省内
	public final static String LINETYPE_TEMP_CODE_STIRNG = "5056"; // 临时
	public final static String LINETYPE_CITY_CODE_STIRNG = "5054"; // 市内

	/**
	 * 是否
	 */
	public final static String Y = "是";
	public final static String N = "否";
	public final static String Y_CODE = "0";
	public final static String N_CODE = "1";
	public final static Integer Y_CODE_INT = 1;
	public final static Integer N_CODE_INT = 0;
	public final static String Y_ENGLISH = "Y";
	public final static String N_ENGLISH = "N";

	/**
	 * 产品类型
	 */
	public final static String PROD_TYPE_J = "J"; // 急速达
	public final static String PROD_TYPE_H = "H"; // 捷惠达
	public final static String PROD_TYPE_P = "P"; // 普运达
	public final static String PROD_TYPE_Y = "Y"; // 航空
	public final static String PROD_TYPE_N = "N"; // 陆运

	/**
	 * 区域结构
	 */
	public final static Integer REGION_TYPE_COUNTRY = 2191; // 全国
	public final static Integer REGION_TYPE_AREA = 2192; // 区域
	public final static Integer REGION_TYPE_PROV = 2193; // 省内
	public final static Integer REGION_TYPE_CITY = 2194; // 同城

	/**
	 * 工作单类型
	 */
	public static final Integer WO_TYPE_NOMAL = 2201;// 正常
	public static final Integer WO_TYPE_DIFF = 2202;// 异字单
	public static final Integer WO_TYPE_TUNE = 2203;// 调字单
	public static final Integer WO_TYPE_BACK = 2204;// 返货单
	public static final Integer WO_TYPE_ADJT = 2205;// 调整工作单

	/**
	 * 路由——线路类型502X
	 */
	public static Integer LINECLASS_COACH = 5021;// 班车线路
	public static Integer LINECLASS_AIR = 5022;// 航空线路
	public static Integer LINECLASS_RAILWAY = 5023;// 铁路线路
	public static Integer LINECLASS_MARINEL = 5024;// 海运线路
	public static Integer LINECLASS_BUS = 5025;// 大巴线路
	public static Integer LINECLASS_LTL = 5026;// 零担线路
	public static Integer LINECLASS_CONET = 5027;// 合作网络线路

	/**
	 * 路由——线路类型502X
	 */
	public static String LINECLASS_COACH_STRING = "5021";// 班车线路
	public static String LINECLASS_AIR_STRING = "5022";// 航空线路
	public static String LINECLASS_RAILWAY_STRING = "5023";// 铁路线路
	public static String LINECLASS_MARINEL_STRING = "5024";// 海运线路
	public static String LINECLASS_BUS_STRING = "5025";// 大巴线路
	public static String LINECLASS_LTL_STRING = "5026";// 零担线路
	public static String LINECLASS_CONET_STRING = "5027";// 合作网络线路

	/**
	 * 路由——线路类型502X
	 */
	public static String LINECLASS_COACH_FORPAGE = "班车线路";// 5021
	public static String LINECLASS_AIR_FORPAGE = "航空线路";// 5022
	public static String LINECLASS_RAILWAY_FORPAGE = "铁路线路";// 5023
	public static String LINECLASS_MARINEL_FORPAGE = "海运线路";// 5024
	public static String LINECLASS_BUS_FORPAGE = "大巴线路";// 5025
	public static String LINECLASS_LTL_FORPAGE = "零担线路";// 5026
	public static String LINECLASS_CONET_FORPAGE = "合作网络线路";// 5027
	
	/**
	 * 新事业部类型
	 */
	public static final Integer CORPTYPE_NULL = 7080;// 无
	public static final Integer CORPTYPE_STORAGE = 7081;// 云仓事业部
	public static final Integer CORPTYPE_TRANS = 7082;// 运输事业部
	public static final Integer CORPTYPE_DELIVERY = 7083;// 配送事业部
	
	/**
	 * dr 
	 */
	public static final Integer DR_NOMAL = 0;// 正常
	public static final Integer dR_CANCLE = 1;// 作废

}

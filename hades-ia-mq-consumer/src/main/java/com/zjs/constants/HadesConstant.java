package com.zjs.constants;

import java.math.BigDecimal;

/**
 * Hades系统常量
 * 
 * @author MrDu
 * 
 */
public class HadesConstant {

	/**
	 * 操作费常量
	 */
	public final static Integer TOLL_TYPE_INDEPENDENT_INCOME = 1;// 独立收
	public final static Integer TOLL_TYPE_NOT_INDEPENDENT_INCOME = 2;// 非独收
	public final static Integer TOLL_TYPE_NOT_INCOME = 3;// 不收
	public final static Integer TOLL_TYPE_TRANS_PROV = 4;// 跨省

	public final static String TOLL_TYPE_INDEPENDENT_INCOME_STRING = "独立收";// 1
	public final static String TOLL_TYPE_NOT_INDEPENDENT_INCOME_STRING = "非独收";// 2
	public final static String TOLL_TYPE_NOT_INCOME_STRING = "不收";// 3
	public final static String TOLL_TYPE_TRANS_PROV_STRING = "跨省";// 4

	public final static Integer AREA_TYPE_OUT_PROV = 1;// 出港省内
	public final static Integer AREA_TYPE_IN_PROV = 2;// 进港省内
	public final static Integer AREA_TYPE_NATION = 3;// 全国

	public final static String AREA_TYPE_OUT_PROV_STRING = "出港省内";// 1
	public final static String AREA_TYPE_IN_PROV_STRING = "进港省内";// 2
	public final static String AREA_TYPE_NATION_STRING = "全国";// 3

	/**
	 * 省内分公司设置查询类型
	 */
	public final static Integer PROV_BRANCH_TYPE_OPER = 1;// 操作费
	public final static Integer PROV_BRANCH_TYPE_PROV = 2;// 省内费用
	public final static Integer PROV_BRANCH_TYPE_COACH = 3;// 班车
	public final static Integer PROV_BRANCH_TYPE_TRUNK = 4;// 干线

	/**
	 * 超盲区常量
	 */
	public final static Integer SUPER_ZONE_TURN_TYPE = 1919;// 超区
	public final static Integer DEAD_ZONE_TURN_TYPE = 1920;// 盲区

	/**
	 * 派送费常量
	 */

	public final static Integer AREA_DELR_WO_COD = 6311;// COD工作单
	public final static Integer AREA_DELR_WO_NCOD = 6666;// 与bos保持一致，具体为什么为6666我也不太清楚

	public final static Integer AREA_TYPE_DELR_PROV = 1;// 省内
	public final static Integer AREA_TYPE_DELR_NATION = 2;// 全国

	public final static String AREA_TYPE_DELR_PROV_STRING = "省内";// 1
	public final static String AREA_TYPE_DELR_NATION_STRING = "全国";// 2

	/**
	 * 进出港类型
	 */
	public final static Integer INOUTTYPE_INPROV = 1;// 进港省内
	public final static Integer INOUTTYPE_OUTPROV = 2;// 出港省内

	public final static String INOUTTYPE_INPROV_FORPAGE = "进港省内";// 1
	public final static String INOUTTYPE_OUTPROV_FORPAGE = "出港省内";// 2

	/**
	 * 中转类型
	 */
	public final static Integer TRANSTYPE_OUTSUB = 1;// 出港支线
	public final static Integer TRANSTYPE_OUTLINK = 2;// 出港干线
	public final static Integer TRANSTYPE_INSUB = 3;// 进港支线

	public final static String TRANSTYPE_OUTSUB_ForPage = "出港支线";// 1
	public final static String TRANSTYPE_OUTLINK_ForPage = "出港干线";// 2
	public final static String TRANSTYPE_INSUB_ForPage = "进港支线";// 3

	public final static BigDecimal BIGDEMIAML_ZERO = new BigDecimal(0.0);
	public final static BigDecimal BIGDEMIAML_TENTHOUSAND = new BigDecimal(10000.0);
	public final static BigDecimal BIGDEMIAML_ONE = new BigDecimal(1);
	public final static BigDecimal DEFUAL_WEIT = new BigDecimal(30.00);

	/**
	 * 产品类型
	 */
	public final static Integer PROD_TYPE_J = 1; // 急速达
	public final static Integer PROD_TYPE_H = 2; // 捷惠达
	public final static Integer PROD_TYPE_P = 3; // 普运达
	public final static Integer PROD_TYPE_Y = 4; // 航空
	public final static Integer PROD_TYPE_N = 5; // 陆运

	public final static String PROD_TYPE_J_STRING = "急速达"; // 1
	public final static String PROD_TYPE_H_STRING = "捷惠达"; // 2
	public final static String PROD_TYPE_P_STRING = "普运达"; // 3
	public final static String PROD_TYPE_Y_STRING = "航空"; // 4
	public final static String PROD_TYPE_N_STRING = "陆运"; // 5

	/**
	 * 结算方式
	 */
	public static final Integer FBALNTYPE_CASH = 2051;// 现结
	public static final Integer FBALNTYPE_GET = 2053;// 到付
	public static final Integer FBALNTYPE_MONTH = 2052;// 月结
	public static final Integer FBALNTYPE_INTERNET = 2054;// 网络
	public static final Integer FBALNTYPE_INTERNETGET = 2055;// 网络到付

	public static final String FBALNTYPE_CASH_STRING = "现结";// 2051
	public static final String FBALNTYPE_GET_STRING = "到付";// 2053
	public static final String FBALNTYPE_MONTH_STRING = "月结";// 2052
	public static final String FBALNTYPE_INTERNET_STRING = "网络";// 2054
	public static final String FBALNTYPE_INTERNETGET_STRING = "网络到付";// 2055

	/**
	 * 保险类型
	 */
	public static final Integer INSUREANCE_NO = 0;// 不保险
	public static final Integer INSUREANCE_DEL = 1;// 委托保险
	public static final Integer INSUREANCE_SEL = 2;// 自代投保
	public static final Integer INSUREANCE_PRI = 3;// 保价

	public static final String INSUREANCE_NO_STRING = "不保险";// 0
	public static final String INSUREANCE_DEL_STRING = "委托保险";// 1
	public static final String INSUREANCE_SEL_STRING = "自代投保";// 2
	public static final String INSUREANCE_PRI_STRING = "保价";// 3

	/**
	 * 工作单类型：220X
	 */
	public static final Integer FWOTYPE_NOMAL = 2201;// 正常
	public static final Integer FWOTYPE_DIFFERENT = 2202;// 异字单
	public static final Integer FWOTYPE_TUNE = 2203;// 调字单
	public static final Integer FWOTYPE_BACK = 2204;// 返货单
	public static final Integer FWOTYPE_ADJUSTMENT = 2205;// 调整工作单

	public static final String FWOTYPE_NOMAL_STRING = "正常";// 2201
	public static final String FWOTYPE_DIFFERENT_STRING = "异字单";// 2202
	public static final String FWOTYPE_TUNE_STRING = "调字单";// 2203
	public static final String FWOTYPE_BACK_STRING = "返货单";// 2204
	public static final String FWOTYPE_ADJUSTMENT_STRING = "调整工作单";// 2205

	/**
	 * 工作单签收类型 ：223X
	 */
	public static final Integer FSIGNSTAT_NO = 2231;// 未签收
	public static final Integer FSIGNSTAT_NOMAL = 2232;// 正常签收
	public static final Integer FSIGNSTAT_BACK = 2233;// 返货签收
	public static final Integer FSIGNSTAT_DIFFERENT = 2234;// 异常签收

	public static final String FSIGNSTAT_NO_STRING = "未签收";// 2231
	public static final String FSIGNSTAT_NOMAL_STRING = "正常签收";// 2232
	public static final String FSIGNSTAT_BACK_STRING = "返货签收";// 2233
	public static final String FSIGNSTAT_DIFFERENT_STRING = "异常签收";// 2234
	/**
	 * 重量段
	 */
	public final static Integer WEIT_STAGE_0_1 = 1; // 0-1KG
	public final static Integer WEIT_STAGE_1_2 = 2; // 1-2KG
	public final static Integer WEIT_STAGE_2_3 = 3; // 2-3KG
	public final static Integer WEIT_STAGE_3_4 = 4; // 3-4KG
	public final static Integer WEIT_STAGE_4_5 = 5; // 4-5KG
	public final static Integer WEIT_STAGE_5_10 = 6; // 5-10KG
	public final static Integer WEIT_STAGE_10_20 = 7; // 10-20KG
	public final static Integer WEIT_STAGE_20_30 = 8; // 20-30KG
	public final static Integer WEIT_STAGE_30_50 = 9; // 30-50KG
	public final static Integer WEIT_STAGE_50_M = 10; // 50+KG

	/**
	 * 区域结构
	 */
	public final static Integer REGION_TYPE_COUNTRY = 1; // 全国
	public final static Integer REGION_TYPE_AREA = 2; // 区域
	public final static Integer REGION_TYPE_PROV = 3; // 省内
	public final static Integer REGION_TYPE_CITY = 4; // 同城

	public final static String REGION_TYPE_COUNTRY_STRING = "全国"; // 1
	public final static String REGION_TYPE_AREA_STRING = "区域"; // 2
	public final static String REGION_TYPE_PROV_STRING = "省内"; // 3
	public final static String REGION_TYPE_CITY_STRING = "同城"; // 4

	/**
	 * 网络结算--货物类型
	 */
	public final static Integer NR_CARGO_TYPE_COMMON = 1;  //普货
	public final static Integer NR_CARGO_TYPE_COLLECTION = 2; //代收

	public final static String NR_CARGO_TYPE_COMMON_STRING = "普货";  //1
	public final static String NR_CARGO_TYPE_COLLECTION_STRING = "代收"; //2
	public final static String NR_CARGO_TYPE_STRING="普货,代收";

	/**
	 * 网络结算 -- 区域类型
	 */
	public final static Integer NR_REGION_TYPE_COUNTRY = 1; // 全国
	public final static Integer NR_REGION_TYPE_PROV = 2; // 省内

	public final static String NR_REGION_TYPE_COUNTRY_STRING = "全国"; // 1
	public final static String NR_REGION_TYPE_PROV_STRING = "省内"; // 2
	public final static String NR_REGION_TYPE_STRING ="全国,省内";
	
	/**
	 * 网络结算 -- 业务类型
	 */
	public final static String NR_BUSINESS_TYPE_DIAOBO = "1";// 调拨
	public final static String NR_BUSINESS_TYPE_COD = "2";// 月结代收
	public final static String NR_BUSINESS_TYPE_COMM = "3";// 月结普货
	
	public final static String NR_BUSINESS_TYPE_DIAOBO_S = "调拨";
	public final static String NR_BUSINESS_TYPE_COD_S = "月结代收";
	public final static String NR_BUSINESS_TYPE_COMM_S = "月结普货";
	
	/**
	 * 线路类型
	 */
	public final static Integer LINETYPE_LINK = 1; // 干线
	public final static Integer LINETYPE_SUB = 2; // 支线

	/**
	 * 派费省内全国类型
	 */
	public final static Integer AREA_TYPE_PROV = 1;// 省内
	public final static Integer AREA_TYPE_COUNTRY = 2;// 全国

	/**
	 * 默认票数
	 */
	public final static Integer CORP_POLL = 1;// 默认票数

	/**
	 * 存mongoDB时字符串默认值 之前是存储的空字符串“”，但是在分类汇总时有异常
	 */
	public final static String STR_NULL = "N";
	/**
	 * 合包类型
	 */
	public final static Integer POUHTYPE_POUH = 1;// 合包
	public final static Integer POUHTYPE_NOPOUH = 2;// 非合包

	public final static String POUHTYPE_POUH_STRING = "合包";// 1
	public final static String POUHTYPE_NOPOUH_STRING = "非合包";// 2

	/**
	 * 公司
	 */
	public static String CORP_CODE_A = "A";// 总公司编码
	public static String CORP_NAME_A = "(ZJS)总公司";// 总公司名称

	/**
	 * 发货性质
	 */
	public static Integer SENDTYPE_LAND = 1;// 零担
	public static Integer SENDTYPE_AIR = 2;// 航空

	public static String SENDTYPE_LAND_STRING = "零担";// 零担
	public static String SENDTYPE_AIR_STRING = "航空";// 航空
			
	/**
	 * 发货方式
	 */
	public static Integer SEND_TYPE_LAND = 1;// 陆运
	public static Integer SEND_TYPE_AIR = 2;// 航空
	
	public static String SEND_TYPE_LAND_STRING = "陆运";// 陆运
	public static String SEND_TYPE_AIR_STRING = "航空";// 航空
	public final static String NR_SEND_TYPE_STRING="陆运,航空";

	/**
	 * 特殊市级单位 数据格式("深圳市,天津市,北京市")
	 */
	public static String SPECIAL_CITY_NAME = "深圳市";
	
	/**
	 * 插入任务需要间隔的描述
	 */
	public static int TIME_SPACING_SECOND = 5;
	
	//*****************************事业部内部核算常量begin*****************************************
	/**
	 * 通用价格表——项目编号
	 */
	public final static int PROJ_CODE_1 = 2007;// 默认重量(kg/件)
	public final static int PROJ_CODE_2 = 2003;// 默认价格(元/公斤)
	public final static int PROJ_CODE_3 = 2004;// 整包收操作费(元)
	public final static int PROJ_CODE_4 = 2005;// 单件退操作费(元/件)
	public final static int PROJ_CODE_5 = 2006;// 默认件数
	
	/**
	 * 省会标志
	 */
	public final static int PROV_CITY_Y = 1;// 省会
	public final static int PROV_CITY_N = 2;// 非省会
	
	public final static String PROV_CITY_Y_STRING = "是";// 省会
	public final static String PROV_CITY_N_STRING = "否";// 非省会
	
	/**
	 * 计费方式
	 */
	public final static int COMPUTE_TYPE_1 = 1;// 按件
	public final static int COMPUTE_TYPE_2 = 2;// 按票
	
	
	public final static String COMPUTE_TYPE_NAME_1 = "按件";// 按件
	public final static String COMPUTE_TYPE_NAME_2 = "按票";// 按票
	
	

	/**
	 * 新事业部类型
	 */
	public static final Integer CORPTYPE_NULL = 7080;// 无
	public static final Integer CORPTYPE_STORAGE = 7081;// 云仓事业部
	public static final Integer CORPTYPE_TRANS = 7082;// 运输事业部
	public static final Integer CORPTYPE_DELIVERY = 7083;// 配送事业部
	
	public static final int CORPTYPE_NULL_INT = 7080;// 无
	public static final int CORPTYPE_STORAGE_INT = 7081;// 云仓事业部
	public static final int CORPTYPE_TRANS_INT = 7082;// 运输事业部
	public static final int CORPTYPE_DELIVERY_INT = 7083;// 配送事业部
	
	public static final String CORPTYPE_NULL_STRING = "无";// 无
	public static final String CORPTYPE_STORAGE_STRING = "云仓事业部";// 云仓事业部
	public static final String CORPTYPE_TRANS_STRING = "运输事业部";// 运输事业部
	public static final String CORPTYPE_DELIVERY_STRING = "配送事业部";// 配送事业部
	
	/**
	 * 映射类型--运费类型
	 */
	public final static Integer TRANS_TYPE_H = 1; //航空
	public final static Integer TRANS_TYPE_L = 2; //陆运
	public final static Integer TRANS_TYPE_LW = 3; //陆运重货
	public final static Integer TRANS_TYPE_HW = 4; //航空重货
	
	
	public final static String TRANS_TYPE_H_STRING = "航空"; //航空
	public final static String TRANS_TYPE_L_STRING = "陆运"; //陆运
	public final static String TRANS_TYPE_LW_STRING = "陆运重货"; //陆运重货
	public final static String TRANS_TYPE_HW_STRING = "航空重货"; //航空重货
	
	
	//*****************************事业部内部核算常量end*******************************************
}

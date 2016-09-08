package com.zjs.constants;

public class TaskTypeConstant {

	/**
	 * 出库任务类型
	 */
	public static final int TASK_COACH = 1; // 班车分摊
	public static final int TASK_PROV = 3; // 省内分摊
	public static final int TASK_OPER_FEE = 2; // 操作费
	public static final int TASK_PDEELE = 4;// 零担分摊
	public static final int TASK_PARAMIDTRANS_FEE = 5;// 分段中转费
	public static final int TASK_TRANSPORT_FEE = 6;// 运输费任务
	public static final int TASK_POUH = 7;// 合包任务
	public static final int TASK_SCAN_FEE = 8;// 扫描费任务
	public static final int TASK_PICKUP_FEE = 9;// 取件费任务

	public static final String TASK_DEL_FEE_ADD = "1"; // 派送费新增
	public static final String TASK_DEL_FEE_DEL = "2"; // 派送费删除
	public static final String TASK_DEL_FEE_TYPE = "4-";// 计算派费的一种工作单类型4-单
	public static final String TASK_DEL_FEE_CUST = "PUB_INIT000007363288";// 客户刷单件
	public static final String TASK_DEL_FEE_SIGN = "2234";// 异常签收类型

	public static final int TASK_ADV = 1; // 提发货垫付分摊

	public static final int TASK_SUPER = 1; // 超盲区
	/**
	 * 以下是hds_common_worker_task任务表的任务类型常量
	 */
	public static final int TASK_COACHUNITPRICE = 1; // 班车单价设置
	public static final int TASK_COACH_FEE_REPORT = 2; // 班车报表任务
	public static final int TASK_OPER_FEE_REPORT = 3; // 操作费报表任务
	public static final int TASK_PROV_FEE_REPORT = 4; // 省内费用报表任务
	public static final int TASK_DELR_FEE_REPORT = 5; // 派送费报表任务
	public static final int TASK_CODHANDFEE_REPORT = 6;// 代收货款手续费报表任务
	public static final int TASK_SUPER_FEE_REPORT = 7;// 应收应付超盲区报表任务
	public static final int TASK_SELECTOUTTASK = 8;// 主动获取出库任务,服务于班车分摊worker
	public static final int TASK_MANAGE_REPORT = 9; // 管理报表任务
	public static final int TASK_PEDDLE_REPORT = 10; // 零担汇总报表
	public static final int TASK_OPER_POUH_REPORT = 11;// 合包报表任务
	public static final int TASK_OPER_FEE_TOTAL = 12;// 操作费汇总任务
	public static final int TASK_TRANSFER_OP_CENTER = 13;// 中转费转运单位分析表任务
	public static final int TASK_TRANSFER_PROV_ANALYSIS = 14;// 中转费省内分析表任务
	public static final int TASK_TRANSFEE_TOTAL_REPORT = 15;// 中转费汇总报表任务
	public static final int TASK_TRANSFEE_OUT_REPORT = 16;// 中转费出港分析表
	public static final int TASK_LEAST_PROFIT_DAY_REPORT = 17;// 最小利润按照天统计分析表
	public static final int TASK_LEAST_PROFIT_REPORT = 18;// 最小利润统计分析明细表
	public static final int TASK_WHOLESETTLE_REPORT = 19;// 全网结算报表
	public static final int TASK_TRANSPORT_FEE_REPORT = 20;// 运输费报表
	public static final int TASK_SCAN_FEE_REPORT = 21;// 扫描费报表
	public static final int TASK_PICKUP_FEE_REPORT = 22;// 取件费报表
	public static final int TASK_POUH_REPORT = 23;// 合包报表(事业部内部核算项目)	
	
	public static final int TASK_CLEAN_UP_TABLE_DATA = 100;// 定期清理worker表任务(事业部内部核算项目)
	

	/**
	 * hds_earn_worker_task任务类型
	 */
	public static final int TASK_EARN_CONFIRM = 1; // 收入确认
	public static final int TASK_EARN_CONFIRM_POD = 2;// POD收入确认

	/**
	 * 收入确认推送数据
	 */
	public static final String TASK_EARN_CONFIRM_ADD = "1"; // 新增
	public static final String TASK_EARN_CONFIRM_DEL = "2"; // 删除

	/**
	 * 签收任务hds_sign_worker_task
	 */
	public static final int TASK_SIGN_TASK_POD = 2;// POD签收
	public static final int TASK_SIGN_TASK_IA = 1;// 派送费
	public static final int TASK_SIGN_TASK_IA_MIDTRANSFEE_PROV = 3;// 省到省中转费
	public static final int TASK_SIGN_TASK_IA_OPERFEE_NEW = 4;// 新操作费(内部核算二期)
	public static final int TASK_SIGN_TASK_IA_TRANS = 5;

	/* 签收任务属性 */

	public static final String TASK_SIGN_TASKPROP_ADD = "1";// 新增
	public static final String TASK_SIGN_TASKPROP_DEL = "2";// 删除

	/**
	 * 核销处理 pod-verify-confirm-worker
	 */
	public static final Integer TASK_VERIFY_CONFIRM_UNDIFFERENTIATED = 1;// 无差异核销
	public static final Integer TASK_VERIFY_CONFIRM_DIFFERENTIATED = 2;// 差异核销

	/**
	 * 异常调账处理 pod-excp-adjt-worker
	 */
	public static final int TASK_EXCP_ADJT = 1;// 异常调账worker

	/**
	 * POD返款任务表hds_pod_return_worker_task
	 */
	public static final int RETURN_WORKER = 1;// 返款任务

	/**
	 * POD通用worker任务表hds_pod_common_worker_task
	 */
	public static final int STATEMENT = 1;// 对账单
	public static final int CARRIAGE = 2;// 运费账单
	public static final int RETREAT = 3;// 代退账单
	public static final int ADJUST = 4;// 代收调账账单
	public static final int REPAYMENT = 5;// 返款监控

}

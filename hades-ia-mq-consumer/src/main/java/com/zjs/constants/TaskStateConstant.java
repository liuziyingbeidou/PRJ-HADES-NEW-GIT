package com.zjs.constants;

/**
 * 
 * @Description: 任务运行状态
 * @author huangsong
 * @date 2014-5-13 上午9:46:01
 */
public class TaskStateConstant {
	/** WorkerTask执行状态 **/
	public static final int TASK_WIATIMG = 1; // 等待处理状态
	public static final int TASK_EXETING = 2;// 正在处理中
	public static final int TASK_SUCEESS = 3;// 成功处理完成
	public static final int TASK_ERROR = 4;// 处理异常状态

	public static final int TASK_MAX_EXCUT_DEFUALT = 0; // 默认是0次
	/** 任务最大次数 **/
	public static final int TASK_MAX_EXCUT_TIME = 6; // 任务最大执行次数
	
}

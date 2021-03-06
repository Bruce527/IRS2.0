package com.sinosoft.platform.core.spring.quartz;

import java.util.HashMap;
import java.util.Map;
/**
 * 批处理上下文配置类
 * @author Darker.Wang
 * @date 2016-10-12 上午9:34:17
 * @company SINOSOFT
 */
public class Constant {
	public static final String TRIGGERTYPE = "trigger_type";
	public static final String JOBNAME = "job_name";
	public static final String CRONEXPRESSION = "cron_expression";
	public static final String 	TRIGGERNAME = "triggerName";
	public static final String 	TRIGGERGROUP = "triggerGroup";
	public static final String STARTTIME = "startTime";
	public static final String ENDTIME = "endTime";
	public static final String REPEATCOUNT = "repeatCount";
	public static final String REPEATINTERVEL = "repeatInterval";
	
	public static final Map<String,String> status = new HashMap<String,String>();
	static{
		status.put("ACQUIRED", "运行中");
		status.put("PAUSED", "暂停中");
		status.put("WAITING", "等待中");
	}
}

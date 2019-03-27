/**
 * 
 */
package com.sinosoft.ummp.task;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Date;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.model.TDefCodeDict;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.util.UMMPContext;

/**
 * 批处理超级父类，实现了Runnable 接口<br>
 * 1、若是当线程使用，则直接启动就行，若是当类使用，则调用excute方法<br>
 * 2、可在子类构造器中调用 setJobGroup("SYS-AUTO") 申明群组<br>
 * 3、若是手动执行，必要时请在结束后调用 destroy 销毁缓存
 * @author Darker.Wang
 * @date 2016-8-11 上午11:05:45
 * @company SINOSOFT
 * @version 1.0
 */
public abstract class SuperJob implements Runnable{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			excute();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  GenericXmlApplicationContext context = new GenericXmlApplicationContext();
	public LoginInfo loginInfo = new LoginInfo();
	public String jobGroup = "DEFAULT";
	public CodeQueryService codeQueryService = null;
	/**
	 * 设置批处理群组，可在每个批处理构造器中声明，否则默认：DEFAULT
	 * @param jobGroup
	 */
	public void setJobGroup(String jobGroup){
		this.jobGroup = jobGroup;
	}
	/**
	 * 获取JOB群组,默认为：DEFAULT
	 * @return
	 */
	public String getJobGroup(){
		return this.jobGroup;
	}
	/**
	 * 销毁Content，系统回收资源。必要时请在执行完毕之后调用
	 */
	public void destroy(){
		context.destroy();
		context = null;
		loginInfo = null;
		jobGroup = null;
		System.gc();
	}
	
	//静态代码块的执行只在类加载的时候执行且只执行一次
	//此处保证只加载一次，不重复加载应用上下文 by kevin li
	public static GenericXmlApplicationContext context1 = new GenericXmlApplicationContext();
	static {
		context1.setValidating(false);
		// TODO 只加载spring对应的Bean即可，不用全部配置文件都加载
		context1.load("classpath*:spring/context-datasource-jdbc.xml");
		context1.load("classpath*:spring/infrastructure-persistence.xml");
		context1.refresh();
	}
	/**
	 * 父类构造器初始化SPRING MVC 配置文件
	 */
	public SuperJob() {
		// TODO Auto-generated constructor stub
//		context.setValidating(false);
//		// TODO 只加载spring对应的Bean即可，不用全部配置文件都加载
//		context.load("classpath*:spring/context-datasource-jdbc.xml");
//		context.load("classpath*:spring/infrastructure-persistence.xml");
//		context.refresh();
		context=context1;
		// TODO Auto-generated set userCode
		loginInfo.setUserCode(UMMPContext.AUTO_USER);
		codeQueryService = context.getBean(CodeQueryService.class);
		System.out.println("- load spring context success: [loginInfo:"+loginInfo+",codeQueryService:"+codeQueryService+"]");
	}
	/**
	 * 具体JOB开始方法
	 * @return
	 * @throws Exception 
	 */
	public abstract boolean excute() throws Exception;
	/**
	 * 功能:得到某时间单位,在某个时间段内往后或往前推某个时间段的日期 日期格式：yyyy--MM--dd unit:Y,M,D
	 * @param baseDate 相对日期
	 * @param interval 正值向后 负值向前
	 * @param unit  时间间隔单位，可以为 Y（年）、M（月）、D（天）
	 * @return
	 */
	public String calDate(String baseDate,int interval,String unit){
		try {
			return DateUtils.calDate(baseDate, interval, unit);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 功能:得到某时间单位,在某个时间段内往后或往前推某个时间段的日期 日期格式：yyyy--MM--dd unit:Y,M,D
	 * @param baseDate 相对日期
	 * @param interval 正值向后 负值向前
	 * @param unit  时间间隔单位，可以为 Y（年）、M（月）、D（天）
	 * @return
	 */
	public Date calDate(Date baseDate,int interval,String unit){
		return DateUtils.calDate(baseDate, interval, unit);
	}
	/**
	 * 获取字典表数据
	 * @param codeType
	 * @param code
	 * @param comId
	 * @return
	 */
	public TDefCodeDict getCodeDict(String codeType,String code,BigDecimal comId){
		return codeQueryService.getQueryCode(codeType,code,comId);
	}
	/**
	 * 更新字典表数据
	 * @param codeDict
	 * @return
	 */
	public int updateCodeDict(TDefCodeDict codeDict){
		return codeQueryService.updateQueryCode(codeDict);
	}
	/**
	 * @param args
	 */
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		SuperJob job =  new PRPUploadFileJob();
//		try {
//			job.excute();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}

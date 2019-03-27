package com.sinosoft.ummp.application.impl;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.application.FileService;
import com.sinosoft.platform.core.application.SequenceService;
import com.sinosoft.platform.core.domain.mapper.DefUserMapper;
import com.sinosoft.platform.core.domain.mapper.TDefCodeDictMapper;
import com.sinosoft.platform.core.domain.model.DefUser;
import com.sinosoft.platform.core.domain.model.DefUserExample;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.DateUtils;
import com.sinosoft.platform.core.util.EmailSender;
import com.sinosoft.ummp.application.EmailSinoService;
import com.sinosoft.ummp.application.MonitorDeployService;
import com.sinosoft.ummp.domain.mapper.TDefBagEventMapper;
import com.sinosoft.ummp.domain.mapper.TDefMonitorActionMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeAccountMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeAddMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeMainMapper;
import com.sinosoft.ummp.domain.mapper.TDefNoticeMapper;
import com.sinosoft.ummp.domain.model.TDefBagEvent;
import com.sinosoft.ummp.domain.model.TDefBagEventExample;
import com.sinosoft.ummp.domain.model.TDefMonitor;
import com.sinosoft.ummp.domain.model.TDefMonitorAction;
import com.sinosoft.ummp.domain.model.TDefNotice;
import com.sinosoft.ummp.domain.model.TDefNoticeAccount;
import com.sinosoft.ummp.domain.model.TDefNoticeAccountExample;
import com.sinosoft.ummp.domain.model.TDefNoticeAdd;
import com.sinosoft.ummp.domain.model.TDefNoticeAddExample;
import com.sinosoft.ummp.domain.model.TDefNoticeExample;
import com.sinosoft.ummp.domain.model.TDefNoticeMain;
import com.sinosoft.ummp.domain.model.TDefNoticeMainExample;
import com.sinosoft.ummp.util.UMMPContext;
/**
 * 邮件通知服务实现类，如果事件包包没有通知事件对应的SQL，则不生成附件
 * @author Darker.Wang
 * @date 2016-12-9 下午2:46:26
 * @company SINOSOFT
 */
@Service
public class EmailSinoServiceImpl implements EmailSinoService {
	Logger logger = Logger.getLogger(EmailSinoServiceImpl.class);
	ApplicationContext context = null;
	@SuppressWarnings("rawtypes")
	private Map param = new HashMap();
	@Autowired
	TDefNoticeAccountMapper tDefNoticeAccountMapper;
	@Autowired
	TDefNoticeAddMapper tDefNoticeAddMapper;
	@Autowired
	TDefNoticeMainMapper tDefNoticeMainMapper;
	@Autowired
	TDefNoticeMapper tDefNoticeMapper;
	@Autowired
	DefUserMapper defUserMapper;
	@Autowired
	MonitorDeployService monitorDeployService;
	@Autowired
	TDefCodeDictMapper tDefCodeDictMapper;
	@Autowired
	TDefMonitorActionMapper tDefMonitorActionMapper;
	@Autowired
	SequenceService sequenceService;
	@Autowired
	CodeQueryService codeQueryService;
	@Autowired 
	FileService fileService;
	@Autowired
	TDefBagEventMapper tDefBagEventMapper;
	
	private String title;
	private String content;
	
	@Override
	public boolean sendEmail(TDefMonitor tDefMonitor) throws CoreException {
		// 当容器中自动入住失败则重新从指定容器中获取
		if(tDefNoticeAccountMapper == null){
			System.out.println("- 自动入住失败，开始从指定容器中获取值");
			//TODO 重新加载自动入住对象
			boolean result = initReFreash();
			if(!result){
				return result;
			}
		}
		// 发件人信息
		TDefNoticeAccountExample example = new TDefNoticeAccountExample();
		// notice_type = F and ER_status = 1
		example.createCriteria().andNoticeTypeEqualTo("F").andErStatusEqualTo("1");
		List<TDefNoticeAccount> selectByExample = tDefNoticeAccountMapper
				.selectByExample(example);
		if(selectByExample == null || selectByExample.size() <= 0){
			logger.info("监控事件包："+tDefMonitor.getMonitorName()+" 无发送邮箱，若有需要请于监控管理中进行发送邮箱配置。");
			return true;
		}
		//构建发送信息
		String accountAddr = selectByExample.get(0).getAccountAddr();
		String accountPass = selectByExample.get(0).getAccountPass();
		String webAddress = selectByExample.get(0).getWebAddress();
		String webPort = selectByExample.get(0).getWebPort();
//		String accountUser = selectByExample.get(0).getAccountUser();
		
		System.out.println("- EmailSender[ sender : "+accountAddr+" ip : "+webAddress+" port : "+webPort+" ]");
		
		//构造配置文件
		Properties properties = new Properties();
		properties.put("mail.transport.protocol", "smtp");
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.host", webAddress);
		properties.put("mail.smtp.port", webPort);
		properties.put("mail.from.user", accountAddr);
		properties.put("mail.from.pass",accountPass );
		EmailSender sender = EmailSender.getInstance(properties);
		
		//设置标题
		if(title == null || title.equals("")){
			title = "【ICP 邮件提醒】 事件包 "+tDefMonitor.getMonitorName()+" "+DateUtils.getCurrentDateTime();
		}
		sender.setTitle(title);
		
		// 收件人地址
		List<String> list = new ArrayList<String>();
		// 抄送人地址
		List<String> list1 = new ArrayList<String>();
		
		TDefNoticeExample example1 = new TDefNoticeExample();
		example1.createCriteria().andNoticeCodeEqualTo(tDefMonitor.getMonitorCode());
		List<TDefNotice> tDefNotices = tDefNoticeMapper.selectByExample(example1);
		if(tDefNotices == null || tDefNotices.size() <= 0){
			logger.info("监控事件包："+tDefMonitor.getMonitorName()+" 无监控接收者，若有需要请于监控管理中进行监控事件配置。");
			return true;
		}
		
		BigDecimal noticeId = tDefNotices.get(0).getNoticeId();
		//收件人表
		TDefNoticeMainExample example3 = new TDefNoticeMainExample();
		example3.createCriteria().andNoticeIdEqualTo(noticeId);
		List<TDefNoticeMain> selectByExample3 = tDefNoticeMainMapper.selectByExample(example3);
		if(selectByExample3.size() == 0){
			throw new CoreException("事件包【'"+tDefMonitor.getMonitorName()+"'】没有收件人信息");
		}
		//收件人信息
		for (int i = 0; i < selectByExample3.size(); i++) {
			String noticeTo = selectByExample3.get(i).getNoticeTo();
			DefUserExample example4 = new DefUserExample();
			example4.createCriteria().andIdEqualTo(new BigDecimal(noticeTo));
			List<DefUser> selectByExample4 = defUserMapper.selectByExample(example4);
			if (selectByExample4.size() == 0) {
				TDefNoticeAccountExample example5 = new TDefNoticeAccountExample();
				example5.createCriteria().andIdEqualTo(new BigDecimal(noticeTo)).andNoticeTypeEqualTo("I");
				List<TDefNoticeAccount> selectByExample5 = tDefNoticeAccountMapper.selectByExample(example5);
				for(int I = 0 ; I < selectByExample5.size() ; I ++){
					String addr = selectByExample5.get(I).getAccountAddr();
					list.add(addr);
				}
			} else {
				String email = selectByExample4.get(0).getEmail();
				list.add(email);
			}
		}
		//抄送人信息
		TDefNoticeExample example6 = new TDefNoticeExample();
		example6.createCriteria().andNoticeCodeEqualTo(tDefMonitor.getMonitorCode());
		List<TDefNotice> selectByExample6 = tDefNoticeMapper.selectByExample(example6);
		BigDecimal noticeId1 = selectByExample6.get(0).getNoticeId();
		TDefNoticeAddExample example8 = new TDefNoticeAddExample();
		example8.createCriteria().andNoticeIdEqualTo(noticeId1);
		List<TDefNoticeAdd> selectByExample8 = tDefNoticeAddMapper.selectByExample(example8);
		
		for (int i = 0; i < selectByExample8.size(); i++) {
			String noticeTo = selectByExample8.get(i).getNoticeTo();
			DefUserExample example9 = new DefUserExample();
			example9.createCriteria().andIdEqualTo(new BigDecimal(noticeTo));
			List<DefUser> selectByExample9 = defUserMapper.selectByExample(example9);
			if (selectByExample9.size() == 0) {
				TDefNoticeAccountExample example10 = new TDefNoticeAccountExample();
				example10.createCriteria().andIdEqualTo(new BigDecimal(noticeTo));
				List<TDefNoticeAccount> selectByExample10 = tDefNoticeAccountMapper
						.selectByExample(example10);
				if (selectByExample10.size() != 0) {
					for(int II = 0; II < selectByExample10.size(); II++){
						String addr = selectByExample10.get(II).getAccountAddr();
						list1.add(addr);
					}
				}
			} else {
				String email = selectByExample9.get(0).getEmail();
				list1.add(email);
			}
		}
		
		String[] iaSendTos = new String[list.size()];//发送
		String[] iaSendCcs =  new String[list1.size()];//抄送
		for(int i = 0 ; i < list.size(); i ++){
			String add = list.get(i);
			iaSendTos[i] = add;
		}
		for(int i = 0 ; i < list1.size(); i ++){
			String add = list1.get(i);
			iaSendCcs[i] = add;
		}
		
		TDefBagEventExample exampleo = new TDefBagEventExample();
		exampleo.createCriteria().andMonitorCodeEqualTo(tDefMonitor.getMonitorCode());
		List<TDefBagEvent> events = tDefBagEventMapper.selectByExample(exampleo);
		boolean result = false;
		int all = 1;
		int succ = 0;
		// TODO 判断有事件才走事件包生成步骤，无事件则不进行事件包生成，邮件无附件
		File[] attachments = null;
		if(events != null && events.size() > 0){
			//先遍历一边是否事件ID有效
			boolean isGoon = false;
			for(int I = 0; I <events.size(); I ++){
				BigDecimal sqlId = events.get(I).getSqlId();
				if(sqlId == null || sqlId.equals("")){
					continue;
				}
				//只要有一条有效的SQL则继续
				isGoon = true;
				break;
			}
			if(isGoon){
				// 附件
				attachments = new File[1];
				String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
				String path = codeQueryService.getSysPath("TEMP_PATH");
				String name = path + tDefMonitor.getMonitorCode() + "-" + str + ".xls";
				monitorDeployService.setParam(param);//自定义参数传递，用于传递前台值到后台
				monitorDeployService.createZip(tDefMonitor.getMonitorCode(), name);
				String zipName = path + tDefMonitor.getMonitorCode() + "-" + str + ".zip";
				File attachment = new File(zipName);
				attachments[0] = attachment;
				sender.setAttachments(attachments);
				//生成完ZIP则源文件删除
				fileService.deleteFile(new File(name));
			}else{
				System.out.println("- sendEmail 不用生成附件");
			}
		}
		//内容
		String text = null;
		if(attachments != null && attachments.length > 0){
			text = "<br>提示：请查收相关附件！";
		}
		if(content == null || content.equals("")){
			content = "<br> 此为统一监管监控信息。"+text;	
		}
		String sendMsg = "Dear All : <br>"+content + "<br>该邮件为自动发送，请勿回复！\t谢谢!<br>";
		sender.setContent(sendMsg);
		sender.setSendTo(iaSendTos);
		sender.setSendCc(iaSendCcs);
		try{
			result = sender.send();
			if(result){
				succ = 1;
			}
		}catch(Exception e){
			e.printStackTrace();
			succ = 0;
			result = false;
		}finally{
			//邮件发送完毕,无论如何请删除临时ZIP文件和插入日志
			if(attachments != null && attachments[0] != null){
				fileService.deleteFile(attachments[0]);
			}
			insertEmailLog(tDefMonitor,result,all,succ);
		}
		return result;
	}
	
	private boolean insertEmailLog(TDefMonitor tDefMonitor, boolean result,int all,int succ){
		String msg = "事件："+tDefMonitor.getMonitorName()+"监控邮件发出:";
		if(result){
			msg += "成功";
		}else{
			msg += "失败";
		}
		TDefMonitorAction tdma = new TDefMonitorAction();
		tdma.setActionId(sequenceService.getBigSeqValByName("SEQ_T_DEF_MONITOR_ACTION"));
		tdma.setActionMsg(msg);
		tdma.setAllCount(Long.parseLong(""+all));
		tdma.setSuccCount(Long.parseLong(""+succ));
		tdma.setFailCount(Long.parseLong(""+(all-succ)));
		tdma.setMonitorType("SQL");
		tdma.setInsertTime(DateUtils.getDateTime());
		tdma.setLastModifyTime(DateUtils.getDateTime());
		tdma.setMonitorBuss(tDefMonitor.getMonitorCode());
		tdma.setMonitorId(tDefMonitor.getMonitorId());
		tdma.setStartTime(DateUtils.getDateTime());
		tdma.setOperator(UMMPContext.AUTO_USER);
		tDefMonitorActionMapper.insert(tdma);
		logger.info("ICP 自动提示邮件：事件包："+tDefMonitor.getMonitorName()+" 发送结果："+result);
		return true;
	}
	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.EmailSinoService#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext context) {
		// TODO Auto-generated method stub
		this.context = context;
	}
	/**
	 * 自动入住失败，则从新从指定容器中获取，用于SHELL脚本时使用
	 */
	private boolean initReFreash() {
		if (context == null) {
			System.out.println("无指定上下文容器");
			return false;
		}
		//TODO 重新初始化入住对象
		tDefNoticeMapper = context.getBean(TDefNoticeMapper.class);
		tDefNoticeAccountMapper = context.getBean(TDefNoticeAccountMapper.class);
		tDefNoticeAddMapper = context.getBean(TDefNoticeAddMapper.class);
		tDefNoticeMainMapper = context.getBean(TDefNoticeMainMapper.class);
		tDefNoticeMapper = context.getBean(TDefNoticeMapper.class);
		defUserMapper = context.getBean(DefUserMapper.class);
		monitorDeployService = context.getBean(MonitorDeployService.class);
		tDefCodeDictMapper = context.getBean(TDefCodeDictMapper.class);
		tDefMonitorActionMapper = context.getBean(TDefMonitorActionMapper.class);
		sequenceService = context.getBean(SequenceService.class);
		codeQueryService = context.getBean(CodeQueryService.class);
		fileService = context.getBean(FileService.class);
		tDefBagEventMapper = context.getBean(TDefBagEventMapper.class);
		return true;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.EmailSinoService#addParam(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public void addParam(String key, String value) {
		// TODO Auto-generated method stub
		param.put(key, value);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.EmailSinoService#clearParam()
	 */
	public void clearParam() {
		// TODO Auto-generated method stub
		param.clear();
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.EmailSinoService#removeParam(java.lang.String)
	 */
	public void removeParam(String key) {
		// TODO Auto-generated method stub
		param.remove(key);
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.EmailSinoService#setTitle(java.lang.String)
	 */
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		this.title = title;
	}

	/* (non-Javadoc)
	 * @see com.sinosoft.ummp.application.EmailSinoService#setContent(java.lang.String)
	 */

	public void setContent(String content) {
		// TODO Auto-generated method stub
		this.content = content;
	}
}
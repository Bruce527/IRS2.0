package com.sinosoft.ummp.interfaces.ses;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sinosoft.platform.core.application.CodeQueryService;
import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.ummp.application.CreateFileService;
import com.sinosoft.ummp.application.FilelUpService;
import com.sinosoft.ummp.application.SubmitService;
import com.sinosoft.ummp.application.UploadFileService;
import com.sinosoft.ummp.domain.mapper.TDocMainMapper;
import com.sinosoft.ummp.domain.model.TPrpLduserfile;



/**
 * 控制层
 * @author 
 * @date 2016-8-5 下午4:59:34
 * @company SINOSOFT
 */
@Controller
@RequestMapping("/sestj")
@SessionAttributes(Constants.USER_INFO_SESSION)
public class FileUpController {
	private static final Logger log = Logger.getLogger(FileUpController.class);
	
	@Autowired
	FilelUpService fileUpService;
	@Autowired
	TDocMainMapper tDocMainMapper;
	@Autowired
	private SubmitService submitService;
	@Autowired
	CreateFileService createFileService;
	@Autowired
	UploadFileService uploadFileService;
	@Autowired
	CodeQueryService codeQueryService;
	
	ParamPOJO  pojo;
	 
	
	
	//获取页面
	@RequestMapping(value = "/fileUpUrl", method = RequestMethod.GET)
	public String listFileUpUrl(ModelMap modelMap) {
		return "/ummp/ses/listFileUp";
	}
	
	//获得表单数据
	@RequestMapping(value = "/querylistFileUp", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> queryList(DataGridModel dgm, TPrpLduserfile tprplduserfile){
		return fileUpService.queryListInfoPages(dgm, tprplduserfile);
	}
	
	//生成文件 Txt zip,修改数据状态
	@RequestMapping(value = "/creatFile", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> creatFile(TPrpLduserfile tprplduserfile,ModelMap model, ParamPOJO pojo){
		Map<String, String> map = new HashMap<String, String>();
		// 调ADD 
		try{	
			 boolean creat=fileUpService.creatFile(pojo);//5条记录
			if(creat) {
			 map.put("mes", "操作成功");
			log.info("创建成功");
			}else{
				map.put("mes", "操作失败");
				log.info("创建失败");
				}
		} catch (Exception e) {
			map.put("mes", "操作失败");
			log.info("创建失败");
			e.printStackTrace();
			
		}	
		return map;
	}
	//上传
	@RequestMapping(value = "/xmlupFile", method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> uploadFile(@RequestParam("id") List<String> uid,ModelMap model){
		Map<String, String> map = new HashMap<String, String>();
		// 调ADD 
		try{
			for(String id : uid){
			
			fileUpService.uploadFile(id);//上传ZIP
		};
			map.put("mes", "操作成功");
		} catch (Exception e) {
			map.put("mes", "操作失败");
			e.printStackTrace();
		}
		return map;
	}
}

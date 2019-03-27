package com.sinosoft.ummp.interfaces.updownfile;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
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
import com.sinosoft.platform.core.util.CError;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.CreateFileService;
import com.sinosoft.ummp.application.DealReturnFileService;
import com.sinosoft.ummp.application.DownloadFileService;
import com.sinosoft.ummp.application.FilelUpService;
import com.sinosoft.ummp.application.QueryFileService;
import com.sinosoft.ummp.application.SubmitService;
import com.sinosoft.ummp.application.UploadFileService;
import com.sinosoft.ummp.domain.mapper.TDocMainMapper;
import com.sinosoft.ummp.domain.model.TDocMain;
import com.sinosoft.ummp.domain.model.TDocUpdown;

/**
 * 控制层
 * @author 
 * @date 2016-8-5 下午4:59:34
 * @company SINOSOFT
 */
@Controller
@RequestMapping("/updownfile")
@SessionAttributes(Constants.USER_INFO_SESSION)
public class UpDownController {
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
	QueryFileService queryFileService;
	@Autowired
	DownloadFileService downloadFileService;
	@Autowired
	DealReturnFileService dealRetrunFileService;
	@Autowired
	CodeQueryService codeQueryService;
	
	private ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * 请求到创建文件与上载
	 * @return
	 */
	@RequestMapping(value="/createUpload",method = RequestMethod.GET)
	public String createUpload(){
		return "ummp/updownfile/createUpload";
	}
	/**
	 * 获取数据处理页面
	 * @return
	 */
	@RequestMapping(value="/dealData",method = RequestMethod.GET)
	public String dealData(){
		return "ummp/updownfile/dealData";
	}
	/**
	 * 数据处理
	 * @author SendyLou
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/dealDataUrl",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> dealData(@RequestParam("list")String s,ModelMap model){
		Map<String, Object> map=new HashMap<String,Object>();
		Map<String, String> map1=new HashMap<String,String>();
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			LoginInfo loginInfo = (LoginInfo) model.get(Constants.USER_INFO_SESSION);
			ParamPOJO pojo = new ParamPOJO();
			map = list.get(0);
			pojo.setUserCode(loginInfo.getUserCode());
			pojo.setFileName((String)map.get("DOC_NAME"));
			boolean data = dealRetrunFileService.submitData(pojo);
			if(data){
				map1.put("msg", "数据处理成功!");
			}else{
				map1.put("msg", "数据处理失败!");
			}
		} catch (Exception e) {
			map1.put("msg", e.getMessage());
			//e.printStackTrace();
		}
		return map1;
	}
	/**
	 * 数据下载
	 * @author SendyLou
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/downFileUrl")
	@ResponseBody
	public Map<String,String> downFile(@RequestParam("list") String s,HttpServletResponse response,TDocUpdown tDocUpdown){
		Map<String, Object> map=new HashMap<String,Object>();
		Map<String, String> map1=new HashMap<String,String>();
		try {
			List<LinkedHashMap<String, Object>> list = objectMapper.readValue(s, List.class);
			map = list.get(0);
			tDocUpdown.setDocName((String)map.get("DOC_NAME"));
			tDocUpdown.setDocPath((String)map.get("DOC_PATH"));
			
			boolean data = downloadFileService.downloadFile(response, tDocUpdown);
			if(data){
				map1.put("msg", "数据下载成功!"); 
			}else{
				map1.put("msg", "数据下载失败!");
			}
		} catch (Exception e) {
			map1.put("msg",e.getMessage());
			//e.printStackTrace();
		}
		return map1;
	}
	/**
	 * 查询文件
	 * @author SendyLou
	 * @return
	 */
	@RequestMapping(value="/queryFileUrl",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> queryFile(ParamPOJO pojo,ModelMap model){
		Map<String,String> map=new HashMap<String,String>();
		try {
			LoginInfo loginInfo = (LoginInfo) model.get(Constants.USER_INFO_SESSION);
			
			boolean data = queryFileService.fileDownload(loginInfo,pojo);
			if(data){
				map.put("msg","查询同步文件成功!");
			}else{
				map.put("msg","查询同步文件失败!");
			}
		} catch (Exception e) {
			map.put("msg",e.getMessage());
			//e.printStackTrace();
		}
		return map;
	}
	
	/**
	 * 创建文件
	 * @param pojo
	 * @return
	 */
	@RequestMapping(value="/createFileUrl",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,String> createFile(ParamPOJO pojo,ModelMap model){
		Map<String,String> map = new HashMap<String,String>();
		try {
			LoginInfo loginInfo= (LoginInfo) model.get(Constants.USER_INFO_SESSION);
			pojo.setComId(new BigDecimal(1));//设置平台机构Id=1,保单登记
			pojo.setRealPath(codeQueryService.getSysPath("ROOT_PATH"));
			boolean data = createFileService.submitData(loginInfo, pojo);
			if(data){
				map.put("msg", "文件创建成功！");
			}else{
				map.put("msg", "文件创建失败！");
			}
		} catch (Exception e) {
			map.put("msg", e.getMessage());
			//e.printStackTrace();
		}
		return map;
	}
	/**
	 * 文件上载
	 * @param pojo
	 * @param batchNo
	 * @param batchType
	 * @return
	 */
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> upload(ParamPOJO pojo,BigDecimal id,ModelMap model){
		Map<String,String> map=new HashMap<String,String>();
		LoginInfo loginInfo = (LoginInfo)model.get(Constants.USER_INFO_SESSION);
		TDocMain key = tDocMainMapper.selectByPrimaryKey(id);
		String realPath = codeQueryService.getSysPath("ROOT_PATH");
		pojo.setBatchNo(key.getBatchNo());
		pojo.setBatchType(key.getSubBussType());
		pojo.setRealPath(realPath);
		boolean flag = false;
		try {
			UploadFileService.cErrors.clearErrors();
			flag = uploadFileService.uploadFile(loginInfo, pojo);
			if(flag){
				map.put("msg", "上载成功！");
			}else{
				CError cError = UploadFileService.cErrors.getError(0);
				if(cError.errorType != null && cError.errorType.equals("0")){
					map.put("msg", cError.errorMessage);
				}else{
					map.put("msg", "上载失败！");
				}
			}
		} catch (Exception e) {
			map.put("msg", "上载失败："+e.getMessage());
		}
		return map;
	}
	/**
	 * 上传文件
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/queryCreateFile",method =  RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listFile(DataGridModel model,String transType,String batchNo,String stateFlag){
		
		return submitService.listFile(model,transType,batchNo,stateFlag);
	}
	/**
	 * 查询已下载的文件
	 * @return
	 */
	@RequestMapping(value="/queryDownloadFile",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> queryDownloadFile(DataGridModel model,ParamPOJO pojo){
		
		return fileUpService.queryDownloadFile(model,pojo);
	}
}

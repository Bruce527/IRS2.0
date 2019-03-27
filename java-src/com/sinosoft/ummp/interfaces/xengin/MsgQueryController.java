/**
 * 
 */
package com.sinosoft.ummp.interfaces.xengin;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.ummp.application.MsgConfigService;
import com.sinosoft.ummp.application.MsgQueryService;
import com.sinosoft.ummp.domain.pojo.MsgQueryPOJO;

/**
 * @author Darker.Wang
 * @date 2016-6-28 下午9:58:30
 * 报文规则查询，修改
 */
@Controller
@RequestMapping("/mquery")
public class MsgQueryController {

	private static Logger logger = Logger.getLogger(MsgQueryController.class);
	@Autowired
	MsgQueryService msgQueryService;
	@Autowired
	MsgConfigService msgConfigService;
	/**
	 * 
	 */
	public MsgQueryController() {
		// TODO Auto-generated constructor stub
	}
	@RequestMapping(value="/msgQueryUrl",method = RequestMethod.GET)
	public String msgQueryUrl(){
		return "ummp/xengin/msgQueryInput";
	}
	/**
	 * 基本信息查询
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/msgBaseInfoQuery",method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Object> msgBaseInfoQuery(Integer type, MsgQueryPOJO pojo,DataGridModel dgm){
		Map<String, Object> result = new HashMap<String, Object>(2);
		int total = msgQueryService.countBaseMsg(pojo, dgm);
		List list = msgQueryService.queryBaseMsg(pojo,dgm);
		result.put("total", total);
		result.put("rows", list);
		return result;
	}
	
	/**
	 * 删除报文规则
	 * @param bussIds
	 * @return
	 */
	@RequestMapping(value="/deleteMsgEngin",method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> deleteMsgEngin(@RequestParam("bussId") List<BigDecimal> bussIds){
		Map<String,String> map = new HashMap<String,String>();
		logger.debug("删除报文规则： "+bussIds);
		try{
			for(BigDecimal bussId : bussIds){
				if(msgQueryService.checkMsgEnginIsUsing(bussId)){
					map.put("msg","该报文规则正在被使用，不能进行修改。请稍候重试！");
					return map;
				}
				logger.debug("正在删除报文规则： "+bussId);
				msgConfigService.deleteMsgEngen(bussId);
			}	
			map.put("msg", "success");
		}catch(Exception e){
			e.printStackTrace();
			map.put("msg", "删除报文规则异常，请重试");
		}
		return map;
	}
	@RequestMapping(value="/updateMsgEngin",method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String,String> updateMsgEngin(@RequestParam BigDecimal bussId,@RequestParam String bussCode){
		Map<String,String> map = new HashMap<String,String>();
		logger.debug("修改报文规则： "+bussId);
		try{
			if(msgQueryService.checkMsgEnginIsUsing(bussId)){
				map.put("msg","该报文规则正在被使用，不能进行修改。请稍候重试！");
				return map;
			}
			boolean result = msgQueryService.pushMsgEngin4Update(bussId);
			if(result){
				map.put("msg", "success");
			}else{
				map.put("msg", "修改报文规则异常，请检查是否该规则正在使用或者重试！");
			}
		}catch(Exception e){
			e.printStackTrace();
			map.put("msg", "修改报文规则异常，请重试");
		}finally{
			
		}
		return map;
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/reEffect",method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map reEffect(BigDecimal bussId){
		return msgQueryService.reEffect(bussId);
	}
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/loseEffect",method = RequestMethod.POST,produces="application/json; charset=utf-8")
	@ResponseBody
	public Map loseEffect(BigDecimal bussId){
		return msgQueryService.loseEffect(bussId);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

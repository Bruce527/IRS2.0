package com.sinosoft.ummp.interfaces.submit;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.Constants;
import com.sinosoft.platform.core.util.DataGridModel;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.SubmitService;
import com.sinosoft.ummp.domain.model.TDefActionTrace;

/**
 * 报送控制器
 * @author Darker.Wang
 * @date 2016-7-4 下午4:21:40
 */
@Controller
@RequestMapping(value="/submit")
public class SubmitController {
	@Autowired
	private SubmitService submitService;



	/**
	 * 
	 */
	public SubmitController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 跳转至
	 * 手动执行报送页面
	 * @return
	 */
	@RequestMapping(value="/handSubmit",method=RequestMethod.GET)
	public String handSubmit(){
		return "ummp/submit/handSubmit";
	}
	
	/**
	 * 手动执行报送
	 * @param pojo
	 * @param comId
	 * @return
	 */
	@RequestMapping(value="/handExecuteSubmit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String,String> handExecuteSubmit(ParamPOJO pojo,BigDecimal comId,HttpServletRequest request){
		String startDate = pojo.getStartDate();
		pojo.setStartDate(startDate.replace("-", ""));
		System.out.println(pojo.getStartDate());
		String endDate = pojo.getEndDate();
		pojo.setEndDate(endDate.replace("-", ""));
		System.out.println(pojo.getEndDate());
		System.out.println(pojo.getBussNo());
		Map<String,String> map = new HashMap<String,String>();
		try {
			//赋值用户信息
			LoginInfo loginInfo = (LoginInfo)request.getSession().getAttribute(Constants.USER_INFO_SESSION);
			pojo.setUserCode(loginInfo.getUserCode());
			//报送开始
			map = this.submitService.submit(comId, pojo);
			return map;
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg","业务："+ pojo.getBussType()+" 报送失败");
		}
		return map;
	}
	
	@RequestMapping(value="/listHandSubmit",method=RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> listHand(DataGridModel model,HttpServletRequest request,String actionNos,TDefActionTrace tDefActionTrace){
		return submitService.listHand(model,actionNos, tDefActionTrace);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

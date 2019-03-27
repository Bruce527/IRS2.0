/**
 * 
 */
package com.test;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.platform.core.util.LoginInfo;
import com.sinosoft.ummp.application.CreateFileService;
import com.sinosoft.ummp.application.UploadFileService;

/**
 * @author Darker.Wang
 * @date 2016-9-29 上午10:03:42
 * @company SINOSOFT
 */
public class CIIMFileTest extends BaseTest {

	@Autowired
	CreateFileService sreateFileService;
	@Autowired
	UploadFileService uploadFileService;
	@Test
	public void ciimTest() {
		LoginInfo loginInfo = new LoginInfo();
		loginInfo.setUserCode("TEST-USER");
		ParamPOJO pojo = new ParamPOJO();
		pojo.setStartDate("2015-10-10");
		pojo.setEndDate("2015-10-10");
		pojo.setBussFlag("2");
		pojo.setComId(new BigDecimal("1"));
		// TODO 1、创建文件
		try {
			sreateFileService.submitData(loginInfo, pojo);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO 2、上载文件
		pojo.setBatchNo("000031LINC0000000882");
		pojo.setRealPath("D:/root/icp");
		pojo.setBatchType("INC");
		try {
			uploadFileService.uploadFile(loginInfo, pojo);
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

package com.sinosoft.ummp.application;


import java.util.Map;

import com.sinosoft.platform.core.domain.pojo.ParamPOJO;
import com.sinosoft.platform.core.util.DataGridModel;

import com.sinosoft.ummp.domain.model.TPrpLduserfile;




public interface FilelUpService {
	public boolean creatFile (ParamPOJO pojo);
	public boolean uploadFile(String  id);
	public Map<String, Object> queryListInfoPages(DataGridModel dgm,TPrpLduserfile tPrpLduserfile);
	public Map<String, Object> queryDownloadFile(DataGridModel model,ParamPOJO pojo);
	

}

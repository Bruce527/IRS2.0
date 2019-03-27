package com.sinosoft.platform.quartz.application;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sinosoft.ummp.task.job.impl.SHIASubmitC01Job;
import com.sinosoft.ummp.task.job.impl.SHIASubmitC04Job;

@Service("ShiaClaSendService")
public class ShiaClaSendService
  implements Serializable, ApplicationContextAware
{
  private static ApplicationContext context = null;
  private static final long serialVersionUID = 1L;
  private static final Logger logger = LoggerFactory.getLogger(SysnPolSendService.class);

  public void setApplicationContext(ApplicationContext applicationContext)
    throws BeansException
  {
    context = applicationContext;
    logger.debug("- ApplicationContext: " + context);
  }

  public boolean ClaSysnSend() {
    boolean result = true;

    SHIASubmitC01Job C01 = new SHIASubmitC01Job();
    try {
      result = C01.excute();
      if (!result) {
        System.out.println("----个险理赔信息同步报送批处理失败----");
      }
    }
    catch (Exception e)
    {
      System.out.println("个险理赔信息同步报送批处理异常");
      e.printStackTrace();
    }

    SHIASubmitC04Job C04 = new SHIASubmitC04Job();
    try {
      result = C04.excute();
      if (!result) {
        System.out.println("----团险理赔信息同步报送批处理失败----");
      }
    }
    catch (Exception e)
    {
      System.out.println("团险理赔信息同步报送批处理异常");
      e.printStackTrace();
    }
    return result;
  }
}
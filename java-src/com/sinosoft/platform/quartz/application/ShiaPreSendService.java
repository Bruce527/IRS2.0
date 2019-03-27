package com.sinosoft.platform.quartz.application;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sinosoft.ummp.task.job.impl.SHIAT01Job;

@Service("ShiaPreSendService")
public class ShiaPreSendService
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

  public boolean PreSysnSend() {
    boolean result = true;

    SHIAT01Job T01 = new SHIAT01Job();
    try {
      result = T01.excute();
      if (!result) {
        System.out.println("----保费信息同步报送批处理失败----");
      }
    }
    catch (Exception e)
    {
      System.out.println("保费信息同步报送批处理异常");
    }
    return result;
  }
}
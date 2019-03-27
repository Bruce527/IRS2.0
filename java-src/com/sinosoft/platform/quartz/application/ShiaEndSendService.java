package com.sinosoft.platform.quartz.application;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

import com.sinosoft.ummp.task.job.impl.SHIAE0101Job;
import com.sinosoft.ummp.task.job.impl.SHIAE0102Job;

@Service("ShiaEndSendService")
public class ShiaEndSendService
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

  public boolean EndSysnSend() {
    boolean result = true;

    SHIAE0102Job E0102 = new SHIAE0102Job();
    try {
      result = E0102.excute();
      if (!result) {
        System.out.println("----\u4E2A\u5355\u4FDD\u5168\u4FE1\u606F\u540C\u6B65\u62A5\u9001\u6279\u5904\u7406\u5931\u8D25----");
      }
    }
    catch (Exception e)
    {
      System.out.println("\u4E2A\u5355\u4FDD\u5168\u4FE1\u606F\u540C\u6B65\u62A5\u9001\u6279\u5904\u7406\u5F02\u5E38");
    }

    SHIAE0101Job E0101 = new SHIAE0101Job();
    try {
      result = E0101.excute();
      if (!result) {
        System.out.println("----\u56E2\u5355\u4FDD\u5168\u4FE1\u606F\u540C\u6B65\u62A5\u9001\u6279\u5904\u7406\u5931\u8D25----");
      }
    }
    catch (Exception e)
    {
      System.out.println("\u56E2\u5355\u4FDD\u5168\u4FE1\u606F\u540C\u6B65\u62A5\u9001\u6279\u5904\u7406\u5F02\u5E38");
    }
    return result;
  }
}
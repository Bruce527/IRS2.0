/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package com.sinosoft.platform.core.application.impl;
/*****************************************************
 * HISTORY
 * 
 * 2013/04/11 yangzd 创建文件
 * 
 * YYYY/MM/DD ----- 增加新功能
 * 
 *****************************************************/
import org.jbpm.api.jpdl.DecisionHandler;
import org.jbpm.api.model.OpenExecution;

public class ContentEvaluation implements DecisionHandler {

  private static final long serialVersionUID = 1L;

  public String decide(OpenExecution execution) {
    String content = (String) execution.getVariable("content");
    if (content.equals("autocheck-yes")) {
      return "yes:decision-6-state-7*decision-6-state-7-p0";
    }else if(content.equals("autocheck-no")){
    	return "no:decision-6-state-8*decision-6-state-8-p0";
    }else if(content.equals("check-yes")){
    	return "yes:decision-9-state-7*decision-9-state-7-p0";
    }else{
    	return "no:decision-9-state-4*decision-9-state-4-p0";
    }
  }
}
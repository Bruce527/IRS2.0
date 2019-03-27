package com.sinosoft.ummp.application;

import com.sinosoft.platform.core.exception.CoreException;
import com.sinosoft.ummp.domain.model.TDefMonitor;

public interface EmailSinoService {
	
	public boolean sendEmail(TDefMonitor tDefMonitor) throws CoreException;

}
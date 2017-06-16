package com.etc.fms.check;

import javax.annotation.Resource;

import org.junit.Test;

import com.etc.fms.check.entity.Checked;
import com.etc.fms.check.service.ICheckedService;

public class check_test {

	@Resource(name = "checkedService")
	private ICheckedService checkedService;

	public ICheckedService getCheckedService() {
		return checkedService;
	}

	public void setCheckedService(ICheckedService checkedService) {
		this.checkedService = checkedService;
	}

	@Test
	public void test() {
		
	
	}
}

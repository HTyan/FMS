package com.etc.fms.expense.controller;
/**
 * Ԥ�������
 */
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.etc.fms.expense.entity.Pledge;
import com.etc.fms.expense.service.IPledgeService;
import com.sun.istack.internal.logging.Logger;

@Controller
@RequestMapping("pledgeapi")
public class PledgeController {
	Logger logger = Logger.getLogger(PledgeController.class);
	//ע��service
	@Resource(name="pledgeservice")
	public IPledgeService pledgeservice;

	public IPledgeService getPledgeservice() {
		return pledgeservice;
	}

	public void setPledgeservice(IPledgeService pledgeservice) {
		this.pledgeservice = pledgeservice;
	}
	
	@RequestMapping(value = "showPledge", method = RequestMethod.GET)
	@ResponseBody
	// ���ص���json����
	public Map addPledge(Pledge pledge) {

		logger.info("info SmallType query name :" + pledge);
		System.out.println("pledge:"+pledge);
		pledgeservice.addPledge(pledge);
		
		return null;

		
	}
}

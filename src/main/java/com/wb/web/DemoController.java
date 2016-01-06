package com.wb.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.model.DemoModel;
import com.wb.service.IDemoService;

@Controller
@RequestMapping(value="demo")
public class DemoController {
	
	@Autowired
	private IDemoService demoService;

	@RequestMapping(value="getObject")
	@ResponseBody
	public Object getObject() {
		List<DemoModel> demoList = demoService.getObject();
		return demoList;
	}
	
	@RequestMapping(value="getObjectById")
	@ResponseBody
	public Object getObjectById(int id) {
		DemoModel demoModel = demoService.getDemoListById(id);
		return demoModel;
	}
	
	@RequestMapping(value="queryDemoList")
	@ResponseBody
	public Object queryDemoList() {
		List<DemoModel> demoList = demoService.getDemoList();
		return demoList;
	}
}

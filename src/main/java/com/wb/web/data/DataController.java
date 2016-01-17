package com.wb.web.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wb.service.data.DataService;

@Controller
@RequestMapping(value="data")
public class DataController {

	@Autowired
	private DataService dataService;
	
	@RequestMapping(value="getData")
	@ResponseBody
	public Object getData() {
		return dataService.queryDemoList();
	}
}

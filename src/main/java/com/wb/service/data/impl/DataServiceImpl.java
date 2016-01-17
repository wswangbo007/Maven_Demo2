package com.wb.service.data.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wb.model.DemoModel;
import com.wb.service.IDemoService;
import com.wb.service.data.DataService;

/**
 * 数据实现类
 * @author wangB
 */
@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private IDemoService demoService;
	
	/**
	 * 获取DemoModel对象的集合
	 */
	@Override
	public List<DemoModel> queryDemoList() {
		List<DemoModel> oldDemoList = demoService.getDemoList();
		return oldDemoList;
	}

}
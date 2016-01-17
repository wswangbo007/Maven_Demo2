package com.wb.service.data;

import java.util.List;

import com.wb.model.DemoModel;

/**
 * 数据接口
 * @author wb
 */
public interface DataService {
	
	/**
	 * 获取DemoModel对象的集合
	 * @return List
	 */
	public abstract List<DemoModel> queryDemoList();
}

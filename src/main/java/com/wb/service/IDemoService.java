package com.wb.service;

import java.util.List;

import com.wb.model.DemoModel;

public interface IDemoService {

	public List<DemoModel> getObject();
	
	public DemoModel getDemoListById(int id);
	
	List<DemoModel> getDemoList();
	
	public void deleteObject();
}

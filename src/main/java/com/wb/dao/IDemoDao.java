package com.wb.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.wb.model.DemoModel;

@Repository
public interface IDemoDao {
	
	public List<DemoModel> findDemoList();
	
	public DemoModel getDemoListById(int id);
	
	List<DemoModel> queryThreadDemoList(Map<String,Integer> paramMap);
}

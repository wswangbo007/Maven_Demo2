package com.wb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.ehcache.CacheManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.wb.dao.IDemoDao;
import com.wb.model.DemoModel;

@Service
public class DemoService implements IDemoService {
	
	private IDemoDao demoDao;
	
	/**
	 * 
	 * @param demoDao
	 */
	@Autowired
	public void setDemoDao(IDemoDao demoDao) {
		this.demoDao = demoDao;
	}
	
	public List<DemoModel> getObject() {
		List<DemoModel> demoList = demoDao.findDemoList();
		return demoList;
	}
	
	@Cacheable(value="QY_api_productTop",key="'getDemoListByid'+#id")
	public DemoModel getDemoListById(int id) {
		CacheManager.getCacheManager("QY_api_productTop");
		DemoModel demoModel = demoDao.getDemoListById(id);
		return demoModel;
	}
	
	private int index = 0;
	
	public List<DemoModel> getDemoList() {
		List<DemoModel> demoList = new ArrayList<DemoModel>();
		try {
			Map<String,Integer> paramMap = new HashMap<String,Integer>();
			int page = 1000;
			paramMap.put("index", index);paramMap.put("page", page);
			ThreadUtil threadUtil = new ThreadUtil(paramMap, demoList,demoDao); 
			for(int i = 0;i < 10;i++) {
				index = i * page;
				paramMap.put("index", index);
				System.out.println("MNAP : " + paramMap.toString());
				Thread th = new Thread(threadUtil);
				th.start();
				try {
					th.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return demoList;
	}
	
	@Override
	public void deleteObject() {
		
	}
	
}
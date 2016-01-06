package com.wb.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wb.dao.IDemoDao;
import com.wb.model.DemoModel;

@Component("threadUitil")
public class ThreadUtil implements Runnable {
	
	private List<DemoModel> demoList;
	
	private IDemoDao demoDao;
	
	private Map<String,Integer> paramMap;

	public List<DemoModel> getDemoList() {
		return demoList;
	}

	public Map<String, Integer> getParamMap() {
		return paramMap;
	}

	public void setParamMap(Map<String, Integer> paramMap) {
		this.paramMap = paramMap;
	}

	public void setDemoList(List<DemoModel> demoList) {
		this.demoList = demoList;
	}

	public IDemoDao getDemoDao() {
		return demoDao;
	}

	@Autowired
	public void setDemoDao(IDemoDao demoDao) {
		this.demoDao = demoDao;
	}

	public ThreadUtil() {
		// TODO Auto-generated constructor stub
	}

	public ThreadUtil(Map<String,Integer> paramMap,List<DemoModel> demoList,IDemoDao demoDao) {
		super();
		this.paramMap = paramMap;
		this.demoList = demoList;
		this.demoDao = demoDao;
	}

	public void run() {
		// TODO Auto-generated method stub
		List<DemoModel> tempDemoList = demoDao.queryThreadDemoList(paramMap);
//		DemoModel demo = new DemoModel();
//		demo.setId(paramMap.get("index"));
//		List<DemoModel> demoLists = new ArrayList<DemoModel>();
//		demoLists.add(demo);
//		System.out.println(Thread.currentThread().getName() + "   map : " + paramMap.toString());
		demoList.addAll(tempDemoList);
	}

	@Override
	public String toString() {
		return "ThreadUtil [demoList=" + demoList + ", demoDao=" + demoDao
				+ ", paramMap=" + paramMap.toString() + "]";
	}
	
}

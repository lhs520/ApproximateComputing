package com.ApproximateComputing.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApproximateComputing.dao.PathPlaningDao;
import com.ApproximateComputing.po.ImageRecognition;
import com.ApproximateComputing.po.PathPlaning;
import com.ApproximateComputing.service.PathPlaningService;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Service("pathPlaningService")
public class PathPlaningServiceImpl implements PathPlaningService {
	@Autowired
	private PathPlaningDao pathPlaningDao;
	
	//6个线程的固定容量线程池
	private static ExecutorService executor=Executors.newFixedThreadPool(6);
	
	@Override
	@Transactional
	public CommonDTO createMultiPathPlaning(List<PathPlaning> list) {
		pathPlaningDao.createMultiPathPlaning(list);
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		return result;
	}

	@Override
	public List<PathPlaning> getAll() {
		return pathPlaningDao.getAll();
	}

	@Override
	@Transactional
	public CommonDTO createMultiPathPlaningByCallable(List<PathPlaning> list) {
		Future<Integer>listNumber=executor.submit(new PathPlaningCallable(list));
		Integer number;
		try {
			number = listNumber.get();
			//成功时
			if(number.intValue()!= -1){
//				System.out.println("这个线程提交成功！");
				CommonDTO result=new CommonDTO(Result.SUCCESS);
				return result;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		//失败时返回失败结果
//		System.out.println("这个线程提交失败！");
		CommonDTO result=new CommonDTO(Result.FAILURE);
		return result;
	}
	
	//多线程Callable执行
	private class PathPlaningCallable implements Callable<Integer>{
		private List<PathPlaning>list;
		
		public PathPlaningCallable(List<PathPlaning>list) {
			this.list=list;
		}
		
		@Override
		public Integer call() throws Exception {
			try {
				pathPlaningDao.createMultiPathPlaning(list);
				return 0;
			} catch (Exception e) {
				e.printStackTrace();
				return -1;
			}
		}
		
	}
	
	@Override
	public CommonDTO selectAllAvg() {
		long current=System.currentTimeMillis();
		List<Float> resultList=new ArrayList<Float>();
		Float avg=pathPlaningDao.selectAvg(new Float(0),new Integer(0));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(10),new Integer(0));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(25),new Integer(0));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(50),new Integer(0));
		resultList.add(avg);
		
		avg=pathPlaningDao.selectAvg(new Float(0),new Integer(500));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(10),new Integer(500));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(25),new Integer(500));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(50),new Integer(500));
		resultList.add(avg);
		
		avg=pathPlaningDao.selectAvg(new Float(0),new Integer(1000));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(10),new Integer(1000));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(25),new Integer(1000));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(50),new Integer(1000));
		resultList.add(avg);
		
		avg=pathPlaningDao.selectAvg(new Float(0),new Integer(1500));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(10),new Integer(1500));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(25),new Integer(1500));
		resultList.add(avg);
		avg=pathPlaningDao.selectAvg(new Float(50),new Integer(1500));
		resultList.add(avg);
		
		System.out.println(resultList.toString());
		System.out.println(System.currentTimeMillis()-current);
		
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		result.setResult(resultList);
		
		return result;
	}

}

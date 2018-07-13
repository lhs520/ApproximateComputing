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

import com.ApproximateComputing.dao.PhotoDecodeDao;
import com.ApproximateComputing.po.PathPlaning;
import com.ApproximateComputing.po.PhotoDecode;
import com.ApproximateComputing.service.PhotoDecodeService;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Service("photoDecodeService")
public class PhotoDecodeServiceImpl implements PhotoDecodeService {
	@Autowired
	private PhotoDecodeDao photoDecodeDao;
	
	//6个线程的固定容量线程池
	private static ExecutorService executor=Executors.newFixedThreadPool(6);
	
	@Override
	@Transactional
	public CommonDTO createMultiPhotoDecode(List<PhotoDecode> list) {
		photoDecodeDao.createMultiPhotoDecode(list);
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		return result;
	}
	@Override
	public List<PhotoDecode> getAll() {
		return photoDecodeDao.getAll();
	}
	@Override
	@Transactional
	public CommonDTO createMultiPhotoDecodeByCallable(List<PhotoDecode> list) {
		Future<Integer>listNumber=executor.submit(new PhotoDecodeCallable(list));
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
	private class PhotoDecodeCallable implements Callable<Integer>{
		private List<PhotoDecode>list;
		
		public PhotoDecodeCallable(List<PhotoDecode>list) {
			this.list=list;
		}
		
		@Override
		public Integer call() throws Exception {
			try {
				photoDecodeDao.createMultiPhotoDecode(list);
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
		Float avg=photoDecodeDao.selectAvg(new Float(0),new Integer(0));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(10),new Integer(0));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(25),new Integer(0));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(50),new Integer(0));
		resultList.add(avg);
		
		avg=photoDecodeDao.selectAvg(new Float(0),new Integer(500));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(10),new Integer(500));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(25),new Integer(500));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(50),new Integer(500));
		resultList.add(avg);
		
		avg=photoDecodeDao.selectAvg(new Float(0),new Integer(1000));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(10),new Integer(1000));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(25),new Integer(1000));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(50),new Integer(1000));
		resultList.add(avg);
		
		avg=photoDecodeDao.selectAvg(new Float(0),new Integer(1500));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(10),new Integer(1500));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(25),new Integer(1500));
		resultList.add(avg);
		avg=photoDecodeDao.selectAvg(new Float(50),new Integer(1500));
		resultList.add(avg);
		
		System.out.println(resultList.toString());
		System.out.println(System.currentTimeMillis()-current);
		
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		result.setResult(resultList);
		
		return result;
	}

}

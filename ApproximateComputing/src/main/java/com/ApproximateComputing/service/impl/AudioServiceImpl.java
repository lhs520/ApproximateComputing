package com.ApproximateComputing.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApproximateComputing.dao.AudioDao;
import com.ApproximateComputing.po.Audio;
import com.ApproximateComputing.service.AudioService;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Service("audioService")
public class AudioServiceImpl implements AudioService{
	@Autowired
	private AudioDao audioDao;
	//6个线程的固定容量线程池
	private static ExecutorService executor=Executors.newFixedThreadPool(6);
	
	@Override
	@Transactional
	//多线程 批量增加
	public CommonDTO createMultiAudioByCallable(List<Audio> list) {
		Future<Integer>listNumber=executor.submit(new AudioCallable(list));
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
	
/*	@Override
	@Transactional
	//多线程 批量增加,此函数无用
	public CommonDTO createMultiAudioByRunnable(List<Audio> list) {
		try {
			executor.execute(new AudioRunnable(list));
		} catch (Exception e) {
			e.printStackTrace();
			CommonDTO result=new CommonDTO(Result.FAILURE);
			return result;
		}
		
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		return result;
	}*/
	
	@Override
	@Transactional
	public CommonDTO createMultiAudio(List<Audio> list) {
		audioDao.createMultiAudio(list);
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		return result;
	}

	@Override
	public List<Audio> getAll() {
		return audioDao.getAll();
	}
	
	//多线程Callable执行
	private class AudioCallable implements Callable<Integer>{
		private List<Audio>list;
		
		public AudioCallable(List<Audio>list) {
			this.list=list;
		}
		
		@Override
		public Integer call() throws Exception {
			try {
				audioDao.createMultiAudio(list);
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
		Float avg=audioDao.selectAvg(new Float(0),new Integer(0));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(10),new Integer(0));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(25),new Integer(0));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(50),new Integer(0));
		resultList.add(avg);
		
		avg=audioDao.selectAvg(new Float(0),new Integer(500));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(10),new Integer(500));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(25),new Integer(500));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(50),new Integer(500));
		resultList.add(avg);
		
		avg=audioDao.selectAvg(new Float(0),new Integer(1000));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(10),new Integer(1000));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(25),new Integer(1000));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(50),new Integer(1000));
		resultList.add(avg);
		
		avg=audioDao.selectAvg(new Float(0),new Integer(1500));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(10),new Integer(1500));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(25),new Integer(1500));
		resultList.add(avg);
		avg=audioDao.selectAvg(new Float(50),new Integer(1500));
		resultList.add(avg);
		
		System.out.println(resultList.toString());
		System.out.println(System.currentTimeMillis()-current);
		
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		result.setResult(resultList);
		
		return result;
	}



	
/*	private class AudioRunnable implements Runnable{
		private List<Audio>list;
		
		public AudioRunnable(List<Audio>list) {
			this.list=list;
		}
		@Override
		public void run() {
			audioDao.createMultiAudio(list);
			
		}
		
	}*/

}

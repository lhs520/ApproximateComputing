package com.ApproximateComputing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApproximateComputing.dao.VideoDao;
import com.ApproximateComputing.po.Video;
import com.ApproximateComputing.service.VideoService;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Service("videoService")
public class VideoServiceImpl implements VideoService {
	@Autowired
	private VideoDao videoDao;
	@Override
	@Transactional
	public CommonDTO createMultiVideo(List<Video> list) {
		videoDao.createMultiVideo(list);
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		return result;
	}
	@Override
	public List<Video> getAll() {
		return videoDao.getAll();
	}
	
	@Override
	public CommonDTO selectAllAvg() {
		long current=System.currentTimeMillis();
		List<Float> resultList=new ArrayList<Float>();
		Float avg=videoDao.selectAvg(new Float(0),new Integer(0));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(10),new Integer(0));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(25),new Integer(0));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(50),new Integer(0));
		resultList.add(avg);
		
		avg=videoDao.selectAvg(new Float(0),new Integer(500));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(10),new Integer(500));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(25),new Integer(500));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(50),new Integer(500));
		resultList.add(avg);
		
		avg=videoDao.selectAvg(new Float(0),new Integer(1000));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(10),new Integer(1000));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(25),new Integer(1000));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(50),new Integer(1000));
		resultList.add(avg);
		
		avg=videoDao.selectAvg(new Float(0),new Integer(1500));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(10),new Integer(1500));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(25),new Integer(1500));
		resultList.add(avg);
		avg=videoDao.selectAvg(new Float(50),new Integer(1500));
		resultList.add(avg);
		
		System.out.println(resultList.toString());
		System.out.println(System.currentTimeMillis()-current);
		
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		result.setResult(resultList);
		
		return result;
	}

}

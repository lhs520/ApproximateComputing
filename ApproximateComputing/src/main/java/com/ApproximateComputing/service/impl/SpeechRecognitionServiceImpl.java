package com.ApproximateComputing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApproximateComputing.dao.SpeechRecognitionDao;
import com.ApproximateComputing.po.SpeechRecognition;
import com.ApproximateComputing.service.SpeechRecognitionService;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Service("speechRecognitionService")
public class SpeechRecognitionServiceImpl implements SpeechRecognitionService {
	@Autowired
	private SpeechRecognitionDao speechRecognitionDao;
	
	@Override
	@Transactional
	public CommonDTO createMultiSpeechRecognition(List<SpeechRecognition> list) {
		speechRecognitionDao.createMultiSpeechRecognition(list);
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		return result;
	}

	@Override
	public List<SpeechRecognition> getAll() {
		return speechRecognitionDao.getAll();
	}
	
	@Override
	public CommonDTO selectAllAvg() {
		long current=System.currentTimeMillis();
		List<Float> resultList=new ArrayList<Float>();
		Float avg=speechRecognitionDao.selectAvg(new Float(0),new Integer(0));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(10),new Integer(0));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(25),new Integer(0));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(50),new Integer(0));
		resultList.add(avg);
		
		avg=speechRecognitionDao.selectAvg(new Float(0),new Integer(500));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(10),new Integer(500));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(25),new Integer(500));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(50),new Integer(500));
		resultList.add(avg);
		
		avg=speechRecognitionDao.selectAvg(new Float(0),new Integer(1000));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(10),new Integer(1000));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(25),new Integer(1000));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(50),new Integer(1000));
		resultList.add(avg);
		
		avg=speechRecognitionDao.selectAvg(new Float(0),new Integer(1500));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(10),new Integer(1500));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(25),new Integer(1500));
		resultList.add(avg);
		avg=speechRecognitionDao.selectAvg(new Float(50),new Integer(1500));
		resultList.add(avg);
		
		System.out.println(resultList.toString());
		System.out.println(System.currentTimeMillis()-current);
		
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		result.setResult(resultList);
		
		return result;
	}

}

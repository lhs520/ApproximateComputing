package com.ApproximateComputing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApproximateComputing.dao.TSPDao;
import com.ApproximateComputing.po.TSP;
import com.ApproximateComputing.service.TSPService;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Service("tSPService")
public class TSPServiceImpl implements TSPService {
	@Autowired
	private TSPDao tSPDao;
	@Override
	@Transactional
	public CommonDTO createMultiTSP(List<TSP> list) {
		tSPDao.createMultiTSP(list);
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		return result;
	}
	@Override
	public List<TSP> getAll() {
		return tSPDao.getAll();
	}
	
	@Override
	public CommonDTO selectAllAvg() {
		long current=System.currentTimeMillis();
		List<Float> resultList=new ArrayList<Float>();
		Float avg=tSPDao.selectAvg(new Float(0),new Integer(0));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(10),new Integer(0));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(25),new Integer(0));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(50),new Integer(0));
		resultList.add(avg);
		
		avg=tSPDao.selectAvg(new Float(0),new Integer(500));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(10),new Integer(500));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(25),new Integer(500));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(50),new Integer(500));
		resultList.add(avg);
		
		avg=tSPDao.selectAvg(new Float(0),new Integer(1000));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(10),new Integer(1000));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(25),new Integer(1000));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(50),new Integer(1000));
		resultList.add(avg);
		
		avg=tSPDao.selectAvg(new Float(0),new Integer(1500));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(10),new Integer(1500));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(25),new Integer(1500));
		resultList.add(avg);
		avg=tSPDao.selectAvg(new Float(50),new Integer(1500));
		resultList.add(avg);
		
		System.out.println(resultList.toString());
		System.out.println(System.currentTimeMillis()-current);
		
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		result.setResult(resultList);
		
		return result;
	}

}

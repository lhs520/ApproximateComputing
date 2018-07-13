package com.ApproximateComputing.service;

import java.util.List;

import com.ApproximateComputing.po.TSP;
import com.ApproximateComputing.vo.CommonDTO;

public interface TSPService {
	public CommonDTO createMultiTSP(List<TSP>list);
	public List<TSP> getAll();
	public CommonDTO selectAllAvg();
}

package com.ApproximateComputing.dao;

import java.util.List;

import com.ApproximateComputing.po.TSP;

public interface TSPDao {
	public void createMultiTSP(List<TSP>list);
	public List<TSP> getAll();
	public Float selectAvg(Float qualityLossRatio,Integer time);
}

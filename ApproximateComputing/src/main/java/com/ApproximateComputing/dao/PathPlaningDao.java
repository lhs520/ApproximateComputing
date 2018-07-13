package com.ApproximateComputing.dao;

import java.util.List;

import com.ApproximateComputing.po.PathPlaning;

public interface PathPlaningDao {
	public void createMultiPathPlaning(List<PathPlaning>list);
	public List<PathPlaning> getAll();
	public Float selectAvg(Float qualityLossRatio,Integer time);
}

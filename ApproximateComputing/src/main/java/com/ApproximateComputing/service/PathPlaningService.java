package com.ApproximateComputing.service;

import java.util.List;

import com.ApproximateComputing.po.PathPlaning;
import com.ApproximateComputing.vo.CommonDTO;

public interface PathPlaningService {
	public CommonDTO createMultiPathPlaningByCallable(List<PathPlaning>list);
	public CommonDTO createMultiPathPlaning(List<PathPlaning>list);
	public List<PathPlaning> getAll();
	public CommonDTO selectAllAvg();
}

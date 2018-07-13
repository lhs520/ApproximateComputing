package com.ApproximateComputing.dao;

import java.util.List;

import com.ApproximateComputing.po.PhotoDecode;

public interface PhotoDecodeDao {
	public void createMultiPhotoDecode(List<PhotoDecode>list);
	public List<PhotoDecode> getAll();
	public Float selectAvg(Float qualityLossRatio,Integer time);
}

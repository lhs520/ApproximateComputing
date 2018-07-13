package com.ApproximateComputing.dao;

import java.util.List;

import com.ApproximateComputing.po.ImageRecognition;

public interface ImageRecognitionDao {
	public void createMultiImageRecognition(List<ImageRecognition>list);
	public List<ImageRecognition> getAll();
	public Float selectAvg(Float qualityLossRatio,Integer time);
}

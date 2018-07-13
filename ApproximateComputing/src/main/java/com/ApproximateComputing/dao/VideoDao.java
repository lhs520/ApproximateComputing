package com.ApproximateComputing.dao;

import java.util.List;

import com.ApproximateComputing.po.Video;

public interface VideoDao {
	public void createMultiVideo(List<Video>list);
	public List<Video> getAll();
	public Float selectAvg(Float qualityLossRatio,Integer time);
}

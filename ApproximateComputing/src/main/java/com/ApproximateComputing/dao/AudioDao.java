package com.ApproximateComputing.dao;

import java.util.List;

import com.ApproximateComputing.po.Audio;

public interface AudioDao {
	public void createMultiAudio(List<Audio>list);
	public List<Audio> getAll();
	public Float selectAvg(Float qualityLossRatio,Integer time);
}

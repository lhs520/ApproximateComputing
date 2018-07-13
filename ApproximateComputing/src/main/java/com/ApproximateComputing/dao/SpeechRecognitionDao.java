package com.ApproximateComputing.dao;

import java.util.List;

import com.ApproximateComputing.po.SpeechRecognition;

public interface SpeechRecognitionDao {
	public void createMultiSpeechRecognition(List<SpeechRecognition>list);
	public List<SpeechRecognition> getAll();
	public Float selectAvg(Float qualityLossRatio,Integer time);
}

package com.ApproximateComputing.service;

import java.util.List;

import com.ApproximateComputing.po.SpeechRecognition;
import com.ApproximateComputing.vo.CommonDTO;

public interface SpeechRecognitionService {
	public CommonDTO createMultiSpeechRecognition(List<SpeechRecognition>list);
	public List<SpeechRecognition> getAll();
	public CommonDTO selectAllAvg();
}

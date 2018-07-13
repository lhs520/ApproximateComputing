package com.ApproximateComputing.service;

import java.util.List;


import com.ApproximateComputing.po.ImageRecognition;
import com.ApproximateComputing.vo.CommonDTO;

public interface ImageRecognitionService {
	public CommonDTO createMultiImageRecognitionByCallable(List<ImageRecognition>list);
	public CommonDTO createMultiImageRecognition(List<ImageRecognition>list);
	public List<ImageRecognition> getAll();
	public CommonDTO selectAllAvg();
}

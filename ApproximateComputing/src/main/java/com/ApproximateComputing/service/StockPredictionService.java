package com.ApproximateComputing.service;

import java.util.List;

import com.ApproximateComputing.po.Audio;
import com.ApproximateComputing.po.StockPrediction;
import com.ApproximateComputing.vo.CommonDTO;

public interface StockPredictionService {
	public CommonDTO createMultiStockPrediction(List<StockPrediction>list);
	public List<StockPrediction> getAll();
	public CommonDTO selectAllAvg();
}

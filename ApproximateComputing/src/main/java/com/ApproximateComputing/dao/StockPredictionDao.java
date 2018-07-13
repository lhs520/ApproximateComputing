package com.ApproximateComputing.dao;

import java.util.List;

import com.ApproximateComputing.po.StockPrediction;

public interface StockPredictionDao {
	public void createMultiStockPrediction(List<StockPrediction>list);
	public List<StockPrediction> getAll();
	public Float selectAvg(Float qualityLossRatio,Integer time);
}

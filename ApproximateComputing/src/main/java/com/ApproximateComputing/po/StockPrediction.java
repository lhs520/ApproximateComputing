package com.ApproximateComputing.po;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class StockPrediction implements Serializable{
	private Integer id;
	private Float qualityLossRatio;
	private Float errorRatio;
	private Integer time;
	private Integer grade;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getQualityLossRatio() {
		return qualityLossRatio;
	}
	public void setQualityLossRatio(Float qualityLossRatio) {
		this.qualityLossRatio = qualityLossRatio;
	}
	public Float getErrorRatio() {
		return errorRatio;
	}
	public void setErrorRatio(Float errorRatio) {
		this.errorRatio = errorRatio;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	public Integer getGrade() {
		return grade;
	}
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
}

package com.ApproximateComputing.po;

import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class TSP implements Serializable {
	private Integer id;
	private Float qualityLossRatio;
	private Integer pathLength;
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
	public Integer getPathLength() {
		return pathLength;
	}
	public void setPathLength(Integer pathLength) {
		this.pathLength = pathLength;
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

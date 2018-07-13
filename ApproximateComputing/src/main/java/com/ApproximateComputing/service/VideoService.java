package com.ApproximateComputing.service;

import java.util.List;

import com.ApproximateComputing.po.Video;
import com.ApproximateComputing.vo.CommonDTO;

public interface VideoService {
	public CommonDTO createMultiVideo(List<Video>list);
	public List<Video> getAll();
	public CommonDTO selectAllAvg();
}

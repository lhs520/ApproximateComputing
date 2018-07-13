package com.ApproximateComputing.service;

import java.util.List;

import com.ApproximateComputing.po.Audio;
import com.ApproximateComputing.vo.CommonDTO;

public interface AudioService {
	public CommonDTO createMultiAudioByCallable(List<Audio>list);
	public CommonDTO createMultiAudio(List<Audio>list);
	public List<Audio> getAll();
	public CommonDTO selectAllAvg();
/*	CommonDTO createMultiAudioByRunnable(List<Audio> list);*/
	
}

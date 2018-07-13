package com.ApproximateComputing.service;

import java.util.List;

import com.ApproximateComputing.po.PhotoDecode;
import com.ApproximateComputing.vo.CommonDTO;

public interface PhotoDecodeService {
	public CommonDTO createMultiPhotoDecodeByCallable(List<PhotoDecode>list);
	public CommonDTO createMultiPhotoDecode(List<PhotoDecode>list);
	public List<PhotoDecode> getAll();
	public CommonDTO selectAllAvg();
}

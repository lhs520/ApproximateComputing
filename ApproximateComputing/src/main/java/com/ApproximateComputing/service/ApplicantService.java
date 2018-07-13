package com.ApproximateComputing.service;

import java.util.List;

import com.ApproximateComputing.po.Applicant;
import com.ApproximateComputing.vo.CommonDTO;

public interface ApplicantService {
	public CommonDTO addApplicant(Applicant applicant);
	public List<Applicant> getAll();
}

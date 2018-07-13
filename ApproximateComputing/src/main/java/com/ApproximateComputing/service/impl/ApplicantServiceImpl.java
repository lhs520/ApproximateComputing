package com.ApproximateComputing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ApproximateComputing.dao.ApplicantDao;
import com.ApproximateComputing.po.Applicant;
import com.ApproximateComputing.service.ApplicantService;
import com.ApproximateComputing.vo.CommonDTO;
import com.ApproximateComputing.vo.Result;

@Service("applicantService")
public class ApplicantServiceImpl implements ApplicantService{

	@Autowired
	private ApplicantDao applicantDao;
	
	@Override
	@Transactional
	public CommonDTO addApplicant(Applicant applicant) {
		applicantDao.addApplicant(applicant.getName().toString());
		CommonDTO result=new CommonDTO(Result.SUCCESS);
		return result;
	}

	@Override
	public List<Applicant> getAll() {
		return applicantDao.getAll();
	}

}

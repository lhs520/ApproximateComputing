package com.ApproximateComputing.dao;

import java.util.List;

import com.ApproximateComputing.po.Applicant;

public interface ApplicantDao {
	public void addApplicant(String name);
	public List<Applicant> getAll();
}

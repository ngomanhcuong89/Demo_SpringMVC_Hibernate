package poly.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poly.service.DepartService;
import poly.service.HomeService;
import poly.service.RecordService;
import poly.service.StaffService;
import poly.service.UploadService;
import poly.service.UserService;

public class HomeServiceImpl implements HomeService
{
	@Autowired
	UserService userService;
	@Autowired
	StaffService staffService;
	@Autowired
	DepartService departService;
	@Autowired
	UploadService uploadService;
	@Autowired
	RecordService recordService;
	
	@Override
	public UserService getUser() 
	{
		return this.userService;
	}
	
	@Override
	public StaffService getStaff() 
	{
		return this.staffService;
	}
	
	@Override
	public DepartService getDepart() 
	{
		return this.departService;
	}
	
	@Override
	public UploadService getUpload() 
	{
		return this.uploadService;
	}
	
	@Override
	public RecordService getRecord() 
	{
		return this.recordService;
	}
}

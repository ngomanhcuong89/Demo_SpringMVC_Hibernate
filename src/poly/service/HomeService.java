package poly.service;

public interface HomeService 
{
	UserService getUser();
	StaffService getStaff();
	DepartService getDepart();
	UploadService getUpload();
	RecordService getRecord();
}

package poly.service.impl;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import poly.service.UploadService;

@Service
public class UploadServiceImpl implements UploadService
{
	@Autowired
	ServletContext context;
	
	@Override
	public void UploadImage(MultipartFile image) 
	{
		String url = context.getRealPath("hinhanh/"+image.getOriginalFilename());
		try 
		{
			image.transferTo(new File(url));
		}
		catch(Exception ex) 
		{
			ex.printStackTrace();
		}
	}
}

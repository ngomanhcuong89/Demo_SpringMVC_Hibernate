package poly.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	void UploadImage(MultipartFile image);
}

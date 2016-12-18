package main.java.portfolio.services;

import java.io.File;
import org.springframework.web.multipart.MultipartFile;

public interface CloudStorage {

	public static CloudStorage init() {
		return new S3CloudStorage();
	}

	public default String convertAndUploadMultipartFile(String pathname, MultipartFile file) throws Exception {
		File tempFile = File.createTempFile("temp/", null);
		file.transferTo(tempFile);
		return this.put(pathname, tempFile);
	}

	public String put(String key, File file) throws Exception;
}
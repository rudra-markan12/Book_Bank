package com.BookProject.BookBank.helper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.InputStream;
// import java.nio.file.Files;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
	public final String Class_path = "C:\\Users\\Lenovo\\Downloads\\BookBank\\BookBank\\src\\main\\resources\\static\\image";

	public boolean gettingPath(MultipartFile file) {
		boolean flag = false;

		try {
			// READ
			// InputStream is= file.getInputStream();
			// byte data[] = new byte[is.available()];
			// is.read(data);

			// // WRITE
			// FileOutputStream out = new
			// FileOutputStream(Class_path+File.separator+file.getOriginalFilename());
			// out.write(data);

			// out.flush();
			// out.close();

			// YHA TOH APN YEH UPR WALA KR SKTE HAI NHI TOH APN EK LINE MEIN BHI YEH KR SKTE
			// HAI

			Files.copy(file.getInputStream(), Paths.get(Class_path + File.separator + file.getOriginalFilename()),
					StandardCopyOption.REPLACE_EXISTING);
			flag = true;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return flag;
	}
}

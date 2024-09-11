package com.BookProject.BookBank.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.BookProject.BookBank.helper.FileUploadHelper;

@RestController
public class FileUpload {
      
	@Autowired
	private FileUploadHelper  fileUploadHelper;


	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
//		System.out.println(file.getOriginalFilename());
//		System.out.println(file.getSize());
//		System.out.println(file.getContentType());

		try {
			if (file.isEmpty()) {
				return ResponseEntity.badRequest().body("Please select a file");
			}
           
			boolean isupload = fileUploadHelper.gettingPath(file);
			if (isupload) {
			  return 	ResponseEntity.ok("File were successfully uploades");
			}
			
			
		} catch (Exception e) {
		e.printStackTrace();		
		}
		

     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
	}
}

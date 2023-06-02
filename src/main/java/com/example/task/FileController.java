package com.example.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;




@RestController
@RequestMapping({"/api"})
public class FileController {
	  
	@Autowired
	private FileRepository fileRepository;
	
    

    @PostMapping(value="/upload")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file){
    	
    	try {
            FileEntity fileEntity = new FileEntity();
            fileEntity.setFileName(file.getOriginalFilename());
            fileEntity.setFileData(file.getBytes());
            fileRepository.save(fileEntity);

            return ResponseEntity.ok("File uploaded successfully!");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to upload file");
        }
    	
    }
    	
    
//    public FileEntity saveDocument(@RequestBody FileEntity fileEntity) {
//    	return fileService.create(fileEntity);	
//    }
    
    

    
   
}

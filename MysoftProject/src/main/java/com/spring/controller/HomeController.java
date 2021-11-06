package com.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.spring.model.Information;
import com.spring.service.InfoService;

@RestController
@CrossOrigin("http://localhost:4200/")
public class HomeController {
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("index");
	}

	
	@GetMapping("/getAll")
	public ResponseEntity<List<Information>> getAll(){
		System.out.println("Get All Hit");
		List<Information> info = infoService.getAll();
		return new ResponseEntity<List<Information>>(info, HttpStatus.OK);
	}
	
	@PostMapping("/save")
	public ResponseEntity<Information> save(@RequestBody Information info){
		System.out.println("Save Hit");
		Information information = infoService.save(info);
		return new ResponseEntity<Information>(information, HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Information> update(@RequestBody Information info){
		System.out.println("Update Hit");
		Information information = infoService.save(info);
		
		return new ResponseEntity<Information>(information, HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Information> delete(@PathVariable("id") long id){
		System.out.println("Delete Hit");
		infoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	 @PostMapping("/upload-image/{code}") 
	 public ResponseEntity<String> uploadFile(@PathVariable("code") String code, @RequestParam("file")
	 
	 MultipartFile file){
		 if(!file.isEmpty()) { 
			if(!infoService.saveFileToFolder(code,file)) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file not uploaded, something went wrong!!"); 
			}
		 }else { 
			 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("file is EMPTY, try again!!"); 
		 } 
		 return ResponseEntity.ok("file uploaded"); 
	 }
	 
	
}

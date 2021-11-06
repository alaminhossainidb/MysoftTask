package com.spring.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.spring.dao.InfoRepository;
import com.spring.model.Information;

@Service
@Transactional
public class InfoService {
	
	@Autowired
	private InfoRepository infoRepository;
	

	public Information save(Information info) {
		return infoRepository.save(info);
	}


	public void delete(long id) {
		infoRepository.deleteById(id);
		
	}


	public List<Information> getAll() {
		// TODO Auto-generated method stub
		return infoRepository.findAll();
	}


	public boolean saveFileToFolder(String code, MultipartFile file) {
		boolean flag = false;
		String name = file.getOriginalFilename();
		if(name.contains(".")) {
			int index = name.lastIndexOf(".");
			name = name.substring(index, name.length());
		}
		
		String URL =  "C:\\Users\\AL-AMIN HOSSAIN\\Desktop\\CODES\\ANGULAR CODES\\MysoftAngular\\src\\assets\\images/" + code + name;
		
		try {
			System.out.println("Image saved : "+Paths.get(URL));
			Files.copy(file.getInputStream(), Paths.get(URL), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("image uploaded from this side");
			flag = true;
		}catch(IOException io) {
			System.out.println(io);
			flag = false;
		}
		
		return flag;
	}



	

	

	
}

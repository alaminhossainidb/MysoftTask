package com.spring.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "info")
public class Information {
	
@Id
private Long id;

@Column(name = "code")
private String code;

@Column(name = "name")
private String name;

@Column(name = "fname")
private String fatherName;

@Column(name = "mname")
private String motherName;

@Column(name = "image")
private String image;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getCode() {
	return code;
}

public void setCode(String code) {
	this.code = code;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getFatherName() {
	return fatherName;
}

public void setFatherName(String fatherName) {
	this.fatherName = fatherName;
}

public String getMotherName() {
	return motherName;
}

public void setMotherName(String motherName) {
	this.motherName = motherName;
}

public String getImage() {
	return image;
}

public void setImage(String image) {
	this.image = image;
}


}

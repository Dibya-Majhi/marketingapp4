package com.marketing.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="leads")
public class Lead {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id;
	
@Column(name="firs_tName" ,length=45,nullable=false)
private String firstName;

@Column(name="last_tName" ,length=45,nullable=false)
private String lastName;

@Column(name="email" ,length=128,nullable=false,unique=true)
private String email;


@Column(name="mobile" ,length=10,nullable=false,unique=true)
private String mobile;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
} 
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getMobile() {
	return mobile;
}
public void setMobile(String mobile) {
	this.mobile = mobile;
}
	
}

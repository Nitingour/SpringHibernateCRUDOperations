package com.myapp.beans;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Employee")
public class EmployeeBean {
@Id	
@Column(name="empid")
@GeneratedValue
int eid;
String ename,email,address;
double salary;
Date joiningdate;
//@Temporal(value = TemporalType.TIMESTAMP)
//java.util.Date createdDate;
//
//public java.util.Date getCreatedDate() {
//	return createdDate;
//}
//public void setCreatedDate(java.util.Date createdDate) {
//	this.createdDate = createdDate;
//}
public int getEid() {
	return eid;
}
public void setEid(int eid) {
	this.eid = eid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public double getSalary() {
	return salary;
}
public void setSalary(double salary) {
	this.salary = salary;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public Date getJoiningdate() {
	return joiningdate;
}
public void setJoiningdate(Date joiningdate) {
	this.joiningdate = joiningdate;
}

}

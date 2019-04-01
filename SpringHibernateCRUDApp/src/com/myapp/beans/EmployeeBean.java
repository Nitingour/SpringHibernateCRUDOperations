package com.myapp.beans;

import java.sql.Date;

public class EmployeeBean {
int eid;
String ename,email,address;
double salary;
Date joiningdate;
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

package com.myapp.controllers;

import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.myapp.beans.EmployeeBean;
import com.myapp.dao.DbDao;

@Controller
public class AdminController {

	@RequestMapping("/")
	public String index()
	{	
		return "views/index";
	}
	@RequestMapping("/CheckLogin")
	//public ModelAndView check(@RequestParam("uid") String u,@RequestParam("pwd") String p)
	public ModelAndView check(HttpSession session,@RequestParam String uid,@RequestParam String pwd)
	
	{	
		ModelAndView mv=null;
		DbDao d=new DbDao();
		int x=d.loginCheck(uid,pwd);
		if(x==1)
		{
			session.setAttribute("loginuser",uid);
			mv=new ModelAndView("views/adminhome","msg","Login Fail,try again..");
		}
		else
		{
			mv=new ModelAndView("views/index","msg","Login Fail,try again..");
		}
		return mv;
	}

	@RequestMapping("/newemp")
	public String newemp()
	{	
		return "views/newemp";
	}

	@RequestMapping("/home")
	public String home()
	{	
		return "views/adminhome";
	}
	@RequestMapping("/EmpInsert")
	//public ModelAndView check(@RequestParam int eid,@RequestParam String ename,@RequestParam String email,@RequestParam double salary,@RequestParam String address,@RequestParam Date joiningdate)
	public ModelAndView check(@ModelAttribute EmployeeBean e)
	
	{	
		ModelAndView mv=null;
		DbDao d=new DbDao();
//		EmployeeBean e=new EmployeeBean();
//		e.setEid(eid);
//		e.setEmail(email);
//		e.setAddress(address);
//		e.setJoiningdate(joiningdate);
//		e.setSalary(salary);
		int x=d.insertEmp(e);
		if(x==1)
		{
			mv=new ModelAndView("views/newemp","msg","Data Inserted Successfully...");
		}
		else
		{
			mv=new ModelAndView("views/newemp","msg","Not Inserted");
		}
		return mv;
	}

	
	@RequestMapping("/ViewEmp")
	public ModelAndView viewEmp()
	{	
		
		DbDao d=new DbDao();
		ArrayList<EmployeeBean> list = d.viewAllEmp();
		ModelAndView mv=new ModelAndView("views/viewemp","LIST",list);
		return mv;
	}
	
	@RequestMapping("/DelEmp")
	public ModelAndView delEmp(@RequestParam int empid)
	{	
		DbDao d=new DbDao();
		ModelAndView mv=new ModelAndView("views/viewemp");
		ArrayList<EmployeeBean> list = d.viewAllEmp();
		mv.addObject("LIST",list);
		
		int x = d.deleteEmp(empid);
		if(x!=0)
			mv.addObject("msg","Data Deleted");
		else
			mv.addObject("msg","Data Not Deleted");
		return mv;
	}
	@RequestMapping("/UpEmp")
	public ModelAndView upEmp(@RequestParam int empid)
	{	
		DbDao d=new DbDao();
		ModelAndView mv=new ModelAndView("views/updateemp");
		 EmployeeBean e=d.viewEmpbyID(empid);
			mv.addObject("EMP",e);
		
			return mv;
	}
	
	@RequestMapping("/EmpUpdate")
	public ModelAndView empupdates(@ModelAttribute EmployeeBean e)
	
	{	
		ModelAndView mv=null;
		DbDao d=new DbDao();
		int x=d.updateEmp(e);
		if(x==1)
		{
			mv=new ModelAndView("views/viewemp","msg","Data updated Successfully...");
			ArrayList<EmployeeBean> list = d.viewAllEmp();
			mv.addObject("LIST",list);
		}
		else
		{
			mv=new ModelAndView("views/viewemp","msg","Not Updated");
			ArrayList<EmployeeBean> list = d.viewAllEmp();
			mv.addObject("LIST",list);
		}
		return mv;
	}	
	@RequestMapping("/logout")
	public String logout(HttpSession session)
	{
		session.invalidate();
		return "views/index";
	}	
}

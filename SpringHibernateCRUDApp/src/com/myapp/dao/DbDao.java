package com.myapp.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import com.myapp.beans.EmployeeBean;
import com.myapp.beans.LoginBean;


//DAO Class
public class DbDao {

	public Session getSession()
	{
		Session session=null;
		SessionFactory sf= new AnnotationConfiguration().configure().buildSessionFactory();
		session=sf.openSession();
		return session;
	}
	
	public Connection start()
	{
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3307/empdb?user=root&password=root");
			
		}catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e);
		}
		return con;
	}
	
	
	public int loginCheck(String u,String p)
	{
		int x=0;
		
		Session session=getSession();
		Criteria ct=session.createCriteria(LoginBean.class);
		//select * from login where uid=u and password=p
		ct.add(Restrictions.eq("uid",u));
		ct.add(Restrictions.eq("password",p));
		List list=(List)ct.list();
		if(!list.isEmpty())
		  x=1;
	
//		try(Connection con=start()) {
//	PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
//	ps.setString(1,uid);
//	ps.setString(2,pwd);
//	    ResultSet rs=ps.executeQuery();
//		if(rs.next())
//			x=1;
//		}catch(SQLException e)
//		{
//			System.out.println(e);
//		}
		return x;
		
	}
	
  public int insertEmp(EmployeeBean e)
  {
	  
	  int x=0;
	  //CM + TM +HQL execute
	//Class.forName
	  SessionFactory sf= new AnnotationConfiguration(). configure().buildSessionFactory();
	  //Connection
	  Session session=sf.openSession();
	  Transaction transaction=session.beginTransaction();
	Object o=session.save(e);//Insert 
	if(o!=null)
		x=1;
	transaction.commit();
	  session.close();
	  
//		try(Connection con=start()) {
//	PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
//	ps.setInt(1,e.getEid());
//	ps.setString(2,e.getEname());
//	ps.setDouble(3,e.getSalary());
//	ps.setString(4,e.getAddress());
//	ps.setString(5,e.getEmail());
//	//java.util.Date d=e.getJoiningdate();
//	//java.sql.Date sqldate=new java.sql.Date(d.getTime());
//	ps.setDate(6,e.getJoiningdate());
//
//	 long l=System.currentTimeMillis();//1 jan 1970 00:00AM ---> till  243854239857345987324
//	 String p=l+""; //"243854239857345987324"
//	 String pwd=p.substring(8);
//	 ps.setString(7,pwd);
//	   x=ps.executeUpdate();
//	   if(x!=0)
//	   {
//		  // String msg="Congrats your empid:"+e.getEid()+" and password is:"+pwd;
//		  // sendMail(e.getEmail(),"EMS System Password",msg)  ;
//	   }
//		}catch(SQLException ex)
//		{
//			System.out.println(ex);
//		}
		return x;
	  
  }
	
	/*
	 * public void sendMail(String to,String sub,String msg) {
	 * 
	 * String from = "nitingour999@gmail.com"; final String username =
	 * "nitingour999@gmail.com";//change accordingly final String password =
	 * "XXXXXXXXXXXX";//change accordingly
	 * 
	 * // Assuming you are sending email through relay.jangosmtp.net String host =
	 * "smtp.gmail.com";
	 * 
	 * Properties props = new Properties(); props.put("mail.smtp.auth", "true");
	 * props.put("mail.smtp.starttls.enable", "true"); props.put("mail.smtp.host",
	 * host); props.put("mail.smtp.port", "587");
	 * 
	 * // Get the Session object. Session session = Session.getInstance(props, new
	 * javax.mail.Authenticator() { protected PasswordAuthentication
	 * getPasswordAuthentication() { return new PasswordAuthentication(username,
	 * password); } });
	 * 
	 * try { // Create a default MimeMessage object. Message message = new
	 * MimeMessage(session);
	 * 
	 * // Set From: header field of the header. message.setFrom(new
	 * InternetAddress(from));
	 * 
	 * // Set To: header field of the header.
	 * message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	 * 
	 * // Set Subject: header field message.setSubject(sub);
	 * 
	 * // Now set the actual message message.setText(msg);
	 * 
	 * // Send message
	 * 
	 * Transport.send(message); } catch (MessagingException e) {
	 * e.printStackTrace(); } }
	 * 
	 */	
  public ArrayList<EmployeeBean>  viewAllEmp()
  {
	  Session session=getSession();
	  Criteria ct=session.createCriteria(EmployeeBean.class);//select * from employee
	//select * from employee where ename='kkk'   ===> 1
	  //  ct.add(Restrictions.eq("ename","kkk"));
	//select * from employee where salary>15000 ====>1
	   //ct.add(Restrictions.gt("salary",15000.00));
	//select * from employee where salary>=15000 ====>2
	 // ct.add(Restrictions.ge("salary",15000.00));
	//select * from employee where empid=2 ====>1
	//  ct.add(Restrictions.eq("eid",2));
	 //   select * from employee where ename like '%kumar%';
	 // ct.add(Restrictions.like("ename","kUmAr" ,MatchMode.ANYWHERE));
	  ArrayList<EmployeeBean> list=( ArrayList<EmployeeBean>)ct.list();
	  return list;
	   
//	ArrayList<EmployeeBean> list=new ArrayList<EmployeeBean>();
//	Session session=getSession();
//	//String sql="select * from employee";  seLEct empid,address from employee SQL- Insensitive
//	String hql="from EmployeeBean"; //select eid,address from EmployeeBean;  HQL- Case sensitive
//	Query q=session.createQuery(hql);  // PS ps
//	 Iterator it=q.iterate();         //ResultSet rs=ps.executeQuery();
//	while(it.hasNext())
//	{
//		EmployeeBean e=(EmployeeBean)it.next();
//		list.add(e);
//	}
//	//session.close();
//	return list;	
//	  ArrayList<EmployeeBean> list=new ArrayList<EmployeeBean>();
//	  
//		try(Connection con=start()) {
//			PreparedStatement ps=con.prepareStatement("select * from Employee");
//			 ResultSet rs=ps.executeQuery();
//				while(rs.next())
//			     {
//				   EmployeeBean e=new EmployeeBean();
//				   e.setEid(rs.getInt("eid"));
//				   e.setEname(rs.getString("ename"));
//				   e.setSalary(rs.getDouble("salary"));	
//				   e.setEmail(rs.getString("email"));
//				   e.setAddress(rs.getString("address"));
//				   e.setJoiningdate(rs.getDate("joiningdate"));
//                  list.add(e);
//			     }
//				}catch(SQLException e)
//				{
//					System.out.println(e);
//				}
//	  return list;
  }
  
  
  public int deleteEmp(int eid)
  {
	  int x=0;
	  Session session=getSession();
	  Transaction tt=session.beginTransaction();
//String sql="delete from employee where empid=?";
	  String hql="delete from EmployeeBean where eid=:xyz";
	  Query q=session.createQuery(hql);
	  q.setInteger("xyz",eid);
	   x=q.executeUpdate();
	  //	  EmployeeBean e=new EmployeeBean();
//	  e.setEid(eid);
//	  session.delete(e);
	  tt.commit();
	  return x;
	  
	  
	  
//	  int x=0;
//		try(Connection con=start()) {
//	PreparedStatement ps=con.prepareStatement("delete from employee where eid=?");
//	ps.setInt(1,eid);
//	   x=ps.executeUpdate();
//		}catch(SQLException ex)
//		{
//			System.out.println(ex);
//		}
//		return x;
//	  
  }
  
  public EmployeeBean  viewEmpbyID(int eid)
  {
	  //get one record by pk
	  
	  Session session=getSession();
	//  EmployeeBean e=(EmployeeBean)session.get(EmployeeBean.class, eid);  //always hit DB
	  EmployeeBean e=(EmployeeBean)session.load(EmployeeBean.class, eid); //first time hit db other time cache
	  return e;
	  
//	  EmployeeBean e=new EmployeeBean();
//	  
//		try(Connection con=start()) {
//			PreparedStatement ps=con.prepareStatement("select * from Employee where eid=?");
//			ps.setInt(1,eid);
//			 ResultSet rs=ps.executeQuery();
//				while(rs.next())
//			     {
//				  
//				   e.setEid(rs.getInt("eid"));
//				   e.setEname(rs.getString("ename"));
//				   e.setSalary(rs.getDouble("salary"));	
//				   e.setEmail(rs.getString("email"));
//				   e.setAddress(rs.getString("address"));
//				   e.setJoiningdate(rs.getDate("joiningdate"));
//                
//			     }
//				}catch(SQLException ex)
//				{
//					System.out.println(e);
//				}
//	  return e;
  }


public int updateEmp(EmployeeBean e) {
	  int x=0;
	 
	  Session session=getSession();
	  Transaction tt=session.beginTransaction();
//	   session.update(e);
//	     x=1;
 	String hql="update EmployeeBean set ename=:a,email=:b,address=:c,salary=:d where eid=:e";
	  Query q=session.createQuery(hql);
	  q.setString("a", e.getEname());
	  q.setString("b", e.getEmail());
	  q.setString("c",e.getAddress());
	  q.setDouble("d", e.getSalary());
	  q.setInteger("e",e.getEid());
	  x=q.executeUpdate();
	  tt.commit();
	  return x;
	  
//			try(Connection con=start()) {
//		PreparedStatement ps=con.prepareStatement("update employee set ename=?,salary=?,email=?,address=?,joiningdate=? where eid=?");
//		ps.setInt(6,e.getEid());
//		ps.setString(1,e.getEname());
//		ps.setDouble(2,e.getSalary());
//		ps.setString(4,e.getAddress());
//		ps.setString(3,e.getEmail());
//		java.util.Date d=e.getJoiningdate();
//		java.sql.Date sqldate=new java.sql.Date(d.getTime());
//		ps.setDate(5,sqldate);
//		   x=ps.executeUpdate();
//		 	}catch(SQLException ex)
//			{
//				System.out.println(ex);
//			}
//			return x;
}
  
  
  
	
}

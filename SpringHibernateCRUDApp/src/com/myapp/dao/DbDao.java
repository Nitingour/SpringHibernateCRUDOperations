package com.myapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
//
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;

import com.myapp.beans.EmployeeBean;



public class DbDao {

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
	
	
	public int loginCheck(String uid,String pwd)
	{
		int x=0;
		try(Connection con=start()) {
	PreparedStatement ps=con.prepareStatement("select * from login where uid=? and password=?");
	ps.setString(1,uid);
	ps.setString(2,pwd);
	    ResultSet rs=ps.executeQuery();
		if(rs.next())
			x=1;
		}catch(SQLException e)
		{
			System.out.println(e);
		}
		return x;
		
	}
	
  public int insertEmp(EmployeeBean e)
  {
	  
	  int x=0;
		try(Connection con=start()) {
	PreparedStatement ps=con.prepareStatement("insert into employee values(?,?,?,?,?,?,?)");
	ps.setInt(1,e.getEid());
	ps.setString(2,e.getEname());
	ps.setDouble(3,e.getSalary());
	ps.setString(4,e.getAddress());
	ps.setString(5,e.getEmail());
	//java.util.Date d=e.getJoiningdate();
	//java.sql.Date sqldate=new java.sql.Date(d.getTime());
	ps.setDate(6,e.getJoiningdate());

	 long l=System.currentTimeMillis();//1 jan 1970 00:00AM ---> till  243854239857345987324
	 String p=l+""; //"243854239857345987324"
	 String pwd=p.substring(8);
	 ps.setString(7,pwd);
	   x=ps.executeUpdate();
	   if(x!=0)
	   {
		  // String msg="Congrats your empid:"+e.getEid()+" and password is:"+pwd;
		  // sendMail(e.getEmail(),"EMS System Password",msg)  ;
	   }
		}catch(SQLException ex)
		{
			System.out.println(ex);
		}
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
	  ArrayList<EmployeeBean> list=new ArrayList<EmployeeBean>();
	  
		try(Connection con=start()) {
			PreparedStatement ps=con.prepareStatement("select * from Employee");
			 ResultSet rs=ps.executeQuery();
				while(rs.next())
			     {
				   EmployeeBean e=new EmployeeBean();
				   e.setEid(rs.getInt("eid"));
				   e.setEname(rs.getString("ename"));
				   e.setSalary(rs.getDouble("salary"));	
				   e.setEmail(rs.getString("email"));
				   e.setAddress(rs.getString("address"));
				   e.setJoiningdate(rs.getDate("joiningdate"));
                  list.add(e);
			     }
				}catch(SQLException e)
				{
					System.out.println(e);
				}
	  
	  
	  
	  return list;
  }
  
  
  public int deleteEmp(int eid)
  {
	  
	  int x=0;
		try(Connection con=start()) {
	PreparedStatement ps=con.prepareStatement("delete from employee where eid=?");
	ps.setInt(1,eid);
	   x=ps.executeUpdate();
		}catch(SQLException ex)
		{
			System.out.println(ex);
		}
		return x;
	  
  }
  
  public EmployeeBean  viewEmpbyID(int eid)
  {
	  EmployeeBean e=new EmployeeBean();
	  
		try(Connection con=start()) {
			PreparedStatement ps=con.prepareStatement("select * from Employee where eid=?");
			ps.setInt(1,eid);
			 ResultSet rs=ps.executeQuery();
				while(rs.next())
			     {
				  
				   e.setEid(rs.getInt("eid"));
				   e.setEname(rs.getString("ename"));
				   e.setSalary(rs.getDouble("salary"));	
				   e.setEmail(rs.getString("email"));
				   e.setAddress(rs.getString("address"));
				   e.setJoiningdate(rs.getDate("joiningdate"));
                
			     }
				}catch(SQLException ex)
				{
					System.out.println(e);
				}
	  return e;
  }


public int updateEmp(EmployeeBean e) {
	  int x=0;
			try(Connection con=start()) {
		PreparedStatement ps=con.prepareStatement("update employee set ename=?,salary=?,email=?,address=?,joiningdate=? where eid=?");
		ps.setInt(6,e.getEid());
		ps.setString(1,e.getEname());
		ps.setDouble(2,e.getSalary());
		ps.setString(4,e.getAddress());
		ps.setString(3,e.getEmail());
		java.util.Date d=e.getJoiningdate();
		java.sql.Date sqldate=new java.sql.Date(d.getTime());
		ps.setDate(5,sqldate);
		   x=ps.executeUpdate();
		 	}catch(SQLException ex)
			{
				System.out.println(ex);
			}
			return x;
}
  
  
  
	
}

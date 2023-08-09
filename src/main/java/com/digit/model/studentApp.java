package com.digit.model;

import java.sql.Connection;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class studentApp {
	int sid;
	static String sname;
	private static PreparedStatement pstmt;
	String email;
	int course_id;
	private Connection con;
	private Statement stmt;
	private ResultSet resultset;
	private PreparedStatement pstmt1;
	private ResultSet resultSet1;
	static String user_name;
	static String password;

	/**
	 * @return the sid
	 */
	public int getSid() {
		return sid;
	}

	/**
	 * @param sid the sid to set
	 */
	public void setSid(int sid) {
		this.sid = sid;
	}

	/**
	 * @return the sname
	 */
	public static String getSname() {
		return sname;
	}

	/**
	 * @param sname the sname to set
	 */
	public static void setSname(String sname) {
		studentApp.sname = sname;
	}

	/**
	 * @return the pstmt
	 */
	public static PreparedStatement getPstmt() {
		return pstmt;
	}

	/**
	 * @param pstmt the pstmt to set
	 */
	public static void setPstmt(PreparedStatement pstmt) {
		studentApp.pstmt = pstmt;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the course_id
	 */
	public int getCourse_id() {
		return course_id;
	}

	/**
	 * @param course_id the course_id to set
	 */
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	/**
	 * @return the user_name
	 */
	public static String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public static void setUser_name(String user_name) {
		studentApp.user_name = user_name;
	}

	/**
	 * @return the password
	 */
	
	public static String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public static void setPassword(String password) {
		studentApp.password = password;
	}

	public studentApp() {

		// Store the database connection code.

		String url = "jdbc:mysql://localhost:3306/courses";

		String user = "root";

		String pwd = "Welcome@123";

		// Database connection

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, user, pwd);

		}

		catch (Exception e) {

			e.printStackTrace();

		}

	}

	public boolean register() {
		String sql = "insert into users values(?,?)";
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, getUser_name());

			pstmt.setString(2, getPassword());

			int x = pstmt.executeUpdate();
			
			if (x > 0) {
				// System.out.println("Student Registered------------ :");
				String sql1 = "insert into srequest values(?,?,?)";

					pstmt = con.prepareStatement(sql1);

					pstmt.setString(1, getUser_name());

					pstmt.setString(2, getPassword());
					pstmt.setInt(3, getSid());

					int y = pstmt.executeUpdate();
					

					if (y > 0) {

						// System.out.println("Request login activated:");

							String sql2 = "insert into student values(?,?,?,?)";
							pstmt = con.prepareStatement(sql2);
							pstmt.setInt(1, getSid());
							pstmt.setInt(2, getCourse_id());
							pstmt.setString(3, getSname());
							pstmt.setString(4, getEmail());

							int z = pstmt.executeUpdate();
							
							if (z > 0) {
								// CRSApp.sleep(3000);
								// System.out.println(s.getSname() + " Added------------ :");
								return true;
							}
					

				}

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
	public boolean removestd() {
		try {
			String sql = "delete from student where sid=?";
			
			pstmt =con.prepareStatement(sql);
			String sqls = "select sname from student where sid=?";
			pstmt1 =con.prepareStatement(sqls);
			
				
				pstmt1.setInt(1,getSid());
				resultSet1 = pstmt1.executeQuery();
				
				String sname ="";
				
				if(resultSet1.next()) {
				sname = resultSet1.getString("sname");
				}
				else {
					return false;
				}
				
				pstmt.setInt(1, getSid());
				int x = pstmt.executeUpdate();
				if (x > 0) {
					return true;
				}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	public boolean loginstud() {
		
		try {
			 
				 String sql = "select * from srequest";
					stmt = con.createStatement();
					 resultset = stmt.executeQuery(sql);
					
			while (resultset.next() == true) {
				
				if(user_name.equals(resultset.getString("user_name")) 
						&& password.equals(resultset.getString("password")) &&sid==(resultset.getInt("sid"))) {
					return true;
					
					
				}
				
	
			}
			

		} catch(Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
//	public boolean showMarks() {
//		PreparedStatement prep1;
//		try {
//			prep1 = con.prepareStatement("Select *from student where sid=?");
//			prep1.setInt(1, sid);
//	          ResultSet r1 = prep1.executeQuery();
//	          if(r1.next()){
//	        	
//	       	  return true;
//		}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//      	
//          return false;
//	}

}

package com.digit.model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;


public class CourseApp {
	int cid;
	String cname;
	int fees;
	int dur_months;
	private PreparedStatement pstmt1;
	private ResultSet resultSet1;
	/**
	 * @return the cid
	 */
	public int getCid() {
		return cid;
	}

	/**
	 * @param cid the cid to set
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}

	/**
	 * @return the cname
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * @param cname the cname to set
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	/**
	 * @return the fees
	 */
	public int getFees() {
		return fees;
	}

	/**
	 * @param fees the fees to set
	 */
	public void setFees(int fees) {
		this.fees = fees;
	}

	/**
	 * @return the dur_months
	 */
	public int getDur_months() {
		return dur_months;
	}

	/**
	 * @param dur_months the dur_months to set
	 */
	public void setDur_months(int dur_months) {
		this.dur_months = dur_months;
	}
	public static PreparedStatement pstmt;

	/**
	 * 
	 * @return the user_name
	 * 
	 */

	static String user_name;
	/**
	 * @return the user_name
	 */

	static String password;

	private static Connection con;

	private static ResultSet res;

	public CourseApp() {

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

	public static boolean login() {

		try {

			// TODO Auto-generated method stub

			//Scanner sc = new Scanner(System.in);

			//System.out.println("Enter the user_name:");

			// user_name=sc.next();

			//System.out.println("Enter the password:");

			// pass=sc.next();

			String sql = "select * from users where user_name=? and password=?";

			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, user_name);

			pstmt.setString(2, password);

			res = pstmt.executeQuery();

			if (user_name.equals("admin") && password.equals("admin")) {

				return true;

			} else {

				return false;

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return false;

	}

	public boolean admin() {

	//	int temp = 0;

	//	System.out.println("Admin Login");

	//	while (true) {

			//temp++;

			boolean b = login();

			if (b == true) {

				//System.out.println("Login Successful...\n");

				//System.out.println("------------------------------------");

				// manage();

				return true;

			}

			//if (temp == 3) {

				//System.out.println("admin not found");

				//return false;

				// break;

			//}
			else {

				//System.err.println("Invalid......\n");

				//System.out.println("Enter again");
				return false;

			}

		//}

	}

	public static String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
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
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean course()
	{
		try {

			// Course c = new Course(1, "java", 4000, 3);
//			int id, fee, dur, x;
//			String cn;
//			Scanner sc = new Scanner(System.in);
//			System.out.println("add course");
//			System.out.println("\nHow many courses do you want to add ?");
//			n = sc.nextInt();
			//for (int i = 0; i < n; i++) {
//				System.out.println("Course " + (i + 1));
//				System.out.println("\nEnter course id");
//				id = sc.nextInt();
//				System.out.println("Enter course name");
//				cn = sc.next();
//				System.out.println("Enter course fee");
//				fee = sc.nextInt();
//				System.out.println("Enter course duration");
//				dur = sc.nextInt();
//				Course c = new Course(id, cn, fee, dur);
				String sql = "insert into course values(?,?,?,?)";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, getCid());
				pstmt.setString(2, getCname());
				pstmt.setInt(3, getFees());
				pstmt.setInt(4, getDur_months());
				
				int x = pstmt.executeUpdate();
				if (x > 0) {
					//CRSApp.sleep(3000);
					//System.out.println(c.getCname() + "\n Course Added---------  :");
					return true;

				}
			
			
			//System.out.println("\n\t\tCourse Added Successfully...");
			//System.out.println("\n****************************************\n");
			//menu();

		} catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public boolean removec() {
		try {
			String sql = "delete from course where cid=?";
			pstmt = con.prepareStatement(sql);
			String sqls = "select cname from course where cid=?";
			pstmt1 = con.prepareStatement(sqls);

				pstmt1.setInt(1,getCid());
				resultSet1 = pstmt1.executeQuery();
				
				if(resultSet1.next()) {
				cname = resultSet1.getString("cname");
				}
				else {
					return false;
				}
				
				pstmt.setInt(1, getCid());
				
				int x = pstmt.executeUpdate();
				if (x > 0) {
					//System.out.println( "removing course - "+cname);
					return true;
				} 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}

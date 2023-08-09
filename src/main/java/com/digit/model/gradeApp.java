package com.digit.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class gradeApp {
	int sid;
	int test1_score;
	int test2_score;
	int practical_score;
	int final_score;
	String grade;
	private PreparedStatement pstmt;
	private Connection con;
	public gradeApp() {
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
	 * @return the test1_score
	 */
	public int getTest1_score() {
		return test1_score;
	}
	/**
	 * @param test1_score the test1_score to set
	 */
	public void setTest1_score(int test1_score) {
		this.test1_score = test1_score;
	}
	/**
	 * @return the test2_score
	 */
	public int getTest2_score() {
		return test2_score;
	}
	/**
	 * @param test2_score the test2_score to set
	 */
	public void setTest2_score(int test2_score) {
		this.test2_score = test2_score;
	}
	/**
	 * @return the final_score
	 */
	public int getFinal_score() {
		return final_score;
	}
	/**
	 * @param final_score the final_score to set
	 */
	public void setFinal_score(int final_score) {
		this.final_score = final_score;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}
	/**
	 * @return the practical_score
	 */
	public int getPractical_score() {
		return practical_score;
	}
	/**
	 * @param practical_score the practical_score to set
	 */
	public void setPractical_score(int practical_score) {
		this.practical_score = practical_score;
	}
	public boolean grade() {
		this.setFinal_score((practical_score+test1_score+test2_score)/3);
		if(final_score>=90) {
			this.setGrade("O");
		}
		else if(final_score<90 && final_score>=70){
			this.setGrade("E");
		}
		else if(final_score<70 && final_score>=50) {
			this.setGrade("A");
		}
		else {
			this.setGrade("F");
		}
		try {
			String sql="insert into grading values(?,?,?,?,?,?)";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, getSid());
			
			pstmt.setInt(2, getTest1_score());
			pstmt.setInt(3, getTest2_score());
			pstmt.setInt(4, getPractical_score());
			pstmt.setInt(5, getFinal_score());
			pstmt.setString(6, getGrade());
			int x=pstmt.executeUpdate();
			if(x>0) {
				return true;
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		return false;
	}
	

}

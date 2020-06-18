package com.api.demorestful;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class StudentRepository {
	
	
	Connection con = null;
	
	public StudentRepository() {
		
		String url = "jdbc:mysql://localhost:3306/restdb";
		String username = "root";
		String password = "0";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url,username,password);
		}
		catch(Exception e) { System.out.println(e); }
	}
	
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		String sql = "select * from student";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next()) {
				Student s = new Student();
				s.setName(rs.getString(2));
				s.setPoints(rs.getInt(3));
				
				students.add(s);
			}
		}
		catch(Exception e) { System.out.println(e); }
		return students;
	}
	
	public Student getStudent(int points) {
		
		String sql = "select * from student where points="+ points;
		Student s = new Student();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next()) {
				
				s.setName(rs.getString(2));
				s.setPoints(rs.getInt(3));
			}
		}
		catch(Exception e) { System.out.println(e); }
	
		return s;
	}

	public void create(Student s1) {
		String sql = "insert into student values (?,?)";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			st.executeUpdate();
			st.setString(1, s1.getName());
			st.setInt(2, s1.getPoints());
		}
		catch(Exception e) { System.out.println(e); }
	
	}
	
	public void update(Student s1) {
		String sql = "update student set name=? where points=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setString(1, s1.getName());
			st.setInt(2, s1.getPoints());
			st.executeUpdate();
		}
		catch(Exception e) { System.out.println(e); }
	
	}

	public void delete(int points) {
		String sql = "delete from student where points=?";
		try {
			PreparedStatement st = con.prepareStatement(sql);
			
			st.setInt(1, points);
			st.executeUpdate();
		}
		catch(Exception e) { System.out.println(e); }
		
	}
 }

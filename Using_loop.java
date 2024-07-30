//package com.first;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.Scanner;
//
//public class Using_loop {
//
//	public static void insert(Connection con, Scanner sc) {
//		try {
//			
//			String query = "Insert into Course values(?, ?, ?, ?)";
//			
//			PreparedStatement pstmt = con.prepareStatement(query);
//			System.out.println("Enter the course id");
//			int c_id = sc.nextInt();
//			System.out.println("Enter the course name");
//			String c_name = sc.next();
//			System.out.println("Enter the course trainer details");
//			String c_trainer= sc.next();
//			System.out.println("Enter the cost details");
//			Double c_cost =sc.nextDouble();
//			pstmt.setInt(1, c_id);
//			pstmt.setString(2, c_name);
//			pstmt.setString(3, c_trainer);
//			pstmt.setDouble(4, c_cost);
//			pstmt.execute();
//			System.out.println("Data is inserted");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void update(Connection con, Scanner sc) {
//		try {
//			String query = "update Course set c_name = ? where c_id = ?";
//			
//			PreparedStatement pstmt = con.prepareStatement(query);
//			System.out.println("Enter the course id");
//			int c_id = sc.nextInt();
//			System.out.println("Enter the course name");
//			String c_name = sc.next();
//			
//			pstmt.setString(1, c_name);  
//	        pstmt.setInt(2, c_id);       
//			
//			pstmt.executeUpdate();
//			System.out.println("Data is updated");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public static void fetch(Connection con, Scanner sc) {
//		try {
//			String query = "Select c_name, c_cost from course where c_id = ?";
//			
//			System.out.println("Enter the course id");
//			int c_id = sc.nextInt();
//			PreparedStatement pstmt = con.prepareStatement(query);
//			
//			
//	        pstmt.setInt(3, c_id);
//	        
//			ResultSet rs = pstmt.executeQuery(query);
//			while(rs.next()){
//				System.out.println( rs.getString(1)+ "|" + rs.getDouble(2)+ "|" + rs.getInt(3));
//			}
//			System.out.println(" Selection of Data are fetched");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	
//	public static void retrieveAll(Connection con, Scanner sc) {
//		try {
//			String query = "Select * from course";
//			
//			
//			PreparedStatement pstmt = con.prepareStatement(query);
//			ResultSet rs = pstmt.executeQuery(query);
//			while(rs.next()){
//				System.out.println(rs.getInt(1) + "|" + rs.getString(2)+ "|" + rs.getString(3)+ "|" + rs.getInt(4));
//			}
//			System.out.println("All the Data are fetched");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static void delete(Connection con, Scanner sc) {
//		try {
//			String query = "delete from course where c_id =?";
//			System.out.println("Enter the C_id");
//			int c_id = sc.nextInt(); 
//			
//			PreparedStatement pstmt = con.prepareStatement(query);
//			pstmt.setInt(1, c_id); 
//			pstmt.executeUpdate();
//			
//			System.out.println("All the Data are deleted");
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//	public static void main(String[] args) {
//		String url = "jdbc:mysql://localhost:3306/myjdbc"; 
//		String user = "root";
//		String password = "Pa$$w0rd";
//		System.out.println("Enter the course details");
//		Scanner sc = new Scanner(System.in);		 	
//				
//		try {
//			
//			Connection con = DriverManager.getConnection(url,user, password);
//			System.out.println("Connection Established");
//			System.out.println("Enter the number of loops to run");
//			 int n = sc.nextInt();
//			 
//			 
//			 for ( int i= 0; i<=n-1; i++) {
//				 insert(con, sc);
//				 update(con,sc);
//				 delete(con,sc);
//				 fetch(con,sc);
//				 retrieveAll(con,sc);
//			 
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		
//	}
//
//
//}

import java.sql.*;
import java.util.*;


public class Using_loop{
	public static void main(String[]args) {
		String url = "jdbc:mysql://localhost/3306:myjdbc";
		String user = "root";
		String password = "Pa$$w0rd";
		
		
		
	try {
		
		Connection con = DriverManager.getConnection(url, user, password);
		System.out.println("Enter the course details");
		Scanner sc = new Scanner(System.in);	
		String query ="Insert into values (?,?,?,?) ";
		
		PreparedStatement pstmt = con.prepareStatement(query);
		System.out.println("Enter the course id");
		int c_id = sc.nextInt();
		
		System.out.println("Enter the course name");
		String c_name = sc.next();
		System.out.println("Enter the course trainer details");
		String c_trainer= sc.next();
		System.out.println("Enter the cost details");
		Double c_cost =sc.nextDouble();
		int row = sc.nextInt();
		for( int i=0; i<=row; i++) {
		
		//Completingthe query
		pstmt.setInt(1, c_id);
		pstmt.setString(2, c_name);
		pstmt.setString(3, c_trainer);
		pstmt.setDouble(4, c_cost);
		//Adding the query to the batch
		pstmt.addBatch();
	}
		pstmt.excuteBatch();
		
	
		System.out.println("Data is inserted");
	} catch (SQLException e) {
		e.printStackTrace();
	}
} 
}




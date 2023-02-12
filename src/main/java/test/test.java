package test;

import java.util.ArrayList;


import database.user_dataDAO;

import model.user_data;

public class test {
	public static void main(String[] args) {
		user_dataDAO u = new user_dataDAO();
		user_data t = new user_data();
		t.setUserId(1001);
		t.setPassword("183");
		user_data a = u.selectByLoginAndPassword(t);
		System.out.println("aa");
		
	}
}




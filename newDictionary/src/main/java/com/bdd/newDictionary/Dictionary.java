package com.bdd.newDictionary;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Dictionary {
	ArrayList<Profile> userList = new ArrayList<Profile>();
	ArrayList<Profile> adminList = new ArrayList<Profile>();
	ArrayList<Profile> holderList = new ArrayList<Profile>();
	DictionaryInterface D = new SimpleDictionary();
	private Scanner fileScan;
	
	
	// Build dictionary
	public String buildDictionary(String file) throws FileNotFoundException {
		File fp = new File(file);
		if(!fp.exists())	
			return "failed";
		fileScan = new Scanner(new FileInputStream(fp));
		String st;
		while (fileScan.hasNext()) {
			st = fileScan.nextLine();
			D.add(st);
		}
		return "success";
	}
	
	// Add some users, admin, and holder
	public void initialize() {
		Profile temp = new Profile("user", "user");
		Profile temp1 = new Profile("user1", "user1");
		Profile temp2 = new Profile("admin", "admin");
		Profile temp3 = new Profile("HelloKitty", "NotACat");
		
		userList.add(temp);
		userList.add(temp1);
		adminList.add(temp2);
		holderList.add(temp3);
	}
	
	// Admin: create
	public String create_user(Profile user) {
		if(!userList.contains(user)) {
			userList.add(user);
			return "created user";
		}
		else
			return "did not create user";
	}
	
	// Admin: delete
	public String delete_user(Profile user) {
		if(!userList.contains(user)) {
			userList.remove(user);
			return "deleted user";
		}
		else 
			return "not in system";
	}
	
	// User: login
	public String check_user(String name, String password) {
		boolean isValid = false, wrong_password = false, wrong_name = false;
		Profile temp;
		for(int i=0; i< userList.size(); i++) {
			temp = userList.get(i);
			if(name.equals(temp.name) && password.equals(temp.password))
				isValid = true;
			else if(name.equals(temp.name) && !password.equals(temp.password))
				wrong_password = true;
			else if(!name.equals(temp.name) && password.equals(temp.password))
				wrong_name = true;
		}
		if(isValid)	return "User Log In Successfully!!";
		else if(wrong_password) return "Failed!! Wrong Password.";
		else if(wrong_name) return "Failed!! Wrong User Name.";
		else return "Failed!! Wrong User Name and Password";
	} 

	// User: check word in dictionary.txt
	public String check_word(String input) {
		String retval = "";
		StringBuilder sb = new StringBuilder(input);
		int ans = D.search(sb);
		System.out.print(sb + " is ");
		switch (ans) {
			case 0: retval = "not found";
			break;
			case 1: retval = "a prefix";
			break;
			case 2: retval = "a word";
			break;
			case 3: retval = "a prefix and word";
			break;
		}
		return retval;
	}
	
	// Holder: publish 
	public String authorize(String input) {
		if(input.equals("y"))
			return "authorized";
		if(input.equals("n"))
			return "unauthorized";
		else
			return "invalid";
	}
}

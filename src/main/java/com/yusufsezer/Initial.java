package com.yusufsezer;

import java.io.FileNotFoundException;
import java.util.List;


import com.yusufsezer.model.User;
import com.yusufsezer.repository.MySQL;
import com.yusufsezer.repository.UserRepository;
import com.yusufsezer.util.Helper;

public class Initial {

	public static void main(String[] args) throws FileNotFoundException {
	
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		UserRepository existingUserRepository = new UserRepository(mySQL);

		List<User> allUsers = existingUserRepository.getAll();

	
		for (final var value : allUsers) {
			System.out.println(value.getId());
		}
		
	}
}

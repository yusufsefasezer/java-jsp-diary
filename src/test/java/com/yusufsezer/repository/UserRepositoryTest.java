package com.yusufsezer.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.FileNotFoundException;
import java.util.List;
import org.junit.jupiter.api.Test;
import com.yusufsezer.util.Helper;
import com.yusufsezer.model.User;

class UserRepositoryTest {

	@Test
	void positiveTestGet() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		UserRepository existingUserRepository = new UserRepository(mySQL);
		Integer existingUserId = 1;
		assertNotNull(existingUserRepository.get(existingUserId));
	}

	@Test
	void positiveTestGetAll() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		UserRepository existingUserRepository = new UserRepository(mySQL);
		List<User> existingUserList = existingUserRepository.getAll();
		assertFalse(existingUserList.isEmpty());
	}

	@Test
	void positiveTestAdd() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		UserRepository existingUserRepository = new UserRepository(mySQL);
		User newUser = new User();
		newUser.setEmail("nuevo_user9000@gmail.com");
		newUser.setFirstName("Juan");
		newUser.setLastName("Florez");
		newUser.setPassword("12345678");			
		
		boolean addTest = existingUserRepository.add(newUser);
		
		assertTrue(addTest);

		if (addTest) {
			List<User> allUsers = existingUserRepository.getAll();
			int lastUserId = allUsers.get(allUsers.size() - 1).getId();
			existingUserRepository.remove(lastUserId);
		}	
	}

	@Test
	void positiveTestUpdate() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		UserRepository existingUserRepository = new UserRepository(mySQL);
		User copyUser = new User();
		Integer userId = 4;
		copyUser.setEmail("actualizando_user4@gmail.com");
		copyUser.setFirstName("Andre");
		copyUser.setLastName("Arturo");
		copyUser.setPassword("0987654321");		
		assertNotNull(existingUserRepository.update(userId, copyUser));
	}

	@Test
	void positiveTestRemove() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		UserRepository existingUserRepository = new UserRepository(mySQL);
		User newUser = new User();
		newUser.setEmail("borrar_user1000@gmail.com");
		newUser.setFirstName("Juan");
		newUser.setLastName("Florez");
		newUser.setPassword("12345678");
		existingUserRepository.add(newUser);	
		
		List<User> allUsers = existingUserRepository.getAll();
		Integer lastUserId = allUsers.get(allUsers.size() - 1).getId();
		
		assertNotNull(existingUserRepository.remove(lastUserId));
	}

	@Test
	void positiveTestLogin() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		UserRepository existingUserRepository = new UserRepository(mySQL);
		assertNotNull(existingUserRepository.login("berly@gmail.com", "berly"));
	}
	
	@Test
	void incorrectTestLogin() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		UserRepository existingUserRepository = new UserRepository(mySQL);
		assertNull(existingUserRepository.login("bdiazca@unsa.edu.pe", "464356534324"));
	}
}

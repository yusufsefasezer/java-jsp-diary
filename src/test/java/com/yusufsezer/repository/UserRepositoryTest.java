package com.yusufsezer.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yusufsezer.util.Helper;
import com.yusufsezer.model.User;

class UserRepositoryTest {

	MySQL mySQL;
	UserRepository existingUserRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		mySQL = new MySQL(Helper.getUrlDatabase());
		existingUserRepository = new UserRepository(mySQL);
		Helper.logger.log(System.Logger.Level.INFO, Helper.getUrlDatabase());
	}
		
	@Test
	void positiveTestGet() {
		Integer existingUserId = 1;
		assertNotNull(existingUserRepository.get(existingUserId));
	}

	@Test
	void positiveTestGetAll() {
		List<User> existingUserList = existingUserRepository.getAll();
		assertFalse(existingUserList.isEmpty());
	}

	@Test
	void positiveTestAdd() {
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
	void positiveTestUpdate() {
		User copyUser = new User();
		Integer userId = 4;
		copyUser.setEmail("actualizando_user4@gmail.com");
		copyUser.setFirstName("Andre");
		copyUser.setLastName("Arturo");
		copyUser.setPassword("0987654321");		
		assertNotNull(existingUserRepository.update(userId, copyUser));
	}

	@Test
	void positiveTestRemove() {
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
	void positiveTestLogin() {
		assertNotNull(existingUserRepository.login("berly@gmail.com", "berly"));
	}
	
	@Test
	void incorrectTestLogin() {
		assertNull(existingUserRepository.login("bdiazca@unsa.edu.pe", "464356534324"));
	}
}

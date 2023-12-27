package com.yusufsezer.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
import com.yusufsezer.model.Diary;
import com.yusufsezer.repository.DiaryRepository;
import com.yusufsezer.model.User;
import com.yusufsezer.repository.UserRepository;

class HelperTest {

	@Test
	void positiveTestUserRepository() {	
		UserRepository userRepository = Helper.userRepository();
		User existingUser = userRepository.get(1);
		assertNotNull(existingUser);
	}
	
	@Test
	void positiveTestDiaryRepository() {	
		DiaryRepository diaryRepository = Helper.diaryRepository();	
		Diary existingRepository = diaryRepository.get(1);
		assertNotNull(existingRepository);	
	}
	
	@Test
	void negativeTestUserRepository() {	
		UserRepository userRepository = Helper.userRepository();
		User noExistingUser = userRepository.get(12323);
		assertNull(noExistingUser);
	}

	@Test
	void negativeTestDiaryRepository() {	
		DiaryRepository diaryRepository = Helper.diaryRepository();	
		Diary noExistingRepository = diaryRepository.get(4534534);
		assertNull(noExistingRepository);	
	}
}

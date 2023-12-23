package com.yusufsezer.util;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import java.io.FileNotFoundException;
import org.junit.jupiter.api.Test;
import com.yusufsezer.model.Diary;
import com.yusufsezer.repository.DiaryRepository;
import com.yusufsezer.model.User;
import com.yusufsezer.repository.UserRepository;

class HelperTest {

	@Test
	void positiveTestUserRepository() throws FileNotFoundException{	
		UserRepository userRepository = Helper.userRepository();
		User existingUser = userRepository.get(4);
		assertNotNull(existingUser);
	}
	
	@Test
	void positiveTestDiaryRepository() throws FileNotFoundException{	
		DiaryRepository diaryRepository = Helper.diaryRepository();	
		Diary existingRepository = diaryRepository.get(4);
		assertNotNull(existingRepository);	
	}
	
	@Test
	void negativeTestUserRepository() throws FileNotFoundException{	
		UserRepository userRepository = Helper.userRepository();
		User noExistingUser = userRepository.get(12323);
		assertNull(noExistingUser);
	}

	@Test
	void negativeTestDiaryRepository() throws FileNotFoundException{	
		DiaryRepository diaryRepository = Helper.diaryRepository();	
		Diary noExistingRepository = diaryRepository.get(4534534);
		assertNull(noExistingRepository);	
	}
}

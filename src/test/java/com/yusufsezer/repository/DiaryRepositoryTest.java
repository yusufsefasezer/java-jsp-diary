package com.yusufsezer.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import com.yusufsezer.model.Diary;
import com.yusufsezer.util.Helper;

class DiaryRepositoryTest {

	MySQL mySQL;
	DiaryRepository existingDiaryRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		mySQL = new MySQL(Helper.getUrlDatabase());
		existingDiaryRepository = new DiaryRepository(mySQL);
	}
	
	@Test
	void testGet() {	
		Integer existingDiaryId = 1;
		assertNotNull(existingDiaryRepository.get(existingDiaryId));
	}

	@Test
	void testGetAll() {
		List<Diary> existingDiaryList = existingDiaryRepository.getAll();	
		assertFalse(existingDiaryList.isEmpty());
	}

	@Test
	void testGetAllByUserId() {
		Integer existingUserId = 1; 
		List<Diary> existingDiaryList = existingDiaryRepository.getAllByUserId(existingUserId, true);	
		assertFalse(existingDiaryList.isEmpty());
	}

	@Test
	void testAdd() {	
		Diary newDiary = new Diary();
		newDiary.setContent("Ingresando un diario desde pruebas junit con id de usuario");
		newDiary.setDateOfDiary(new Date());
		newDiary.setVisibility(true);		
		
		boolean resultTest = existingDiaryRepository.add(newDiary);
		assertTrue(resultTest);
			
		if (resultTest) {
			List<Diary> existingDiaryList = existingDiaryRepository.getAll();
			Integer diaryIdLast = existingDiaryList.get(0).getId();
			existingDiaryRepository.remove(diaryIdLast);
		}
	}

	@Test
	void testUpdate() {
		Diary copyDiary = new Diary();
		Integer existingDiaryId = 4;	
		copyDiary.setContent("Actualizacion del diario");
		copyDiary.setUserId(500);
		copyDiary.setId(existingDiaryId);	
		copyDiary.setVisibility(true);	
		LocalDate localDate = LocalDate.now();
		Date date = java.sql.Date.valueOf(localDate);
		copyDiary.setDateOfDiary(date);
		assertNotNull(existingDiaryRepository.update(existingDiaryId, copyDiary));
	}
	
	@Test
	void testRemove() {
		Diary newDiary = new Diary();	
		newDiary.setContent("Borrando un diario desde pruebas junit");
		newDiary.setDateOfDiary(new Date());
		newDiary.setVisibility(true);	
		existingDiaryRepository.add(newDiary);	
		
		List<Diary> allDiary = existingDiaryRepository.getAll();
		Integer lastDiaryId = allDiary.get(0).getId();
	
		assertNotNull(existingDiaryRepository.remove(lastDiaryId));
	}
}
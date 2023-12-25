package com.yusufsezer.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import com.yusufsezer.model.Diary;

class DiaryRepositoryTest {

	@Test
	void testGet() throws FileNotFoundException{	
		MySQL mySQL = new MySQL();
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
		Integer existingDiaryId = 1;
		assertNotNull(existingDiaryRepository.get(existingDiaryId));
	}

	@Test
	void testGetAll() throws FileNotFoundException{
		MySQL mySQL = new MySQL();
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
		List<Diary> existingDiaryList = existingDiaryRepository.getAll();	
		assertFalse(existingDiaryList.isEmpty());
	}

	@Test
	void testGetAllByUserId() throws FileNotFoundException{
		MySQL mySQL = new MySQL();
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
		Integer existingUserId = 1; 
		List<Diary> existingDiaryList = existingDiaryRepository.getAllByUserId(existingUserId, true);	
		assertFalse(existingDiaryList.isEmpty());
	}

	@Test
	void testAdd() throws FileNotFoundException{	
		MySQL mySQL = new MySQL();
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
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
	void testUpdate() throws FileNotFoundException {
		MySQL mySQL = new MySQL();
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
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
	void testRemove() throws FileNotFoundException{
		MySQL mySQL = new MySQL();
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
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
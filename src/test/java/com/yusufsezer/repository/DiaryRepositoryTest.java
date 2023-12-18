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
import com.yusufsezer.util.Helper;

class DiaryRepositoryTest {

	@Test
	void testGet() throws FileNotFoundException{	
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
		Integer existingDiaryId = 4;
		assertNotNull(existingDiaryRepository.get(existingDiaryId));
	}

	@Test
	void testGetAll() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
		List<Diary> existingDiaryList = existingDiaryRepository.getAll();
		assertFalse(existingDiaryList.isEmpty());
	}

	@Test
	void testGetAllByUserId() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
		Integer existingUserId = 4; //Sin Diarios
		List<Diary> existingDiaryList = existingDiaryRepository.getAllByUserId(existingUserId, false);	
		assertFalse(!existingDiaryList.isEmpty());
	}

	@Test
	void testAdd() throws FileNotFoundException{	
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
		Diary newDiary = new Diary();
		Integer userId = 300;
		newDiary.setContent(String.format("Ingresando un diario desde pruebas junit con id de usuario %d", userId));
		newDiary.setUserId(userId);
		newDiary.setDateOfDiary(new Date());
		newDiary.setVisibility(true);		
		assertTrue(existingDiaryRepository.add(newDiary));
	}

	@Test
	void testUpdate() throws FileNotFoundException {
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
		Diary copyDiary = new Diary();
		Integer existingDiaryId = 4;	
		copyDiary.setContent("Actualizacion del diario");
		copyDiary.setUserId(500);
		copyDiary.setId(existingDiaryId);	
		LocalDate localDate = LocalDate.now();
		Date date = java.sql.Date.valueOf(localDate);
		copyDiary.setDateOfDiary(date);
		copyDiary.setVisibility(false);		
		assertNotNull(existingDiaryRepository.update(existingDiaryId, copyDiary));
	}
	
	@Test
	void testRemove() throws FileNotFoundException{
		MySQL mySQL = new MySQL(Helper.getUrlDatabase());
		DiaryRepository existingDiaryRepository = new DiaryRepository(mySQL);
		Diary newDiary = new Diary();	
		newDiary.setContent("Borrando un diario desde pruebas junit");
		newDiary.setUserId(1000);
		newDiary.setDateOfDiary(new Date());
		newDiary.setVisibility(false);	
		existingDiaryRepository.add(newDiary);	
		
		List<Diary> allDiary = existingDiaryRepository.getAll();
		Integer lastDiaryId = allDiary.get(allDiary.size() - 1).getId();
	
		assertNotNull(existingDiaryRepository.remove(lastDiaryId));
	}
}

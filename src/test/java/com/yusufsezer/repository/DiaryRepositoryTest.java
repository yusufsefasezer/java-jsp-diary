package com.yusufsezer.repository;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Date;
import com.yusufsezer.model.Diary;
import com.yusufsezer.contracts.IDatabase;



public class DiaryRepositoryTest {

    private IDatabase mockedDatabase;
    private DiaryRepository diaryRepository;

    @Before
    public void setUp() {
        mockedDatabase = Mockito.mock(IDatabase.class);
        diaryRepository = new DiaryRepository(mockedDatabase);
    }
    

    @Test
    public void testGetDiaryById() throws SQLException {
        ResultSet resultSet = Mockito.mock(ResultSet.class);
        Mockito.when(resultSet.next()).thenReturn(true).thenReturn(false);
        Mockito.when(resultSet.getInt("diary_id")).thenReturn(1);
        Mockito.when(resultSet.getInt("user_id")).thenReturn(1);
        Mockito.when(resultSet.getDate("date_of_diary")).thenReturn(new java.sql.Date(new Date().getTime()));
        Mockito.when(resultSet.getString("content")).thenReturn("Test content");
        Mockito.when(resultSet.getBoolean("visibility")).thenReturn(true);
    }

    @Test
    public void testGetAll() {
        List<Diary> diaryList = diaryRepository.getAll();
        assertNotNull(diaryList);
    }

    @Test
    public void testGetAllByUserId() {
        List<Diary> diaryList = diaryRepository.getAllByUserId(1, true);
        assertNotNull(diaryList);
    }

    @Test
    public void testAdd() {
        Diary diary = new Diary();
        diary.setUserId(1);
        diary.setDateOfDiary(new java.sql.Date(System.currentTimeMillis()));
        diary.setContent("Test content");
        diary.setVisibility(true);
        boolean result = diaryRepository.add(diary);
        assertTrue(result);
    }
}

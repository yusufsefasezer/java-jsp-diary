package com.yusufsezer.repository;

import com.yusufsezer.contracts.IDatabase;
import com.yusufsezer.contracts.IRepository;
import com.yusufsezer.model.Diary;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DiaryRepository implements IRepository<Diary, Integer> {

    private final IDatabase database;
    public static final String DIARY_ID_COLUMN = "diary_id";
    public static final String USER_ID_COLUMN = "user_id";
    public static final String DATE_OF_DIARY_COLUMN = "date_of_diary";
    public static final String CONTENT_COLUMN = "content";
    public static final String VISIBILITY_COLUMN = "visibility";
    
    public DiaryRepository(IDatabase database) {
        this.database = database;
    }

    @Override
    public Diary get(Integer index) {
        Diary diary = null;
        String query = String
                .format("SELECT * FROM diary WHERE diary_id = %d", index);
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                diary = new Diary();
                diary.setId(resultSet.getInt(DIARY_ID_COLUMN));
                diary.setUserId(resultSet.getInt(USER_ID_COLUMN));
                diary.setDateOfDiary(resultSet.getDate(DATE_OF_DIARY_COLUMN));
                diary.setContent(resultSet.getString(CONTENT_COLUMN));
                diary.setVisibility(resultSet.getBoolean(VISIBILITY_COLUMN));
            }
        } catch (Exception e) {
            return diary;
        }
        return diary;
    }

    @Override
    public List<Diary> getAll() {
        List<Diary> list = new ArrayList<>();
        String query = String.format("SELECT * FROM diary WHERE visibility = 1 ORDER BY %s DESC", DIARY_ID_COLUMN);
       
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                Diary diary = new Diary();
                diary.setId(resultSet.getInt(DIARY_ID_COLUMN));
                diary.setUserId(resultSet.getInt(USER_ID_COLUMN));
                diary.setDateOfDiary(resultSet.getDate(DATE_OF_DIARY_COLUMN));
                diary.setContent(resultSet.getString(CONTENT_COLUMN));
                diary.setVisibility(resultSet.getBoolean(VISIBILITY_COLUMN));
                list.add(diary);
            }
        } catch (Exception ex) {
            return list;
        }
        return list;
    }

    public List<Diary> getAllByUserId(Integer userIndex, boolean showAll) {
        List<Diary> list = new ArrayList<>();
        String query = String.format("SELECT * FROM diary WHERE %s%s = %d", (!showAll ? VISIBILITY_COLUMN + " = 1 AND " : " "), USER_ID_COLUMN, userIndex);
               
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                Diary diary = new Diary();
                diary.setId(resultSet.getInt(DIARY_ID_COLUMN));
                diary.setUserId(resultSet.getInt(USER_ID_COLUMN));
                diary.setDateOfDiary(resultSet.getDate(DATE_OF_DIARY_COLUMN));
                diary.setContent(resultSet.getString(CONTENT_COLUMN));
                diary.setVisibility(resultSet.getBoolean(VISIBILITY_COLUMN));
                list.add(diary);
            }
        } catch (Exception ex) {
            return list;
        }
        return list;
    }

    @Override
    public boolean add(Diary diary) {
        boolean result = false;
        String query = String.format("INSERT INTO diary"
                + " VALUES(NULL, '%s', '%s', '%s', %s)",
                diary.getUserId(),
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(diary.getDateOfDiary()),
                diary.getContent(),
                diary.isVisibility() ? 1 : 0);
        try {
            database.executeSQL(query);
            result = true;
        } catch (Exception ex) {
            return result;
        }
        return result;
    }

    @Override
    public Diary update(Integer index, Diary diary) {
        Diary updatedDiary = get(index);
        String query = String.format("UPDATE diary SET "+ "%s = '%s', " + "%s = '%s', " + "%s = %s " + "WHERE %s = %d",                		
        		DATE_OF_DIARY_COLUMN,
        		diary.getDateOfDiary(),
        		CONTENT_COLUMN,
                diary.getContent(),
        		VISIBILITY_COLUMN,		
                diary.isVisibility() ? 1 : 0,
                DIARY_ID_COLUMN,
                index);    
        try {
            boolean result = (boolean) database.executeSQL(query);
            updatedDiary = result ? updatedDiary : diary;
        } catch (Exception ex) {
            return updatedDiary;
        }
        return updatedDiary;
    }

    @Override
    public Diary remove(Integer index) {
        String query = String
                .format("DELETE FROM diary WHERE %s = %d", DIARY_ID_COLUMN, index);
        Diary deletedDiary = get(index);
        try {
            database.executeSQL(query);
        } catch (Exception ex) {
            return deletedDiary;
        }
        return deletedDiary;
    }
}
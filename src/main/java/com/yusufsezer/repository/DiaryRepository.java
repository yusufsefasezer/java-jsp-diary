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
    private static final String DIARY_ID = "diary_id";
    private static final String USER_ID = "user_id";
    private static final String DATE_OF_DIARY = "date_of_diary";
    private static final String CONTENT = "content";
    private static final String VISIBILITY = "visibility";
    public DiaryRepository(IDatabase database) {
        this.database = database;
    }

    @Override
    public Diary get(Integer index) {
        Diary diary = null;
        String query = String
                .format("SELECT * FROM diary WHERE DIARY_ID = %d", index);
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                diary = new Diary();
                diary.setId(resultSet.getInt(DIARY_ID));
                diary.setUserId(resultSet.getInt(USER_ID));
                diary.setDateOfDiary(resultSet.getDate(DATE_OF_DIARY));
                diary.setContent(resultSet.getString(CONTENT));
                diary.setVisibility(resultSet.getBoolean(VISIBILITY));
            }
        } catch (Exception e) {
            return diary;
        }
        return diary;
    }

    @Override
    public List<Diary> getAll() {
        List<Diary> list = new ArrayList<>();
        String query = "SELECT * FROM diary "
                + "WHERE visibility = 1 "
                + "ORDER BY DIARY_ID DESC";
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                Diary diary = new Diary();
                diary.setId(resultSet.getInt(DIARY_ID));
                diary.setUserId(resultSet.getInt(USER_ID));
                diary.setDateOfDiary(resultSet.getDate(DATE_OF_DIARY));
                diary.setContent(resultSet.getString(CONTENT));
                diary.setVisibility(resultSet.getBoolean(VISIBILITY));
                list.add(diary);
            }
        } catch (Exception ex) {
            return list;
        }
        return list;
    }

    public List<Diary> getAllByUserId(Integer userIndex, boolean showAll) {
        List<Diary> list = new ArrayList<>();

        String query = "SELECT * FROM diary "
                + "WHERE " + (!showAll ? "visibility = 1 AND " : " ")
                + "user_id = " + userIndex;
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                Diary diary = new Diary();
                diary.setId(resultSet.getInt("DIARY_ID"));
                diary.setUserId(resultSet.getInt(USER_ID));
                diary.setDateOfDiary(resultSet.getDate(DATE_OF_DIARY));
                diary.setContent(resultSet.getString(CONTENT));
                diary.setVisibility(resultSet.getBoolean(VISIBILITY));
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
        String query = String.format("UPDATE diary SET "
                + "date_of_diary = '%s', "
                + "content = '%s', "
                + "visibility = %s "
                + "WHERE DIARY_ID = %d",
                diary.getDateOfDiary(),
                diary.getContent(),
                diary.isVisibility() ? 1 : 0,
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
                .format("DELETE FROM diary WHERE DIARY_ID = %d", index);
        Diary deletedDiary = get(index);
        try {
            database.executeSQL(query);
        } catch (Exception ex) {
            return deletedDiary;
        }
        return deletedDiary;
    }

}

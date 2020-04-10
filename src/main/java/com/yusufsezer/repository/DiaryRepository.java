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
                diary.setId(resultSet.getInt("diary_id"));
                diary.setUserId(resultSet.getInt("user_id"));
                diary.setDateOfDiary(resultSet.getDate("date_of_diary"));
                diary.setContent(resultSet.getString("content"));
                diary.setVisibility(resultSet.getBoolean("visibility"));
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
                + "ORDER BY diary_id DESC";
        try {
            ResultSet resultSet = database.executeQuery(query);
            while (resultSet.next()) {
                Diary diary = new Diary();
                diary.setId(resultSet.getInt("diary_id"));
                diary.setUserId(resultSet.getInt("user_id"));
                diary.setDateOfDiary(resultSet.getDate("date_of_diary"));
                diary.setContent(resultSet.getString("content"));
                diary.setVisibility(resultSet.getBoolean("visibility"));
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
                diary.setId(resultSet.getInt("diary_id"));
                diary.setUserId(resultSet.getInt("user_id"));
                diary.setDateOfDiary(resultSet.getDate("date_of_diary"));
                diary.setContent(resultSet.getString("content"));
                diary.setVisibility(resultSet.getBoolean("visibility"));
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
                + "WHERE diary_id = %d",
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
                .format("DELETE FROM diary WHERE diary_id = %d", index);
        Diary deletedDiary = get(index);
        try {
            database.executeSQL(query);
        } catch (Exception ex) {
            return deletedDiary;
        }
        return deletedDiary;
    }

}

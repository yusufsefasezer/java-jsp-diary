package com.yusufsezer.model;

import java.io.Serializable;
import java.util.Date;

public class Diary implements Serializable {

    private static final long serialVersionUID = 1L;
    private int id;
    private int userId;
    private Date dateOfDiary;
    private String content;
    private boolean visibility;

    public Diary() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getDateOfDiary() {
        return dateOfDiary;
    }

    public void setDateOfDiary(Date dateOfDiary) {
        this.dateOfDiary = dateOfDiary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isVisibility() {
        return visibility;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return getContent();
    }

}

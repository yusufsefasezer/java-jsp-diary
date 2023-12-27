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
    	id = -1; 
    }
    
    public Diary(final int id, final int userId,final Date dateOfDiary, final String content, final boolean visibility) {
    	this.id = id;
    	this.userId = userId;
    	this.dateOfDiary = dateOfDiary;
    	this.content = content;
    	this.visibility = visibility;
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

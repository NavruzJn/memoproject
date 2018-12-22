package com.example.haojialiang.memomyapplication;

public class Memo {
    private int id;
    private String title;
    private String description;
    private String imgPath;
    private String createdAt;
    private String updatedAt;

    public Memo() {

    }

    public Memo(int id, String title, String description, String imgPath, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgPath = imgPath;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}

package com.example.haojialiang.memomyapplication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class Memo implements Parcelable {
    private int id;
    private String title;
    private String description;
    private String imgPath;
    private String createdAt;
    private String updatedAt;
    private Uri uri;

    public Memo() {

    }

    public Memo(String title, String description,String date) {
        this.title = title;
        this.description = description;
        this.createdAt=date;
    }

    public Memo(int id, String title, String description, String imgPath, String createdAt, String updatedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imgPath = imgPath;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Memo(String title, String description, String imgPath, String createdAt, String updatedAt) {
        this.title = title;
        this.description = description;
        this.imgPath = imgPath;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Memo(String title, String description, String createdAt, String updatedAt, Uri uri) {
        this.title = title;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.uri = uri;
    }

    protected Memo(Parcel in) {
        id = in.readInt();
        title = in.readString();
        description = in.readString();
        imgPath = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        uri = in.readParcelable(Uri.class.getClassLoader());
    }

    public static final Creator<Memo> CREATOR = new Creator<Memo>() {
        @Override
        public Memo createFromParcel(Parcel in) {
            return new Memo(in);
        }

        @Override
        public Memo[] newArray(int size) {
            return new Memo[size];
        }
    };

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

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(imgPath);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeParcelable(uri, flags);
    }
}

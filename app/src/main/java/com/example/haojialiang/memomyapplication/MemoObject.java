package com.example.haojialiang.memomyapplication;

import android.net.Uri;

public class MemoObject  {
    private String title;
    private String detail;
    private String data;
    private String uri;

    public MemoObject(String title, String detail, String data, String uri) {
        this.title = title;
        this.detail = detail;
        this.data = data;
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
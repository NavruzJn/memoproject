package com.example.haojialiang.memomyapplication;

import android.net.Uri;
import android.net.UrlQuerySanitizer;
import android.os.Parcel;
import android.os.Parcelable;

public class MemoObject implements Parcelable {
    private String title;
    private String detail;
    private String data;
    private String uri;

    protected MemoObject(Parcel in) {
        title = in.readString();
        detail = in.readString();
        data = in.readString();
        uri = in.readString();
    }

    public static final Creator<MemoObject> CREATOR = new Creator<MemoObject>() {
        @Override
        public MemoObject createFromParcel(Parcel in) {
            return new MemoObject(in);
        }

        @Override
        public MemoObject[] newArray(int size) {
            return new MemoObject[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(detail);
        dest.writeString(data);
        dest.writeString(uri);
    }
}

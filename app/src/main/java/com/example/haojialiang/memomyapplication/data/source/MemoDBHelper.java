package com.example.haojialiang.memomyapplication.data.source;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.haojialiang.memomyapplication.Memo;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MemoDBHelper extends SQLiteOpenHelper {
    /**
     * Database name
     */
    private static final int DATABASE_VERSION = 1;

    /**
     * Database version
     */
    private static final String DATABASE_NAME = "MemoProject.db";

    /**
     * Table names
     */
    private static final String MEMO_TABLE = "memoTable";

    /**
     * Memo table columns
     */
    private static final String KEY_ROWID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_DESCRIPTION = "description";
    private static final String KEY_IMGPATH= "imgPath";
    private static final String KEY_CREATEDAT = "createdAt";
    private static final String KEY_UPDATEDAT = "updatedAt";
    /**
     * Memo Table: create statement
     */
    private static final String CREATE_MEMO_TABLE =
            "create table " + MEMO_TABLE + "("
                    + KEY_ROWID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + KEY_TITLE + " text,"
                    + KEY_DESCRIPTION + " text,"
                    + KEY_IMGPATH + " text,"
                    + KEY_CREATEDAT + " text ,"
                    + KEY_UPDATEDAT + " text," + ")";

    /**
     * Constructor
     */
    public MemoDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    /** Creating tables */
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MEMO_TABLE);
    }

    @Override
    // TODO: change this so that updating doesn't delete old data
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_MEMO_TABLE);
        onCreate(db);
    }

    public void createMemo(Memo memo) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, memo.getTitle());
        values.put(KEY_DESCRIPTION, memo.getDescription());
        values.put(KEY_IMGPATH, memo.getImgPath());
        values.put(KEY_CREATEDAT, memo.getCreatedAt());
        values.put(KEY_UPDATEDAT, memo.getUpdatedAt());

        db.insert(MEMO_TABLE, null, values);
    }

// ############################# get methods ####################################### //


    /**
     * allows the memoBox to retrieve all the memo rows from database
     *
     * @return a list of memo model objects
     */
    public List<Memo> getAllMemo() {
        List<Memo> memos = new ArrayList<>();
        String dbPills = "SELECT * FROM " + MEMO_TABLE;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(dbPills, null);

        /** Loops through all rows, adds to list */
        if (c.moveToFirst()) {
            do {
                Memo m = new Memo();
                m.setId(c.getInt(c.getColumnIndex(KEY_ROWID)));
                m.setTitle(c.getString(c.getColumnIndex(KEY_TITLE)));
                m.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
                m.setImgPath(c.getString(c.getColumnIndex(KEY_IMGPATH)));
                m.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATEDAT)));
                m.setUpdatedAt(c.getString(c.getColumnIndex(KEY_UPDATEDAT)));

                memos.add(m);
            } while (c.moveToNext());
        }
        c.close();
        return memos;
    }

    public Memo getMemoById(long id) throws URISyntaxException {

        String dbMemo = "SELECT * FROM " +
                MEMO_TABLE + " WHERE " +
                KEY_ROWID + " = " + id;

        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery(dbMemo, null);

        if (c != null)
            c.moveToFirst();

        Memo m = new Memo();
        m.setId(c.getInt(c.getColumnIndex(KEY_ROWID)));
        m.setTitle(c.getString(c.getColumnIndex(KEY_TITLE)));
        m.setDescription(c.getString(c.getColumnIndex(KEY_DESCRIPTION)));
        m.setImgPath(c.getString(c.getColumnIndex(KEY_IMGPATH)));
        m.setCreatedAt(c.getString(c.getColumnIndex(KEY_CREATEDAT)));
        m.setUpdatedAt(c.getString(c.getColumnIndex(KEY_UPDATEDAT)));

        c.close();
        return m;
    }

    public void deleteMemo(long id) {
        SQLiteDatabase db = this.getWritableDatabase();

        db.delete(MEMO_TABLE, KEY_ROWID
                + " = ?", new String[]{String.valueOf(id)});
    }

}

package com.example.myapplication;


import android.content.Context;
import android.database.Cursor;
import android.database.CursorWindow;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.reflect.Field;
public class SQLitehelper extends SQLiteOpenHelper{

    public SQLitehelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void queryData(String sql) {
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }

    public void insertRegistrationData(String name, String usn, String branch, String section, String clubName) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO REG (name, usn, branch, section, club) VALUES (?, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, usn);
        statement.bindString(3, branch);
        statement.bindString(4, section);
        statement.bindString(5, clubName);

        statement.executeInsert();
        database.close();
    }

    public void insertEventRegistrationData(String name, String usn, String branch, String section, String clubName) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO EVENTREG (name, usn, branch, section, club) VALUES (?, ?, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, usn);
        statement.bindString(3, branch);
        statement.bindString(4, section);
        statement.bindString(5, clubName);

        statement.executeInsert();
        database.close();
    }

    public void insertData(String name, String price, byte[] image) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO FOOD VALUES (NULL, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }

    public void insertEventData(String name, String price, byte[] image) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "INSERT INTO EVENT VALUES (NULL, ?, ?, ?)";
        SQLiteStatement statement = database.compileStatement(sql);
        statement.clearBindings();
        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);

        statement.executeInsert();
    }
    public void updateData(String name, String price, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE FOOD SET name = ?, price = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);
        statement.bindDouble(4, (double) id);

        statement.execute();
        database.close();
    }

    public void updateEventData(String name, String price, byte[] image, int id) {
        SQLiteDatabase database = getWritableDatabase();
        String sql = "UPDATE EVENT SET name = ?, price = ?, image = ? WHERE id = ?";
        SQLiteStatement statement = database.compileStatement(sql);

        statement.bindString(1, name);
        statement.bindString(2, price);
        statement.bindBlob(3, image);
        statement.bindDouble(4, (double) id);

        statement.execute();
        database.close();
    }

    public void deleteData(int id)
    {
        SQLiteDatabase database=getWritableDatabase();

        String sql="DELETE FROM FOOD WHERE id = ?";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,(double) id);

        statement.execute();
        database.close();
    }

    public void deleteEventData(int id)
    {
        SQLiteDatabase database=getWritableDatabase();

        String sql="DELETE FROM EVENT WHERE id = ?";
        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();
        statement.bindDouble(1,(double) id);

        statement.execute();
        database.close();
    }
    public Cursor getData(String sql)
    {
        SQLiteDatabase database=getReadableDatabase();
        try {
            Field field = CursorWindow.class.getDeclaredField("sCursorWindowSize");
            field.setAccessible(true);
            field.set(null, 100 * 1024 * 1024); //the 100MB is the new size
        } catch (Exception e) {

            e.printStackTrace();

        }
        return database.rawQuery(sql,null);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

package com.namdp.qlsv;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;

public class StudentDataHelper {
    public static SQLiteDatabase db;

    static {
        try {
            db = SQLiteDatabase.openDatabase("/data/user/0/com.namdp.qlsv/files/mydb", null, SQLiteDatabase.CREATE_IF_NECESSARY);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static List<Student> fetchAll() {
        List<Student> students = new ArrayList<>();
        String[] columns = {"mssv", "hoTen", "email", "ngaySinh"};
        Cursor cs= db.query("student", columns, null,null,null,null,null,null );
        while(cs.moveToNext()) {
//            int id = cs.getInt(0);
            String mssv= cs.getString(0);
            String hoTen = cs.getString(1);
            String email = cs.getString(2);
            Long ngaySinh = cs.getLong(3);
            Log.d("FETCHALL", "fetchAll: " + mssv + " " + hoTen+ " " + email + ' ' + ngaySinh);
            Student s = new Student(0, mssv, hoTen, email, ngaySinh);
            students.add(s);
        }
        cs.close();
        return students;
    }

    static void bootstrap() {
        //create
        db.beginTransaction();
        try {
            db.execSQL("create table student(id integer primary key autoincrement, mssv text, hoTen text, email text, ngaySinh integer)");
            Faker faker = new Faker();
            for(int i = 0; i < 100; i++) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("mssv", faker.number().numberBetween(20190000L, 20199999L));
                contentValues.put("hoTen", faker.name().fullName());
                contentValues.put("email", faker.internet().emailAddress());
                contentValues.put("ngaySinh", faker.date().birthday().getTime());
                db.insert("student", null, contentValues);
            }
            db.setTransactionSuccessful();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            db.endTransaction();
        }
    }

    static void destroy() {
        db.close();
    }
}

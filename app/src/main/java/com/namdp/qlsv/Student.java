package com.namdp.qlsv;

import java.util.Date;

public class Student {
    int id;
    String mssv;
    String hoTen;
    String email;
    Long ngaySinh;

    public Student(int id, String mssv, String hoTen, String email, Long ngaySinh) {
        this.id = id;
        this.mssv = mssv;
        this.hoTen = hoTen;
        this.email = email;
        this.ngaySinh = ngaySinh;
    }
}


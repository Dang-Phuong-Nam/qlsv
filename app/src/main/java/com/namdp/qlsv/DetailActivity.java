package com.namdp.qlsv;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;

public class DetailActivity extends AppCompatActivity {
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.detail_view);

        TextView namev = findViewById(R.id.name_detail);
        TextView mssvv = findViewById(R.id.mssv);
        TextView emailv = findViewById(R.id.email);
        TextView ngaySinh = findViewById(R.id.date_of_birth);

        Intent intent = getIntent();
        String name = intent.getStringExtra("hoTen");
        String mssv= intent.getStringExtra("mssv");
        String email = intent.getStringExtra("email");
        Long dob = intent.getLongExtra("ngaySinh", new Date().getTime());
        namev.setText(name);
        mssvv.setText(mssv);
        emailv.setText(email);
        ngaySinh.setText(new Date(dob).toString());
    }
}

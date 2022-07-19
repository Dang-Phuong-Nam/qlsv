package com.namdp.qlsv;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Student> students;
    private Context ctx;

    class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;

        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.name);
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(ctx, DetailActivity.class);
                intent.putExtra("hoTen", students.get(getAdapterPosition()).hoTen);
                intent.putExtra("mssv", students.get(getAdapterPosition()).mssv);
                intent.putExtra("email", students.get(getAdapterPosition()).email);
                intent.putExtra("ngaySinh", students.get(getAdapterPosition()).ngaySinh);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                ctx.startActivity(intent);
            });
        }
    }

    public StudentAdapter(List<Student> students, Context context) {
        this.students = students;
        this.ctx = context;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_layout, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((StudentViewHolder)holder).nameView.setText(students.get(position).hoTen);
    }


    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}

package com.example.amrihanif.amri_1202150075_studycase5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddTodo extends AppCompatActivity {

    EditText name, description, priority;
    ToDoHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todo);

        //deklarasi objek yang digunakan
        name = findViewById(R.id.nametodo);
        description = findViewById(R.id.desc);
        priority = findViewById(R.id.priority);
        db = new ToDoHelper(this);
    }

    //Method ketika tombol back ditekan
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(AddTodo.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    //Method ketika tombol tambah ditekan
    public void add(View view) {
        if (db.masukkandata(new ModelToDo(name.getText().toString(), description.getText().toString(), priority.getText().toString()))) {
            Toast.makeText(this, "Todo added", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, MainActivity.class));
            this.finish();
        } else {
            Toast.makeText(this, "Adding todo failed", Toast.LENGTH_SHORT).show();
            name.setText(null);
            description.setText(null);
            priority.setText(null);
        }
    }
}
package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HasilActivity extends AppCompatActivity {
    //Mendeklarasikan variabel dengan tipe data textview
    TextView txTask, txJenis, txTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);
        //menerima
        //menghubungkan variabel txmail dengan komponen textview pada layout
        txTask = findViewById(R.id.tvnTask);
        txJenis=findViewById(R.id.tvjTask);
        txTime=findViewById(R.id.tvtTask);

        //membuatobjek bundle dan mengambil data yang di kirimkan dari act sebelumnya
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari act sebelunya dengan kunci a
        String task = bundle.getString("a");
        String jenis = bundle.getString("b");
        String time = bundle.getString("c");
        //menampilkan value dari variabel email kedalam txEmail
        txTask.setText(task);
        txJenis.setText(jenis);
        txTime.setText(time);

    }
}

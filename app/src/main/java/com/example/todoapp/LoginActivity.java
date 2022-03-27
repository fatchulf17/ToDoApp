package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class LoginActivity extends AppCompatActivity {
    //Mendeklarasikan variabel dengan tipe data textview
    TextView txnama;
    //Deklarasi Variabel dengan tipe Edittext
    EditText edtTask, edtJenis, edtTime;
    //Deklarasi variabel untuk menyimpan nama dan password
    String task, jenis, time;

    //Deklarasi variabel dengan tipe data floating action button
    FloatingActionButton save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //menerima
        //menghubungkan variabel txmail dengan komponen textview pada layout
        txnama = findViewById(R.id.tvnama);

        //membuatobjek bundle dan mengambil data yang di kirimkan dari act sebelumnya
        Bundle bundle = getIntent().getExtras();

        //membuat variabel string yang digunakan untuk menyimpan data yang
        //dikirimkan dari act sebelunya dengan kunci a
        String nama = bundle.getString("a");

        //menampilkan value dari variabel email kedalam txEmail
        txnama.setText(nama);

        //mengirim
        edtTask = findViewById(R.id.nTask);
        edtJenis = findViewById(R.id.jTask);
        edtTime = findViewById(R.id.tTask);

        save = findViewById(R.id.fab);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                //menyimpan input user di edittext email kedalam variabel nam                         3                                    a
                task = edtTask.getText().toString();
                jenis = edtJenis.getText().toString();
                time = edtTime.getText().toString();

                //membuat object bundle
                Bundle b = new Bundle();
                //memasukkan value dari variabel nama dengan kunci "a"
                //dan dimasukkan kedalam bundle
                b.putString("a", task.trim());
                b.putString("b", jenis.trim());
                b.putString("c", time.trim());
                if (task.equalsIgnoreCase("")) {
                    edtTask.setError("Masukkan Task");
                } if(jenis.equalsIgnoreCase("")) {
                    edtJenis.setError("Masukkan Jenis");
                } if(time.equalsIgnoreCase("")) {
                    edtTime.setError("Masukkan Waktu");
                }else {
                    if (task.isEmpty() || jenis.isEmpty() || time.isEmpty()) {
                        //membuat variabel toasy dan menampilan pesan "edittext tidak boleh kosong"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Isi semua kolom.",
                                Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();
                    } else{
                        //membuat object intent berpindah activity dari main activity ke activity hasil
                        Intent i = new Intent(getApplicationContext(), HasilActivity.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke Activity hasil
                        i.putExtras(b);
                        //berpindah ke ActivityHasil
                        startActivity(i);
                    }
                }
            }
        });
    }
}
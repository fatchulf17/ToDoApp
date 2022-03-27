package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Deklarasi variabel untuk button
    Button btnLogin;

    TextView txtRegister;

    //Deklarasi variabel untuk edit text
    EditText edname, edpassword;

    //Deklarasi variabel untuk menyimpan nama dan password
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //menghubungkan variabel btnLogin dengan komponen button pada layout
        btnLogin=findViewById(R.id.bLogin);
        txtRegister=findViewById(R.id.btnRegis);

        //menghubungkan variabel edemail dengan komponen button pada layout
        edname=findViewById(R.id.edname1);

        //menghubungkan variabel edpassword dengan komponen button pada layout
        edpassword=findViewById(R.id.edpass1);

        //membuat fungsi onclick pada button txtregister
        txtRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //membuat object intent berpindah activity dari main activity ke activity hasil
                Intent nt = new Intent(getApplicationContext(),RegisterActivity.class);
                //berpindah ke Activit register
                startActivity(nt);
            }
        });

        //membuat fungsi onclick pada button btnLogin
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //menyimpan input user di edittext email kedalam variabel nama
                nama = edname.getText().toString();

                //menyimpan input user di edittext password kedalam variabel password
                password = edpassword.getText().toString();

                //mengeset email yang benar
                String nama1 = "Pascal";

                //mengeset password yang benar
                String pass = "iniPascal";

                //mengecek apakah edit text email dan password terdapat isi atau tidak
                if(nama.trim().equalsIgnoreCase("")){
                    edname.setError("");
                }
                else {
                    //mengecek apakah isi dari email dan password sudah sama dengan email dan
                    //password yang sudah diset
                    if (nama.equals(nama1) && password.equals(pass)) {

                        //membuat variabel toast dan membuat toast dengan menambahkan variabel nama dan password
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Login Berhasil", Toast.LENGTH_LONG);
                        //menampilkan toast
                        t.show();

                        //membuat object bundle
                        Bundle b = new Bundle();
                        //memasukkan value dari variabel nama dengan kunci "a"
                        //dan dimasukkan kedalam bundle

                        b.putString("a", nama.trim());
                        //membuat object intent berpindah activity dari main activity ke activity hasil
                        Intent i = new Intent(getApplicationContext(), LoginActivity.class);

                        //memasukkan bundle kedalam intent untuk dikirimkan ke Activity hasil
                        i.putExtras(b);

                        //berpindah ke ActivityHasil
                        startActivity(i);
                    } else {
                        //membuat variabel toast dan membuat toast dan menampilkan pesan "Masukkan nama dan password dengan benar!"
                        Toast t = Toast.makeText(getApplicationContext(),
                                "Masukkan nama dan password dengan benar.", Toast.LENGTH_LONG);

                        //menampilkan toast
                        t.show();
                    }
                }
            }
        });
    }
}
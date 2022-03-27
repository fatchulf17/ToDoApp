package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class RegisterActivity extends AppCompatActivity {
    //Deklarasi Variabel dengan tipe Edittext
    EditText edtr1, edtr2, edtr3, edtr4;
    Button btnregis;
    String r1, r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        edtr1 = findViewById(R.id.r1);
        edtr2 = findViewById(R.id.r2);
        edtr3 = findViewById(R.id.r3);
        edtr4 = findViewById(R.id.r4);
        btnregis=findViewById(R.id.button);

        btnregis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                r1= edtr1.getText().toString().trim();
                r2 = edtr2.getText().toString().trim();

                if (edtr1.getText().toString().isEmpty() ||
                        edtr2.getText().toString().isEmpty() ||
                        edtr3.getText().toString().isEmpty() ||
                        edtr4.getText().toString().isEmpty()) {
                    if (r1.equalsIgnoreCase("")) {
                        edtr1.setError("Masukkan Nama");}
                    if (r2.equalsIgnoreCase("")) {
                        edtr2.setError("Masukkan Nama");}
                    //menampilkan pesan notifikasi jika seluruh EditText wajib diisi
                    Snackbar.make(view, "Wajib isi seluruh data !!!", Snackbar.LENGTH_LONG).show();

                } else {
                    if (edtr3.getText().toString().equals(edtr4.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil...",
                                Toast.LENGTH_LONG).show();
                        Intent a = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(a);
                    } else {
                        Snackbar.make(view, "Password dan Repassword harus sama!!!",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView texto=findViewById(R.id.Texto_Escrito);
        String mensagem=getIntent().getStringExtra("Texto");
        texto.setText(mensagem);
    }
}
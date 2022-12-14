package com.example.atividade2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Exibir(View view)
    {
     Intent nova_atividade=new Intent(this, MainActivity2.class);
     String mensagem;
     TextView texto= findViewById(R.id.Mensagem);
     mensagem=texto.getText().toString();
     nova_atividade.putExtra("Texto", mensagem);
     startActivity(nova_atividade);
    }
}
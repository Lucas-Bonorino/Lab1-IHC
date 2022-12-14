package com.example.atividade1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Somar(View view)
    {
     EditText campo1, campo2;
     campo1=findViewById(R.id.Numero1);
     campo2=findViewById(R.id.Numero2);

     int numero1, numero2, resultado;
     numero1=Integer.parseInt(campo1.getText().toString());
     numero2=Integer.parseInt(campo2.getText().toString());
     resultado=numero1+numero2;

     String display="Resultado="+resultado;
     TextView campo_resultado;
     campo_resultado=findViewById(R.id.Resultado);
     campo_resultado.setText(display);
     campo_resultado.setVisibility(View.VISIBLE);

    }
}
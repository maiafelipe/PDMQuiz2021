package com.example.pdmquiz2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class AplicarPergunta extends AppCompatActivity {

    public static int quizPontuacao;

    private TextView textoLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aplicar_pergunta);

        textoLabel = (TextView)findViewById(R.id.textoLabel);
        Intent intent = getIntent();
        String str = intent.getStringExtra("Texto");
        textoLabel.setText(str);

    }

    public void responderPergunta(View view) {

        // Verificar se a pergunta está respondida corretamente
        // Se estiver, contabilizar:
        quizPontuacao++;

        
        this.finish();
    }
}
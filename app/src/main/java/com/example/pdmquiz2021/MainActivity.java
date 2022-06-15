package com.example.pdmquiz2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pdmquiz2021.model.Pergunta;
import com.example.pdmquiz2021.model.dao.PerguntaDAO;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PerguntaDAO pdao;
    private TextView pontuacaoLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pontuacaoLabel = (TextView)findViewById(R.id.pontuacaoLabel);

        Context c = getApplicationContext();
        pdao = new PerguntaDAO(c);
    }

    public void abrirPergunta(View view){
        Intent i = new Intent(this , CadastroPergunta.class);
        startActivity(i);
    }

    public void aplicarPergunta(View view){
        //Intent i = new Intent(this , AplicarPergunta.class);
        //startActivity(i);
        List<Pergunta> list = pdao.getRandom(10);
        AplicarPergunta.quizPontuacao = 0;
        for(int n = 0; n < list.size(); n++){
            Intent i = new Intent(this , AplicarPergunta.class);
            i.putExtra("Texto", list.get(n).getTexto());
            startActivity(i);
        }




    }

    @Override
    protected void onResume() {
        super.onResume();
        pontuacaoLabel.setText("Última pontuação: " + AplicarPergunta.quizPontuacao);

    }
}
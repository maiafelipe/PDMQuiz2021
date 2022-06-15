package com.example.pdmquiz2021;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pdmquiz2021.model.Pergunta;
import com.example.pdmquiz2021.model.dao.PerguntaDAO;

public class CadastroPergunta extends AppCompatActivity {
    private EditText textoEdit;
    private EditText opt1Edit;
    private EditText opt2Edit;
    private EditText opt3Edit;
    private EditText opt4Edit;
    private EditText tempoEdit;
    private Spinner corretoSpinner;

    PerguntaDAO pdao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pergunta);

        textoEdit = (EditText)findViewById(R.id.textoEdit);
        opt1Edit = (EditText)findViewById(R.id.opt1Edit);
        opt2Edit = (EditText)findViewById(R.id.opt2Edit);
        opt3Edit = (EditText)findViewById(R.id.opt3Edit);
        opt4Edit = (EditText)findViewById(R.id.opt4Edit);
        tempoEdit = (EditText)findViewById(R.id.tempoEdit);
        corretoSpinner = (Spinner)findViewById(R.id.corretoSpinner);

        String[] items= new String[]{"Opção 1","Opção 2","Opção 3", "Opção 4"};
        // here you can use array or list
        Context c = getApplicationContext();
        ArrayAdapter adapter= new ArrayAdapter(c, R.layout.support_simple_spinner_dropdown_item, items);
        corretoSpinner.setAdapter(adapter);

        pdao = new PerguntaDAO(c);

    }

    public void processarPergunta(View view){


        Pergunta p = new Pergunta();

        p.setTexto(textoEdit.getText().toString());
        p.setOpt1(opt1Edit.getText().toString());
        p.setOpt2(opt2Edit.getText().toString());
        p.setOpt3(opt3Edit.getText().toString());
        p.setOpt4(opt4Edit.getText().toString());
        p.setTempo(Integer.parseInt(tempoEdit.getText().toString()));
        p.setCorreta(corretoSpinner.getSelectedItemPosition());


        p = pdao.inserirPergunta(p);

        Context c = getApplicationContext();
        Toast t = Toast.makeText(c, "Pergunta inserida com id: " + p.getId(),
                Toast.LENGTH_SHORT);
        t.show();
        this.finish();
    }
}
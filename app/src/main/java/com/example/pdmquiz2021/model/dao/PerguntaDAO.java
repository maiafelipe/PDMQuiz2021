package com.example.pdmquiz2021.model.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pdmquiz2021.model.Pergunta;
import com.example.pdmquiz2021.model.handler.PerguntaDBHandler;

import java.util.ArrayList;
import java.util.List;

public class PerguntaDAO {
    private PerguntaDBHandler pdbh;
    private SQLiteDatabase db;

    private static final String[] all = {
            PerguntaDBHandler.COLUMN_ID,
            PerguntaDBHandler.COLUMN_TEXTO,
            PerguntaDBHandler.COLUMN_OPT1,
            PerguntaDBHandler.COLUMN_OPT2,
            PerguntaDBHandler.COLUMN_OPT3,
            PerguntaDBHandler.COLUMN_OPT4,
            PerguntaDBHandler.COLUMN_CORRETA,
            PerguntaDBHandler.COLUMN_TEMPO
    };
    public PerguntaDAO(Context contexto){
        pdbh = new PerguntaDBHandler((contexto));
    }

    public Pergunta inserirPergunta(Pergunta p){
        ContentValues values = new ContentValues();
        values.put(PerguntaDBHandler.COLUMN_TEXTO, p.getTexto());
        values.put(PerguntaDBHandler.COLUMN_OPT1, p.getOpt1());
        values.put(PerguntaDBHandler.COLUMN_OPT2, p.getOpt2());
        values.put(PerguntaDBHandler.COLUMN_OPT3, p.getOpt3());
        values.put(PerguntaDBHandler.COLUMN_OPT4, p.getOpt4());
        values.put(PerguntaDBHandler.COLUMN_CORRETA, p.getCorreta());
        values.put(PerguntaDBHandler.COLUMN_TEMPO, p.getTempo());
        db = pdbh.getWritableDatabase();
        long id = db.insert(PerguntaDBHandler.TABLE_PERGUNTA,
                null, values);
        p.setId(id);
        db.close();
        return p;
    }

    // Getting single Pergunta
    public Pergunta getPergunta(long id) {
        db = pdbh.getWritableDatabase();
        Cursor cursor = db.query(PerguntaDBHandler.TABLE_PERGUNTA, all,
                PerguntaDBHandler.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)},null,null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }

        Pergunta p = new Pergunta();
        p.setId(cursor.getLong(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_ID)));
        p.setTexto(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_TEXTO)));
        p.setTempo(cursor.getInt(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_TEMPO)));
        p.setOpt1(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT1)));
        p.setOpt2(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT2)));
        p.setOpt3(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT3)));
        p.setOpt4(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT4)));
        p.setCorreta(cursor.getInt(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_CORRETA)));
        db.close();
        // return Pergunta
        return p;
    }

    // Seleciona e retorna todas as perguntas do banco
    public List<Pergunta> getAllPerguntas() {
        db = pdbh.getWritableDatabase();
        Cursor cursor = db.query(PerguntaDBHandler.TABLE_PERGUNTA,all,
                null,null,null, null, null);

        List<Pergunta> perguntas = new ArrayList<Pergunta>();
        System.out.println("Query: " + cursor.getCount());
        if(cursor.getCount() > 0){
            // Percorre todos os elementos encontrados e
            // coloca todos na lista
            while(cursor.moveToNext()){
                Pergunta p = new Pergunta();
                p.setId(cursor.getLong(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_ID)));
                p.setTexto(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_TEXTO)));
                p.setTempo(cursor.getInt(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_TEMPO)));
                p.setOpt1(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT1)));
                p.setOpt2(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT2)));
                p.setOpt3(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT3)));
                p.setOpt4(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT4)));
                p.setCorreta(cursor.getInt(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_CORRETA)));

                perguntas.add(p);
            }
        }
        // return All Perguntas
        db.close();
        return perguntas;
    }

    public List<Pergunta> getRandom(int qnt) {
        db = pdbh.getWritableDatabase();
        Cursor cursor = db.query(PerguntaDBHandler.TABLE_PERGUNTA,all,
                null,null,null, null, "Random()", ""+qnt);

        List<Pergunta> perguntas = new ArrayList<Pergunta>();
        System.out.println("Query: " + cursor.getCount());
        if(cursor.getCount() > 0){
            while(cursor.moveToNext()){
                Pergunta p = new Pergunta();
                p.setId(cursor.getLong(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_ID)));
                p.setTexto(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_TEXTO)));
                p.setTempo(cursor.getInt(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_TEMPO)));
                p.setOpt1(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT1)));
                p.setOpt2(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT2)));
                p.setOpt3(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT3)));
                p.setOpt4(cursor.getString(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_OPT4)));
                p.setCorreta(cursor.getInt(cursor.getColumnIndex(PerguntaDBHandler.COLUMN_CORRETA)));

                perguntas.add(p);
            }
        }
        // return All Perguntas
        db.close();
        return perguntas;
    }

    // Updating Disciplina
    public long updateDisciplina(Pergunta p) {

        ContentValues values = new ContentValues();
        values.put(PerguntaDBHandler.COLUMN_TEXTO, p.getTexto());
        values.put(PerguntaDBHandler.COLUMN_OPT1, p.getOpt1());
        values.put(PerguntaDBHandler.COLUMN_OPT2, p.getOpt2());
        values.put(PerguntaDBHandler.COLUMN_OPT3, p.getOpt3());
        values.put(PerguntaDBHandler.COLUMN_OPT4, p.getOpt4());
        values.put(PerguntaDBHandler.COLUMN_CORRETA, p.getCorreta());
        values.put(PerguntaDBHandler.COLUMN_TEMPO, p.getTempo());

        db = pdbh.getWritableDatabase();
        long id = db.update(PerguntaDBHandler.TABLE_PERGUNTA, values,
                PerguntaDBHandler.COLUMN_ID + "=?",
                new String[] { String.valueOf(p.getId())});

        db.close();

        // updating row
        return id;
    }

    // Deleting Pergunta
    public void removePergunta(Pergunta p) {

        db = pdbh.getWritableDatabase();
        db.delete(PerguntaDBHandler.TABLE_PERGUNTA,
                PerguntaDBHandler.COLUMN_ID + "=" + p.getId(),
                null);

        db.close();
    }

}

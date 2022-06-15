package com.example.pdmquiz2021.model.handler;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class PerguntaDBHandler extends
        SQLiteOpenHelper {
    private static final String NOME_BANCO = "quiz.db";
    private static final int VERSAO = 1;

    public static final String TABLE_PERGUNTA = "pergunta";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_TEXTO = "texto";
    public static final String COLUMN_OPT1 = "opt1";
    public static final String COLUMN_OPT2 = "opt2";
    public static final String COLUMN_OPT3 = "opt3";
    public static final String COLUMN_OPT4 = "opt4";
    public static final String COLUMN_CORRETA = "correta";
    public static final String COLUMN_TEMPO = "tempo";

    public PerguntaDBHandler(Context contexto){
        super(contexto, NOME_BANCO, null, VERSAO);
    }

    // Método necessário por conta do SQLiteOpenHelper
    // Vai especificar o CREATE TABLE
    public void onCreate(SQLiteDatabase db){
        String create = "CREATE TABLE " + TABLE_PERGUNTA + "("
                + COLUMN_ID + " integer primary key autoincrement, "
                + COLUMN_TEXTO + " text, "
                + COLUMN_OPT1 + " text, "
                + COLUMN_OPT2 + " text, "
                + COLUMN_OPT3 + " text, "
                + COLUMN_OPT4 + " text, "
                + COLUMN_CORRETA + " integer, "
                + COLUMN_TEMPO + " integer )";
        db.execSQL(create);
    }

    // Método necessário por conta do SQLiteOpenHelper
    // Vai especificar a atualização da TABELA
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion) {
        String drop = "drop table if exists " + TABLE_PERGUNTA;
        db.execSQL(drop);
        onCreate(db);
    }
}
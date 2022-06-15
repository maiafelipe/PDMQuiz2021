package com.example.pdmquiz2021.model;

public class Pergunta {
    private long id;
    private String texto;
    private String opt1;
    private String opt2;
    private String opt3;
    private String opt4;
    private int correta;
    private int tempo;

    public Pergunta() {
    }

    public Pergunta(long id, String texto, String opt1, String opt2, String opt3, String opt4, int correta, int tempo) {
        this.id = id;
        this.texto = texto;
        this.opt1 = opt1;
        this.opt2 = opt2;
        this.opt3 = opt3;
        this.opt4 = opt4;
        this.correta = correta;
        this.tempo = tempo;
    }

    public long getId() {
        return id;
    }

    public String getTexto() {
        return texto;
    }

    public String getOpt1() {
        return opt1;
    }

    public String getOpt2() {
        return opt2;
    }

    public String getOpt3() {
        return opt3;
    }

    public String getOpt4() {
        return opt4;
    }

    public int getCorreta() {
        return correta;
    }

    public int getTempo() {
        return tempo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public void setCorreta(int correta) {
        this.correta = correta;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }
}

package com.example.libretadehimnos;

public class Himno {
   private int id;
   private String himno;
   private String letra;

    public Himno(int i, String cile) {
    }

    public Himno(int id, String himno, String letra) {
        this.id = id;
        this.himno = himno;
        this.letra = letra;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHimno() {
        return himno;
    }

    public void setHimno(String himno) {
        this.himno = himno;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }
    @Override
    public String toString() {
        return id+"   "+himno;
    }

}

package com.company;

import java.util.Random;

public class Kriticar {
    private String ime;
    private String prezime;
    private int reputacija;



    public Kriticar(String ime, String prezime, int reputacija) throws Exception {
        if (reputacija > 100){
            throw new Exception("Reputacija ne sme da bude veca od 100");
        }
        this.ime = ime;
        this.prezime = prezime;
        this.reputacija = reputacija;
    }

    public void oceniFilm(Film film){
        Random rd = new Random();
        double randomOcena = rd.nextDouble() * 9 + 1;
        Kritika kritika = new Kritika(this, randomOcena);
        film.dodajKritiku(kritika);
    }

    public void pohvali (Kriticar kriticar){
        kriticar.reputacija += this.reputacija * 0.1;
    }


    @Override
    public String toString() {
        return "Kriticar{" +
                "ime='" + ime + '\'' +
                ", prezime='" + prezime + '\'' +
                ", reputacija=" + reputacija +
                '}';
    }

    public int getReputacija() {
        return reputacija;
    }

}

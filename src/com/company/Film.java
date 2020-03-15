package com.company;

import java.util.ArrayList;

public class Film implements Nominovan, Comparable <Film> {
    private String naziv;
    private int godina;
    private int trajanje;
    private double rejting;
    ArrayList<Kritika> kritike = new ArrayList<Kritika>();
    Zanr zanr;
    ArrayList<ClanEkipe> clanEkipe = new ArrayList<ClanEkipe>();


    public Film(String naziv, int godina, int trajanje, Reziser reziser, Zanr zanr) {
        this.naziv = naziv;
        this.godina = godina;
        this.trajanje = trajanje;
        this.zanr = zanr;
        dodajRezisera(reziser);

        if (trajanje <= 0){
            this.trajanje = 10;
        }
    }
    public boolean dodajGlumca(Glumac glumac){
        if (clanEkipe.contains(glumac)){
            return false;
        }
        if ((this.zanr == Zanr.ANIMIRANI || this.zanr == Zanr.MJUZIKL) && glumac.isLepGlas() == false) {
            return false;
        }
        clanEkipe.add(glumac);
        return true;
    }

    public boolean dodajRezisera(Reziser reziser){
        clanEkipe.add(reziser);
        reziser.setReziranihFilmova(reziser.getReziranihFilmova() + 1);
        return true;
    }
    public Reziser getPredstavnik(){
        Reziser najstarijiReziser = null;
        ArrayList<ClanEkipe> ekipe = this.clanEkipe;
        for (int i = 0; i < ekipe.size(); i++) {
            ClanEkipe clan = ekipe.get(i);
            if (clan instanceof Reziser) {
                if (najstarijiReziser == null) {
                    najstarijiReziser = (Reziser)clan;
                }
                else if (((Reziser)clan).getDatumRodjenja().after(najstarijiReziser.getDatumRodjenja())){
                    najstarijiReziser = (Reziser)clan;
                }
            }
        }
        return najstarijiReziser;
    }

    public double getRejting() {
        izracunajRejting();
        return rejting;
    }

    public boolean dodajKritiku(Kritika kritika){
        Kriticar kriticar = kritika.getKriticar();
        for (int i = 0; i < kritike.size(); i++){
            if(kritike.get(i).getKriticar() == kriticar){
                return false;
            }
        }
        kritike.add(kritika);
        return true;
    }

    @Override
    public void primiOskara() {
        Reziser predstavnik = getPredstavnik();
        predstavnik.primiOskara();
    }

    private void izracunajRejting(){
        double ukupno = 0.0;
        for ( int i = 0; i < kritike.size(); i++){
            ukupno = ukupno + kritike.get(i).getOcena() * kritike.get(i).getKriticar().getReputacija();
        }
        double srednjaOcena = ukupno / kritike.size();
        this.rejting = srednjaOcena;
    }


    @Override
    public int compareTo(Film film) {
        if(this.getRejting() < film.getRejting()) {
            return -1;
        }
        else if(this.getRejting() > film.getRejting()){
            return 1;
        }
        else{
            Reziser predstavnik1 = this.getPredstavnik();
            Reziser predstavnik2 = film.getPredstavnik();
            if (predstavnik1.getReziranihFilmova() < predstavnik2.getReziranihFilmova()){
                return -1;
            }
            else if(predstavnik1.getReziranihFilmova() > predstavnik2.getReziranihFilmova()){
                return 1;
            }
            else{
                return 0;
            }
        }

        }

    @Override
    public String toString() {
        return "Film{" +
                "naziv='" + naziv + '\'' +
                ", godina=" + godina +
                ", trajanje=" + trajanje +
                ", rejting=" + rejting +
                ", kritike=" + kritike +
                ", zanr=" + zanr +
                ", clanEkipe=" + clanEkipe +
                '}';
    }

    public int getTrajanje() {
        return trajanje;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public ArrayList<ClanEkipe> getClanEkipe() {
        return clanEkipe;
    }


}

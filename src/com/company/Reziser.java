package com.company;

import java.util.Date;

public class Reziser extends ClanEkipe implements Comparable<Reziser> {


    private int reziranihFilmova;

    public Reziser(String ime, String prezime, Date datumRodjenja, Pol pol, int reziranihFilmova) {
        super(ime, prezime, datumRodjenja, pol);
        this.reziranihFilmova = reziranihFilmova;
    }


    @Override
    public void odrziGovor() {
        System.out.println("Reziser odrzava govor " + this);
    }

    @Override
    public void primiOskara(){
        odrziGovor();
    }


    @Override
    public int compareTo(Reziser reziser) {
        if (reziranihFilmova < reziser.getReziranihFilmova()){
            return -1;
        }
        else if(reziranihFilmova == reziser.getReziranihFilmova()){
            return 0;
        }
        else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Reziser{" +
                super.toString() +
                "reziranihFilmova=" + reziranihFilmova +
                '}';
    }

    public int getReziranihFilmova() {
        return reziranihFilmova;
    }

    public void setReziranihFilmova(int reziranihFilmova) {
        this.reziranihFilmova = reziranihFilmova;
    }
}

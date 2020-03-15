package com.company;

import java.util.Date;
import java.util.Random;

public class Glumac extends ClanEkipe  {
    private boolean lepGlas;

    public Glumac(String ime, String prezime, Date datumRodjenja, Pol pol) {
        super(ime, prezime, datumRodjenja, pol);
        Random rd = new Random();
        lepGlas = rd.nextBoolean();
    }

    @Override
    public void odrziGovor() {
        System.out.println("Glumac odrzava govor");
    }

    @Override
    public void primiOskara(){
        Random rd = new Random();
        int vrednost = rd.nextInt(10);
        if (vrednost != 0){
            odrziGovor();
        }
    }

    @Override
    public String toString() {
        return "Glumac{" +
                "lepGlas=" + lepGlas +
                '}';
    }

    public boolean isLepGlas() {
        return lepGlas;
    }



}

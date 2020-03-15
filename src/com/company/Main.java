package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Glumac[] glumci = new Glumac[]{
                    new Glumac("Dusan", "Milenkovic",
                            simpleDateFormat.parse("1990-02-01"), Pol.MUSKI),
                    new Glumac("Milena", "Stanojcic",
                            simpleDateFormat.parse("1991-12-10"), Pol.ZENSKI),
                    new Glumac("Milan", "Milosevic",
                            simpleDateFormat.parse("1995-11-02"), Pol.MUSKI),
                    new Glumac("Radomir", "Torbica",
                            simpleDateFormat.parse("1989-04-16"), Pol.MUSKI),
                    new Glumac("Dusica", "Stankovic",
                            simpleDateFormat.parse("1957-12-11"), Pol.ZENSKI),
            };
            Reziser[] reziseri = new Reziser[]{
                    new Reziser("Milutin", "Stratimirovic",
                            simpleDateFormat.parse("1991-07-08"), Pol.MUSKI, 5),
                    new Reziser("Sara", "Tesic",
                            simpleDateFormat.parse("1970-11-16"), Pol.ZENSKI, 3),
                    new Reziser("Jovan", "Tomasevic",
                            simpleDateFormat.parse("1985-01-22"), Pol.MUSKI, 4),
                    new Reziser("Ugljesa", "Gajic",
                            simpleDateFormat.parse("1988-02-24"), Pol.MUSKI, 10),
                    new Reziser("Pantelija", "Stilet",
                            simpleDateFormat.parse("1967-11-30"), Pol.ZENSKI, 0),
            };
            Film[] filmovi = new Film[]{
                    new Film("Ram zute slike", 2018, 93,
                            reziseri[0], Zanr.DRAMA),
                    new Film("Iza crvenog zida", 2019, 126,
                            reziseri[1], Zanr.AKCIJA),
                    new Film("Zivot u ratu", 2017, 130,
                            reziseri[2], Zanr.DOKUMENTARNI),
                    new Film("Kraljica Freljorda", 2019, 116,
                            reziseri[3], Zanr.ANIMIRANI),
                    new Film("Kanjonski prolaz", 2015, 120,
                            reziseri[4], Zanr.VESTERN)
            };
            FilmskaAkademija akademija = new FilmskaAkademija();
            filmovi[0].dodajGlumca(glumci[3]);
            filmovi[0].dodajGlumca(glumci[1]);
            filmovi[1].dodajGlumca(glumci[1]);
            filmovi[1].dodajGlumca(glumci[3]);
            filmovi[2].dodajGlumca(glumci[0]);
            filmovi[2].dodajGlumca(glumci[1]);
            filmovi[3].dodajGlumca(glumci[4]);
            filmovi[3].dodajGlumca(glumci[3]);
            filmovi[4].dodajGlumca(glumci[4]);
            filmovi[4].dodajGlumca(glumci[0]);
            akademija.nominuj(glumci[2]);
            akademija.nominuj(glumci[3]);
            akademija.nominuj(filmovi[1]);
            akademija.nominuj(filmovi[2]);
            akademija.nominuj(reziseri[3]);
            akademija.nominuj(reziseri[0]);
            akademija.odrziDodelu();
            akademija.objaviNominacije();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

package com.company;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class FilmskaAkademija {
    static final double MIN_REJTING = 0;
    ArrayList<Film> filmNom = new ArrayList<Film>();
    ArrayList<Glumac> muskaUlogaNom = new ArrayList<Glumac>();
    ArrayList<Glumac> zenskaUlogaNom = new ArrayList<Glumac>();
    ArrayList<Reziser> reziserNom = new ArrayList<Reziser>();

    public FilmskaAkademija() {
    }

    public boolean nominuj(Nominovan nominovan){
        if(nominovan instanceof Glumac){
            Glumac glumac = (Glumac)nominovan;
            if(glumac.getPol() == Pol.MUSKI && !muskaUlogaNom.contains(glumac)){
                muskaUlogaNom.add(glumac);
                return true;
            }
            else if(glumac.getPol() == Pol.ZENSKI && !zenskaUlogaNom.contains(glumac)){
                zenskaUlogaNom.add(glumac);
                return true;
            }
        }
        else if(nominovan instanceof Reziser){
            Reziser reziser = (Reziser) nominovan;
            if(!reziserNom.contains(reziser)){
                reziserNom.add(reziser);
                return true;
            }
        }
        else if(nominovan instanceof Film){
            Film film = (Film)nominovan;
            if (filmNom.contains(film)) {
                return false;
            }
            int muskiClanovi = 0;
            int zenskiClanovi = 0;
            for(ClanEkipe clanEkipe: film.getClanEkipe()){
                if(clanEkipe.getPol() == Pol.MUSKI){
                    muskiClanovi++;
                }
                else if(clanEkipe.getPol() == Pol.ZENSKI){
                    zenskiClanovi++;
                }
            }
            if (muskiClanovi == 0 || zenskiClanovi == 0) {
                return false;
            }
            if (film.getRejting() < MIN_REJTING) {
                return false;
            }
            if(film.getTrajanje() < 40){
                return false;
            }
            if((film.zanr == Zanr.BIOGRAFSKI || film.zanr == Zanr.DOKUMENTARNI) && film.getTrajanje() >= 150){
                return false;
            }
            filmNom.add(film);
            return true;
        }

        return false;
    }

    private String getNominacijeIzvestaj(){
        Collections.sort(filmNom);
        Collections.sort(reziserNom);
        return "Filmovi " + filmNom +
                ", Muske uloge " + muskaUlogaNom +
                ", Zenske uloge " + zenskaUlogaNom +
                ", Reziseri " + reziserNom;
    }


    public void objaviNominacije(){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter("nominacije.txt", "UTF-8");
            writer.println(getNominacijeIzvestaj());
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void ispisiStatistikuFilmova(){
        HashMap<Zanr, Integer> statistika = new HashMap<Zanr, Integer>();
        for (Zanr zanr: Zanr.values()){
            statistika.put(zanr, 0);
        }
        for (Film film: filmNom){
            int brPrikaza = statistika.get(film.getZanr());
            statistika.put(film.getZanr(), brPrikaza + 1);
        }
        for (Film film: filmNom){
            int brPrikaza = statistika.get(film.getZanr());
            System.out.println(film.getZanr() + " - " + brPrikaza);
        }

    }

    public void odrziDodelu(){
        HashMap<Zanr, ArrayList<Film>> statistika = new HashMap<Zanr, ArrayList<Film>>();
        for (Zanr zanr: Zanr.values()){
            statistika.put(zanr, new ArrayList<Film>());
        }
        for (Film film: filmNom){
            ArrayList<Film> listaFilmova = statistika.get(film.getZanr());
            listaFilmova.add(film);
        }
        for (Film film: filmNom){
            ArrayList<Film> listaFilmova = statistika.get(film.getZanr());
            int brPrikaza = listaFilmova.size();
            if (brPrikaza == 0){
                continue;
            }
            Random rd = new Random();
            int index = rd.nextInt(brPrikaza);
            Film dobitnik = listaFilmova.get(index);
            dobitnik.primiOskara();


        }

    }

}

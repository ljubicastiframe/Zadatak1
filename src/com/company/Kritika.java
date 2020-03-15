package com.company;

public class Kritika {
    private Kriticar kriticar;
    private double ocena;

    public Kritika(Kriticar kriticar, double ocena) {
        this.kriticar = kriticar;
        this.ocena = ocena;
    }

    @Override
    public String toString() {
        return "Kritika{" +
                "kriticar=" + kriticar +
                ", ocena=" + ocena +
                '}';
    }

    public Kriticar getKriticar() {
        return kriticar;
    }

    public double getOcena() {
        return ocena;
    }
}

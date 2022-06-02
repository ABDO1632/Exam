package com.example.exam;

public class Entreprise {
    private int ID;
    private String RaisonSociale,Adresse;
    private double Capitale;
    public Entreprise() {

    }
    public Entreprise( String raisonSociale, String adresse, double capitale) {
        RaisonSociale = raisonSociale;
        Adresse = adresse;
        Capitale = capitale;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getRaisonSociale() {
        return RaisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        RaisonSociale = raisonSociale;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String adresse) {
        Adresse = adresse;
    }

    public double getCapitale() {
        return Capitale;
    }

    public void setCapitale(double capitale) {
        Capitale = capitale;
    }
}

package com.example.tp_listviewspinnerimageview;

import java.io.Serializable;
import java.util.ArrayList;

public class Country implements Serializable {

    private int flagId;
    private String countryName;
    private String capital;
    private Continent continent;


    public Country(int flagId,String countryName,String capital,Continent continent){
        this.flagId=flagId;
        this.countryName=countryName;
        this.capital=capital;
        this.continent=continent;
    }

    public int getFlagId() {
        return flagId;
    }

    public void setFlagId(int flagId) {
        this.flagId = flagId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }


    public Continent getContinent() {
        return continent;
    }

    public void setContinent(Continent continent) {
        this.continent = continent;
    }


    public static ArrayList<Country> getCountryWithContinent(ArrayList<Country> countries,Continent continent){
        ArrayList<Country> c = new ArrayList<>();
        for (Country value: countries) {
            if(value.continent.equals(continent)){
                c.add(value);
            }
        }
        return c;
    }
}

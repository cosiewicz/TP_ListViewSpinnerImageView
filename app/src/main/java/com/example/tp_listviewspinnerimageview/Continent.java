package com.example.tp_listviewspinnerimageview;

import android.util.Log;

public class Continent {

    private int id;
    private String name;


    public Continent(int id,String name){
        this.id=id;
        this.name=name;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String toString(){
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if(o.getClass().getClass().equals(this)){
            Log.i("debug","true");
        }else{
            Log.i("debug","false");
        }
        return true;
    }

}

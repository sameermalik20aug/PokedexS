package com.example.hp.lesson10;

public class sprites {

   private String front_shiny,back_shiny;

    public sprites(String front_shiny, String back_shiny) {
        this.front_shiny = front_shiny;
        this.back_shiny = back_shiny;
    }

    public String getFront_shiny() {
        return front_shiny;
    }

    public void setFront_shiny(String front_shiny) {
        this.front_shiny = front_shiny;
    }

    public String getBack_shiny() {
        return back_shiny;
    }

    public void setBack_shiny(String back_shiny) {
        this.back_shiny = back_shiny;
    }
}

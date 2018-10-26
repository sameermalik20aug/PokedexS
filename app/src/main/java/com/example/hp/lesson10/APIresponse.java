package com.example.hp.lesson10;

import java.util.ArrayList;

public class APIresponse {

    private ArrayList<stats> stats;
    private String name;
    private int weight;
    private int height;
    private int id;
    private ArrayList<types> types;
    private sprites sprites;

    public APIresponse(ArrayList<com.example.hp.lesson10.stats> stats, String name, int weight, int height, int id, ArrayList<types> types, sprites sprites) {
        this.stats = stats;
        this.name = name;
        this.weight = weight;
        this.height = height;
        this.id = id;
        this.types = types;
        this.sprites = sprites;
    }

    public ArrayList<com.example.hp.lesson10.stats> getStats() {
        return stats;
    }

    public void setStats(ArrayList<com.example.hp.lesson10.stats> stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<types> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<types> types) {
        this.types = types;
    }

    public sprites getSprites() {
        return sprites;
    }

    public void setSprites(sprites sprites) {
        this.sprites = sprites;
    }
}
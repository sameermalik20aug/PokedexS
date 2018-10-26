package com.example.hp.lesson10;

public class stats {

    private int effort;
    private int base_stat;
    private stat stat;

    public stats(int effort, int base_stat, com.example.hp.lesson10.stat stat) {
        this.effort = effort;
        this.base_stat = base_stat;
        this.stat = stat;
    }

    public int getEffort() {
        return effort;
    }

    public void setEffort(int effort) {
        this.effort = effort;
    }

    public int getBase_stat() {
        return base_stat;
    }

    public void setBase_stat(int base_stat) {
        this.base_stat = base_stat;
    }

    public com.example.hp.lesson10.stat getStat() {
        return stat;
    }

    public void setStat(com.example.hp.lesson10.stat stat) {
        this.stat = stat;
    }
}

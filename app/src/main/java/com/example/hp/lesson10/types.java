package com.example.hp.lesson10;

public class types {
    private int slot;
    private type type;

    public types(int slot, type type) {
        this.slot = slot;
        this.type = type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public type getType() {
        return type;
    }

    public void setType(type type) {
        this.type = type;
    }
}

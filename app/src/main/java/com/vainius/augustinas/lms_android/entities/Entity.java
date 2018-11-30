package com.vainius.augustinas.lms_android.entities;


public abstract class Entity {
    private int id;
    private String name;

    public Entity() {
    }

    Entity(int id, String name){
        this.id = id;
        this.name = name;
    }
    Entity(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    };

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

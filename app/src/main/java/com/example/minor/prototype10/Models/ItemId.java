package com.example.minor.prototype10.Models;
//
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ItemId extends RealmObject {
    @PrimaryKey
    private String Name;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

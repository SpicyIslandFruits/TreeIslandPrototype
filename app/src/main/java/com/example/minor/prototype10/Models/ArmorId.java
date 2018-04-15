package com.example.minor.prototype10.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class ArmorId extends RealmObject{
    @PrimaryKey
    private String Name;

    private int armorId;

    public int getArmorId() {
        return armorId;
    }

    public void setArmorId(int armorId) {
        this.armorId = armorId;
    }
}

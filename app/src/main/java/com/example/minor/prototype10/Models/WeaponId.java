package com.example.minor.prototype10.Models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class WeaponId extends RealmObject{
    @PrimaryKey
    private String Name;

    private int weaponId;

    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

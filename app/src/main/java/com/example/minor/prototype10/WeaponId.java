package com.example.minor.prototype10;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class WeaponId extends RealmObject{
    @PrimaryKey
    private String weapon;

    private int weaponId;

    public int getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(int weaponId) {
        this.weaponId = weaponId;
    }
}

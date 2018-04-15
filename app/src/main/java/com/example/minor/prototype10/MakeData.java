package com.example.minor.prototype10;

import com.example.minor.prototype10.Weapons.WeaponInterface;
import com.example.minor.prototype10.Weapons.SampleWeapon;
import com.example.minor.prototype10.Weapons.SampleWeapon2;

public class MakeData {
    public void makePlayerStatusFromLevel(int level){

    }

    public void makeEnemyFromId(int id){

    }

    public WeaponInterface makeWeaponFromId(int id){
        WeaponInterface weapon = new SampleWeapon();
        switch (id){
            case 0:
                weapon = new SampleWeapon();
                break;
            case 1:
                weapon = new SampleWeapon2();
                break;
        }
        return weapon;
    }

    public void makeArmorFromId(int id){

    }

    public void makeItemFromId(int id){

    }
}

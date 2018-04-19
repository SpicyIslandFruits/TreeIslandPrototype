package com.example.minor.prototype10;

import com.example.minor.prototype10.Weapons.SampleWeapon;
import com.example.minor.prototype10.Weapons.SampleWeapon2;
import com.example.minor.prototype10.Weapons.SuperWeapon;

public class MakeData {

    public void makePlayerStatusFromLevel(int level){

    }

    public void makePlayerSkillFromId(int id){}

    public void makeEnemyFromId(int id){

    }

    public SuperWeapon makeWeaponFromId(int id){
        int[] tempAllStatus = new int[11];
        SuperWeapon weapon = new SampleWeapon();
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

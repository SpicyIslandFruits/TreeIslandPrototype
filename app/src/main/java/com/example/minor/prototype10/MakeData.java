package com.example.minor.prototype10;

import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.Weapons.SampleWeapon;
import com.example.minor.prototype10.Weapons.SampleWeapon2;
import com.example.minor.prototype10.Weapons.SuperWeapon;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBossRoomButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickDungeonButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickInnButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickTownButton;

public class MakeData {

    public SuperOnClickMapButton makeMapFromPosition(int position){
        SuperOnClickMapButton onClickMapButton = new OnClickInnButton();
        switch (position){
            case 0:
                onClickMapButton = new OnClickInnButton();
                break;
            case 1:
                onClickMapButton = new OnClickTownButton();
                break;
            case 2:
                onClickMapButton = new OnClickDungeonButton();
                break;
            case 3:
                onClickMapButton = new OnClickBossRoomButton();
                break;
        }
        return onClickMapButton;
    }

    public void makePlayerStatusFromLevel(int level){

    }

    public void makePlayerSkillFromId(int id){}

    public void makeEnemyFromId(int id){

    }

    public SuperWeapon makeWeaponFromId(int id){
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

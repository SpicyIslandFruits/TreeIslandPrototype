package com.example.minor.prototype10;

import com.example.minor.prototype10.OnClickMapButtons.SuperOnClickMapButton;
import com.example.minor.prototype10.Weapons.SampleWeapon;
import com.example.minor.prototype10.Weapons.SampleWeapon2;
import com.example.minor.prototype10.Weapons.SuperWeapon;
import com.example.minor.prototype10.OnClickMapButtons.OnClickBossRoomButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickDungeonButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickInnButton;
import com.example.minor.prototype10.OnClickMapButtons.OnClickTownButton;

/**
 * パッケージにクラスを追加したらここにswitch文を追加する
 * どのメソッドもreturn分を含むのでvoidを変える
 * 武器防具は重複不可、同一武器を拾った場合は捨てたり換金したり
 * アイテムもPrimaryKeyが名前になっているのでこのままだと重複不可あとで何とかする
 */

public class MakeData {

    //マップを追加したときはここに書く
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

    //レベルを受け取ってステータスを生成しRealmに渡す処理を書く
    //式によって主人公のステータスを生成する
    //前のレベルのステータス × 1.1 ± 乱数.など
    public void makePlayerStatusFromLevel(int level){

    }

    //プレイヤースキルを追加した場合はここに書く
    public void makePlayerSkillFromId(int id){}

    public void makeEnemyFromId(int id){

    }

    //武器を追加した場合はここに書く
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

    //防具を追加した場合はここに書く
    public void makeArmorFromId(int id){

    }

    //アイテムを追加した場合はここに書く
    public void makeItemFromId(int id){

    }
}

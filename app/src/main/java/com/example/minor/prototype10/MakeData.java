package com.example.minor.prototype10;

import com.example.minor.prototype10.Enemys.EnemyInterface;
import com.example.minor.prototype10.Weapons.WeaponInterface;
import com.example.minor.prototype10.Weapons.SampleWeapon;
import com.example.minor.prototype10.Weapons.SampleWeapon2;

/*
* このクラスのメソッドは長くなるので閉じておく
* どのメソッドもreturn分を含むのでvoidを変える
* 武器防具は重複不可、同一武器を拾った場合は捨てたり換金したり
* アイテムもPrimaryKeyが名前になっているのでこのままだと重複不可あとで何とかする
*/

public class MakeData {

    //レベルを受け取ってステータスを生成し、Realmに渡す処理を書く
    //式によって主人公のステータスを生成する
    //前のレベルのステータス × 1.1 ± 乱数.など
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

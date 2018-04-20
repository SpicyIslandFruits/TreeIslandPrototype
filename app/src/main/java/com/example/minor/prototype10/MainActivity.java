package com.example.minor.prototype10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;

import io.realm.Realm;

/**
 * 武器の追加方法(防具、アイテムも同様)
 * 1.武器クラスをWeaponsパッケージに追加、メソッドの実装、ゲッターを見て適当なメンバの追加
 * 2.MakeDataクラスのswitch文にcaseを追加
 * 3.武器のidをRealmList<Weapon>にcreateObjectする処理の作成
 * マップの追加方法
 * 1.MapInfoクラス内にcreate(マップ名)メソッドの追加、マップ内での処理を書く
 * 2.MapInfoクラス内にonClickを実装したクラスonClick(マップ名)Buttonを書く
 * 3.追加するマップとつながっているマップのcreate(マップ名)メソッドを編集する
 */

public class MainActivity extends AppCompatActivity{
    Realm realm;
    MapInfo mapInfo;
    PlayerInfo playerInfo;
    ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageButton = (ImageButton) findViewById(R.id.status_button);
        realm = Realm.getDefaultInstance();
        mapInfo = new MapInfo(this);
        createSaveData();
        mapInfo.onGameStart();
    }

    public void onClickStatus(View view){
        startActivity(new Intent(this, StatusActivity.class));
    }

    //実際はmakePlayerStatusFromLevelメソッドにLevel0を代入して初期化します
    public void createSaveData(){
        try {
            realm.beginTransaction();
            playerInfo = realm.createObject(PlayerInfo.class, new String("player"));
            playerInfo.setPlayerLevel(0);
            playerInfo.setPosition(1);
            playerInfo.setMoney(100);
            playerInfo.setMaxHP(100);
            playerInfo.setHP(100);
            playerInfo.setMaxMP(100);
            playerInfo.setMP(100);
            playerInfo.setSP(10);
            playerInfo.setfSP(10);
            playerInfo.setATK(10);
            playerInfo.setfATK(15);
            playerInfo.setDF(100);
            playerInfo.setfDF(100);
            playerInfo.setLUK(100);
            playerInfo.setfLUK(100);
            playerInfo.setWeaponId(0);
            WeaponId weaponId = realm.createObject(WeaponId.class, new String("sampleWeapon"));
            weaponId.setWeaponId(0);
            playerInfo.getWeaponIds().add(weaponId);
            weaponId = realm.createObject(WeaponId.class, new String("SampleWeapon2"));
            weaponId.setWeaponId(1);
            playerInfo.getWeaponIds().add(weaponId);
            realm.commitTransaction();
        }catch (Exception e){
            realm.cancelTransaction();
        }
    }

    public void onDestroy(){
        super.onDestroy();
        realm.close();
    }
}

package com.example.minor.prototype10;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Models.WeaponId;
import com.example.minor.prototype10.Weapons.SampleWeapon;

import io.realm.Realm;
import io.realm.RealmResults;

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
            playerInfo.setSP(100);
            playerInfo.setATK(100);
            playerInfo.setDF(100);
            playerInfo.setLUK(100);
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

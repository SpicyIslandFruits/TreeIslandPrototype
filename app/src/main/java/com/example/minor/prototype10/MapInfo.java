package com.example.minor.prototype10;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.minor.prototype10.Models.PlayerInfo;

import io.realm.Realm;

/**
 * Created by minor on 2018/04/06.
 */

public class MapInfo{
    Realm realm;
    PlayerInfo playerInfo;
    private AppCompatActivity mMain;
    private Context mContext;
    TextView mainText;
    ImageButton imageButton1, imageButton2;
    int position;

    public MapInfo(AppCompatActivity main) {
        mMain = main;
        mainText = (TextView) main.findViewById(R.id.main_text);
        imageButton1 = (ImageButton) main.findViewById(R.id.imageButton1);
        imageButton2 = (ImageButton) main.findViewById(R.id.imageButton2);
    }

    public void onGameStart() {
        realm = Realm.getDefaultInstance();
        getData();

        switch (position){
            case 0:
                createInn();
                break;
            case 1:
                createTown();
                break;
            case 2:
                createDungeon();
                break;
            case 3:
                createBossRoom();
                break;
        }
    }

    public void getData(){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                playerInfo = realm.where(PlayerInfo.class).findFirst();
                position = playerInfo.getPosition();
            }
        });
    }

    public void saveData(){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                playerInfo = realm.where(PlayerInfo.class).findFirst();
                playerInfo.setPosition(position);
            }
        });
    }

    public class OnClickTownButton implements View.OnClickListener{
        public void onClick(View view){
            createTown();
        }
    }

    public class OnClickBossRoomButton implements View.OnClickListener{
        public void onClick(View view) {
            createBossRoom();
        }
    }

    public class OnClickInnButton implements View.OnClickListener{
        public void onClick(View view){
            createInn();
        }
    }

    public class OnClickDungeonButton implements View.OnClickListener{
        public void onClick(View view) {
            createDungeon();
        }
    }

    public void createTown(){
        OnClickDungeonButton onClickDungeonButton = new OnClickDungeonButton();
        imageButton1.setOnClickListener(onClickDungeonButton);
        OnClickInnButton onClickInnButton = new OnClickInnButton();
        imageButton2.setOnClickListener(onClickInnButton);
        mainText.setText("ここは街です");
        position = 1;
        saveData();
    }

    public void createDungeon(){
        OnClickBossRoomButton onClickBossRoomButton = new OnClickBossRoomButton();
        imageButton1.setOnClickListener(onClickBossRoomButton);
        OnClickTownButton onClickTownButton = new OnClickTownButton();
        imageButton2.setOnClickListener(onClickTownButton);
        mainText.setText("ここはダンジョンです");
        position = 2;
        saveData();
    }

    public void createInn(){
        OnClickTownButton onClickTownButton = new OnClickTownButton();
        imageButton1.setOnClickListener(onClickTownButton);
        imageButton2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {mainText.setText("宿泊機能は未実装です");}
            });
        mainText.setText("ここは宿です");
        position = 0;
        saveData();
    }

    public void createBossRoom(){
        imageButton1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {mMain.startActivity(new Intent(mMain, BattleActivity.class));}
            });
        OnClickDungeonButton onClickDungeonButton = new OnClickDungeonButton();
        imageButton2.setOnClickListener(onClickDungeonButton);
        mainText.setText("ここはボス部屋です");
        position = 3;
        saveData();
    }
}
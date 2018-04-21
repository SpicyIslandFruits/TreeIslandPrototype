package com.example.minor.prototype10.OnClickMapButtons;

import android.view.View;

public class OnClickDungeonButton extends SuperOnClickMapButton{
    @Override
    public void onClick(View v) {
        createMap();
    }
    public void createMap(){
        OnClickBossRoomButton onClickBossRoomButton = new OnClickBossRoomButton();
        imageButton1.setOnClickListener(onClickBossRoomButton);
        OnClickTownButton onClickTownButton = new OnClickTownButton();
        imageButton2.setOnClickListener(onClickTownButton);
        mainText.setText("ここはダンジョンです");
        position = 2;
        savePosition();
    }
}

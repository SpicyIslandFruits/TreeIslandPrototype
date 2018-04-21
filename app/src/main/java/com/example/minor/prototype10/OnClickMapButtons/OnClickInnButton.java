package com.example.minor.prototype10.OnClickMapButtons;
//
import android.view.View;

public class OnClickInnButton extends SuperOnClickMapButton{
    @Override
    public void onClick(View v) {
        createMap();
    }
    public void createMap(){
        OnClickTownButton onClickTownButton = new OnClickTownButton();
        imageButton1.setOnClickListener(onClickTownButton);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {mainText.setText("宿泊機能は未実装です");}
        });
        mainText.setText("ここは宿です");
        position = 0;
        savePosition();
    }
}

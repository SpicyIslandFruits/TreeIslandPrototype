package com.example.minor.prototype10;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import io.realm.Realm;

//プログレスバーには一時的に値を入れてあります
public class BattleActivity extends AppCompatActivity {
    Realm realm;
    ProgressBar hpBar, mpBar, spBar;
    SimpleGaugeView breakGage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        realm = Realm.getDefaultInstance();
        hpBar = (ProgressBar) findViewById(R.id.hp_bar);
        mpBar = (ProgressBar) findViewById(R.id.mp_bar);
        spBar = (ProgressBar) findViewById(R.id.sp_bar);
        breakGage = (SimpleGaugeView) findViewById(R.id.break_gage);

        hpBar.setMax(100);
        hpBar.setProgress(80);
        mpBar.setMax(100);
        mpBar.setProgress(100-90);
        spBar.setMax(100);
        spBar.setProgress(100-60);
        breakGage.setData(90, "%", ContextCompat.getColor(this, R.color.colorAccent));
    }
}

package com.example.minor.prototype10;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import io.realm.Realm;

public class BattleActivity extends AppCompatActivity {
    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        realm = Realm.getDefaultInstance();
    }
}

package com.example.minor.prototype10.StatusActivityFragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.R;

import io.realm.Realm;

public class StatusFragment extends Fragment {
    private Realm realm;
    private PlayerInfo playerInfo;
    private TextView moneyValue, hpValue, mpValue, spValue, dfValue, lukValue, atkValue;
    private int money;
    private int maxHP;
    private int HP;
    private int maxMP;
    private int MP;
    private int SP;
    private int ATK;
    private int DF;
    private int LUK;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        realm = Realm.getDefaultInstance();
        getStatus();
        return inflater.inflate(R.layout.fragment_status, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        moneyValue = (TextView) view.findViewById(R.id.money_value);
        hpValue = (TextView) view.findViewById(R.id.hp_value);
        mpValue = (TextView) view.findViewById(R.id.mp_value);
        spValue = (TextView) view.findViewById(R.id.sp_value);
        atkValue = (TextView) view.findViewById(R.id.atk_value);
        dfValue = (TextView) view.findViewById(R.id.df_value);
        lukValue = (TextView) view.findViewById(R.id.luk_value);
        moneyValue.setText(String.valueOf(money) + "ゴールド");
        hpValue.setText(String.valueOf(HP) + "/" + String.valueOf(maxHP));
        mpValue.setText(String.valueOf(MP) + "/" + String.valueOf(maxMP));
        spValue.setText(String.valueOf(SP));
        atkValue.setText(String.valueOf(ATK));
        dfValue.setText(String.valueOf(DF));
        lukValue.setText(String.valueOf(LUK));

    }

    public void getStatus(){
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                playerInfo = realm.where(PlayerInfo.class).findFirst();
                money = playerInfo.getMoney();
                maxHP = playerInfo.getMaxHP();
                HP = playerInfo.getHP();
                maxMP = playerInfo.getMaxMP();
                MP = playerInfo.getMP();
                SP = playerInfo.getSP();
                ATK = playerInfo.getATK();
                DF = playerInfo.getDF();
                LUK = playerInfo.getLUK();
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        realm.close();
    }
}

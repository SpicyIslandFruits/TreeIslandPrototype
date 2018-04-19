package com.example.minor.prototype10;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.minor.prototype10.Enemys.SampleBoss;
import com.example.minor.prototype10.Enemys.SuperEnemy;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Weapons.SuperWeapon;

import io.realm.Realm;

public class BattleActivity extends AppCompatActivity {
    Realm realm;
    PlayerInfo playerInfo;
    ProgressBar hpBar, mpBar, spBar, enemyHpBar;
    GaugeView breakGage;
    TextView battleText;
    MakeData makeData;
    int weaponId;
    int enemyId;
    SuperEnemy enemy;
    SuperWeapon weapon;
    ImageButton decisionButton, normalAttackButton,skillButton1, skillButton2, skillButton3;
    ImageButton playerSkill1Button, playerSkill2Button, playerSkill3Button, playerSkill4Button;
    public int[] tempAllStatus;
    private int hp, mp, sp, atk, df, luk, enemyHp, enemySp, enemyAtk, enemyDf, enemyLuk;
    private int turnCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        makeData = new MakeData();
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        weaponId = playerInfo.getWeaponId();
        weapon = makeData.makeWeaponFromId(weaponId);
        enemy = new SampleBoss();
        tempAllStatus = new int[11];
        hpBar = (ProgressBar) findViewById(R.id.hp_bar);
        mpBar = (ProgressBar) findViewById(R.id.mp_bar);
        spBar = (ProgressBar) findViewById(R.id.sp_bar);
        enemyHpBar = (ProgressBar) findViewById(R.id.enemy_hp_bar);
        breakGage = (GaugeView) findViewById(R.id.break_gage);
        battleText = (TextView) findViewById(R.id.battle_text);
        decisionButton = (ImageButton) findViewById(R.id.decision_button);
        normalAttackButton = (ImageButton) findViewById(R.id.normal_attack);
        skillButton1 = (ImageButton) findViewById(R.id.skill1);
        decisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDecision();
                executeBattle();
            }
        });
        normalAttackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(0);
            }
        });
        skillButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(1);
            }
        });
        breakGage.setData(50, "%", ContextCompat.getColor(this, R.color.colorAccent), 50, true);
        tempAllStatus[0] = hp = playerInfo.getHP();
        tempAllStatus[1] = mp = playerInfo.getMP();
        tempAllStatus[2] = sp = playerInfo.getfSP();
        tempAllStatus[3] = atk = playerInfo.getfATK();
        tempAllStatus[4] = df = playerInfo.getfDF();
        tempAllStatus[5] = luk = playerInfo.getfLUK();
        tempAllStatus[6] = enemyHp = enemy.getHp();
        tempAllStatus[7] = enemySp = enemy.getSp();
        tempAllStatus[8] = enemyAtk = enemy.getAtk();
        tempAllStatus[9] = enemyDf = enemy.getDf();
        tempAllStatus[10] = enemyLuk = enemy.getLuk();
        hpBar.setMax(100);
        mpBar.setMax(100);
        spBar.setMax(100);
        enemyHpBar.setMax(100);
        spBar.setProgress(100-60);
        mpBar.setProgress(100-90);
        hpBar.setProgress(100);
        enemyHpBar.setProgress(100);
    }

    void setPlayerBehavior(int num) {
        switch (num){
            case 0:
                tempAllStatus[6] = tempAllStatus[6] - (tempAllStatus[3]);
                break;
            case 1:
                tempAllStatus = weapon.skill1(tempAllStatus);
                break;
            case 2:
                tempAllStatus = weapon.skill2(tempAllStatus);
                break;
            case 3:
                tempAllStatus = weapon.skill3(tempAllStatus);
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
        }
    }

    void onDecision(){
        tempAllStatus = enemy.setEnemyBehavior(tempAllStatus);
        hp = tempAllStatus[0];
        mp = tempAllStatus[1];
        sp = tempAllStatus[2];
        atk = tempAllStatus[3];
        df = tempAllStatus[4];
        luk = tempAllStatus[5];
        enemyHp = tempAllStatus[6];
        enemySp = tempAllStatus[7];
        enemyAtk = tempAllStatus[8];
        enemyDf = tempAllStatus[9];
        enemyLuk = tempAllStatus[10];
    }

    void executeBattle(){
        battleText.setText("自分のHPは" + String.valueOf(hp) + "敵のHPは" + String.valueOf(enemyHp));
        hpBar.setProgress(hp);
        enemyHpBar.setProgress(enemyHp);
        if(hp<=0 ||enemyHp<=0){
            finish();
        }
    }
}

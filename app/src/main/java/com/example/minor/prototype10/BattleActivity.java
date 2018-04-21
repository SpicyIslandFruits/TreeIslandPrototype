package com.example.minor.prototype10;
//
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
import com.example.minor.prototype10.PlayerSkill.SampleSkill;
import com.example.minor.prototype10.PlayerSkill.SuperSkill;
import com.example.minor.prototype10.Weapons.SuperWeapon;

import io.realm.Realm;

public class BattleActivity extends AppCompatActivity {
    private Realm realm;
    private PlayerInfo playerInfo;
    private ProgressBar hpBar, mpBar, spBar, enemyHpBar;
    private GaugeView breakGage;
    private TextView battleText;
    private MakeData makeData;
    private int weaponId;
    private int enemyId;
    private SuperEnemy enemy;
    private SuperWeapon weapon;
    private SuperSkill playerSkill1, playerSkill2, playerSkill3, playerSkill4;
    private ImageButton decisionButton, normalAttackButton,skillButton1, skillButton2, skillButton3;
    private ImageButton playerSkill1Button, playerSkill2Button, playerSkill3Button, playerSkill4Button;
    private int[] tempAllStatus;
    private int maxHp, hp, maxMp, mp, sp, atk, df, luk, enemyHp, enemySp, enemyAtk, enemyDf, enemyLuk;
    private int turnCount = 0, tempTurnCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        makeData = new MakeData();
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        weaponId = playerInfo.getWeaponId();
        weapon = makeData.makeWeaponFromId(weaponId);
        playerSkill1 = new SampleSkill();
        playerSkill2 = new SampleSkill();
        playerSkill3 = new SampleSkill();
        playerSkill4 = new SampleSkill();
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
        skillButton2 = (ImageButton) findViewById(R.id.skill2);
        skillButton3 = (ImageButton) findViewById(R.id.skill3);
        playerSkill1Button = (ImageButton) findViewById(R.id.player_skill1);
        playerSkill2Button = (ImageButton) findViewById(R.id.player_skill2);
        playerSkill3Button = (ImageButton) findViewById(R.id.player_skill3);
        playerSkill4Button = (ImageButton) findViewById(R.id.player_skill4);
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
        skillButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(2);
            }
        });
        skillButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(3);
            }
        });
        playerSkill1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(4);
            }
        });
        playerSkill2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(5);
            }
        });
        playerSkill3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(6);
            }
        });
        playerSkill4Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPlayerBehavior(7);
            }
        });
        inputAllStatus();
    }

    void setPlayerBehavior(int num) {
        if(turnCount != tempTurnCount){
            startNewTurn();
            executeTempBattle(num);
            tempTurnCount = turnCount;
        }else{
            executeTempBattle(num);
        }
    }

    void onDecision(){
        tempAllStatus = enemy.setEnemyBehavior(tempAllStatus);
        hp = tempAllStatus[0];
        mp = tempAllStatus[1];
        sp = tempAllStatus[2];
        sp = playerInfo.getfSP();
        atk = tempAllStatus[3];
        df = tempAllStatus[4];
        luk = tempAllStatus[5];
        enemyHp = tempAllStatus[6];
        enemySp = tempAllStatus[7];
        enemyAtk = tempAllStatus[8];
        enemyDf = tempAllStatus[9];
        enemyLuk = tempAllStatus[10];
        turnCount++;
    }

    void executeBattle(){
        battleText.setText("自分のHPは" + String.valueOf(hp) + "敵のHPは" + String.valueOf(enemyHp));
        hpBar.setProgress(hp);
        enemyHpBar.setProgress(enemyHp);
        spBar.setProgress(0);
        mpBar.setProgress(maxMp-mp);
        if(hp<=0 ||enemyHp<=0){
            finish();
        }
    }

    void executeTempBattle(int num){
        switch (num){
            case 0:
                if(tempAllStatus[2] - 3 >= 0) {
                    tempAllStatus[6] = tempAllStatus[6] - tempAllStatus[3];
                    tempAllStatus[2] = tempAllStatus[2] - (int)sp/3;
                    spBar.setProgress(sp-tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 1:
                if(weapon.skill1(tempAllStatus)[2] >= 0){
                    tempAllStatus = weapon.skill1(tempAllStatus);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 2:
                if(weapon.skill2(tempAllStatus)[2] >= 0){
                    tempAllStatus = weapon.skill2(tempAllStatus);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 3:
                if(weapon.skill3(tempAllStatus)[2] >= 0){
                    tempAllStatus = weapon.skill3(tempAllStatus);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 4:
                if(playerSkill1.skill(tempAllStatus)[2] >= 0){
                    tempAllStatus = playerSkill1.skill(tempAllStatus);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 5:
                if(playerSkill2.skill(tempAllStatus)[2] >= 0){
                    tempAllStatus = playerSkill2.skill(tempAllStatus);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 6:
                if(playerSkill3.skill(tempAllStatus)[2] >= 0){
                    tempAllStatus = playerSkill3.skill(tempAllStatus);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
            case 7:
                if(playerSkill4.skill(tempAllStatus)[2] >= 0){
                    tempAllStatus = playerSkill4.skill(tempAllStatus);
                    spBar.setProgress(sp - tempAllStatus[2]);
                }else{
                    battleText.setText("spが足りません");
                }
                break;
        }
    }

    void inputAllStatus(){
        maxHp = playerInfo.getFmaxHP();
        maxMp = playerInfo.getFmaxMP();
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
        breakGage.setData(50, "%", ContextCompat.getColor(this, R.color.colorAccent), 50, true);
        hpBar.setMax(maxHp);
        mpBar.setMax(maxMp);
        spBar.setMax(sp);
        enemyHpBar.setMax(enemyHp);
        spBar.setProgress(0);
        mpBar.setProgress(maxMp-mp);
        hpBar.setProgress(hp);
        enemyHpBar.setProgress(enemyHp);
    }

    void startNewTurn(){
        tempAllStatus[0] = hp;
        tempAllStatus[1] = mp;
        tempAllStatus[2] = sp;
        tempAllStatus[3] = atk;
        tempAllStatus[4] = df;
        tempAllStatus[5] = luk;
        tempAllStatus[6] = enemyHp;
        tempAllStatus[7] = enemySp;
        tempAllStatus[8] = enemyAtk;
        tempAllStatus[9] = enemyDf;
        tempAllStatus[10] = enemyLuk;
    }
}

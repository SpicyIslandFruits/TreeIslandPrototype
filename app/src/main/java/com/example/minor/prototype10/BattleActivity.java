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

/**
 * spの実装、ターンカウントの実装、mpの実装
 * 敵とのエンカウント方式の実装、intentから敵情報受け取り
 * すべてのスキルには消費spと消費mpを書く
 */
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

    //skillButtonをfindViewByIdしてonClickにsetPlayerBehaviorを入れる
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        makeData = new MakeData();
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        weaponId = playerInfo.getWeaponId();
        weapon = makeData.makeWeaponFromId(weaponId);
        //一時的にサンプルボスを使う、本来はintentから受けとったidを使ってMakeDataクラスのメソッドでインスタンスを取得する
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
        //今回は適当に色を入れているが実際は適宜色を作成して代入、色の作成方法は知恵袋参照
        breakGage.setData(50, "%", ContextCompat.getColor(this, R.color.colorAccent), 50, true);
        inputAllStatus();
        //本来はrealmからデータを受け取って表示、spとmpは"最大値-現在の値"という形で書く
        hpBar.setMax(100);
        mpBar.setMax(100);
        spBar.setMax(100);
        enemyHpBar.setMax(100);
        spBar.setProgress(100-60);
        mpBar.setProgress(100-90);
        hpBar.setProgress(100);
        enemyHpBar.setProgress(100);
    }

    //PlayerSkillクラスとWeaponクラスからskillを受け取って実行し、tempに処理後のデータを保存
    //case4以降にはtempAllStatus = playerSkill"X".skillを書く
    void setPlayerBehavior(int num) {
        switch (num){
            case 0:
                tempAllStatus[6] = tempAllStatus[6] - tempAllStatus[3];
                tempAllStatus[2] = tempAllStatus[2] - 30;
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

    //tempを実際の値に代入
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

    //どちらかのhpが0以下になったらリザルト画面を表示する処理
    //一時的にbattleTextに数値を表示しているが、実際はバーの値を変更
    void executeBattle(){
        battleText.setText("自分のHPは" + String.valueOf(hp) + "敵のHPは" + String.valueOf(enemyHp));
        hpBar.setProgress(hp);
        enemyHpBar.setProgress(enemyHp);
        if(hp<=0 ||enemyHp<=0){
            finish();
        }
    }

    void inputAllStatus(){
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
    }
}

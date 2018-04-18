package com.example.minor.prototype10;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import com.example.minor.prototype10.Models.PlayerInfo;

import io.realm.Realm;

/*
* 配列に値をセットする時はhp,mp,sp,atk,df,lukの順番でセットします
* 主人公がスキルボタンを押すと同時に変数temp~に対して処理が行われます
* 主人公が行動を決定するときにtempの値を実際の値に代入します
*/
public class BattleActivity extends AppCompatActivity {
    Realm realm;
    PlayerInfo playerInfo;
    ProgressBar hpBar, mpBar, spBar;
    GaugeView breakGage;
    ImageButton decisionButton, normalAttackButton,skillButton1, skillButton2, skillButton3;
    ImageButton playerSkill1Button, playerSkill2Button, playerSkill3Button, playerSkill4Button;
    private int[] playerStatus;
    private int hp, mp, sp, atk, df, luk;
    private int tempHp, tempMp, tempSp, tempAtk, tempDf, tempLuk;
    private int turnCount;

    //skillButtonをfindViewByIdしてonClickにsetPlayerBehaviorを入れる
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);
        realm = Realm.getDefaultInstance();
        playerInfo = realm.where(PlayerInfo.class).findFirst();
        playerStatus = new int[6];
        hpBar = (ProgressBar) findViewById(R.id.hp_bar);
        mpBar = (ProgressBar) findViewById(R.id.mp_bar);
        spBar = (ProgressBar) findViewById(R.id.sp_bar);
        breakGage = (GaugeView) findViewById(R.id.break_gage);
        decisionButton = (ImageButton) findViewById(R.id.decision_button);
        decisionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                executeBattle();
            }
        });
        hpBar.setMax(100);
        mpBar.setMax(100);
        spBar.setMax(100);
        tempHp = hp = playerInfo.getHP();
        tempSp = sp = playerInfo.getfSP();
        tempAtk = atk = playerInfo.getfATK();
        tempDf = df = playerInfo.getfDF();
        tempLuk = luk = playerInfo.getfLUK();

        //本来はrealmからデータを受け取って表示
        spBar.setProgress(100-60);
        mpBar.setProgress(100-90);
        hpBar.setProgress(80);
        breakGage.setData(90, "%", ContextCompat.getColor(this, R.color.colorAccent), 90, true);
    }

    void setPlayerBehavior() {

    }

    //例外処理を書く必要はない
    void onDecision(){

    }

    //tempを実際の値に代入する処理
    //どちらかのhpが0になったらリザルト画面を表示する処理
    //プログレスバーの値を変更する
    void executeBattle(){

    }
}

package com.example.minor.prototype10;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.minor.prototype10.Enemys.SampleBoss;
import com.example.minor.prototype10.Models.PlayerInfo;
import com.example.minor.prototype10.Weapons.WeaponInterface;

import io.realm.Realm;

/*
* 配列に値をセットする時はhp,mp,sp,atk,df,lukの順番でセットします
* 主人公がスキルボタンを押すと同時に変数temp~に対して処理が行われます
* 主人公が行動を決定するときにtemp配列の値を実際の値に代入します
*/
public class BattleActivity extends AppCompatActivity {
    Realm realm;
    PlayerInfo playerInfo;
    ProgressBar hpBar, mpBar, spBar;
    GaugeView breakGage;
    TextView battleText;
    MakeData makeData;
    int weaponId;
    //一時的にサンプルボスを使う
    SampleBoss sampleBoss;
    WeaponInterface weapon;
    ImageButton decisionButton, normalAttackButton,skillButton1, skillButton2, skillButton3;
    ImageButton playerSkill1Button, playerSkill2Button, playerSkill3Button, playerSkill4Button;
    private int[] tempPlayerStatus, tempEnemyStatus;
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
        sampleBoss = new SampleBoss();
        tempPlayerStatus = new int[6];
        tempEnemyStatus = new int[5];
        hpBar = (ProgressBar) findViewById(R.id.hp_bar);
        mpBar = (ProgressBar) findViewById(R.id.mp_bar);
        spBar = (ProgressBar) findViewById(R.id.sp_bar);
        breakGage = (GaugeView) findViewById(R.id.break_gage);
        battleText = (TextView) findViewById(R.id.battle_text);
        decisionButton = (ImageButton) findViewById(R.id.decision_button);
        normalAttackButton = (ImageButton) findViewById(R.id.normal_attack);
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
        hpBar.setMax(100);
        mpBar.setMax(100);
        spBar.setMax(100);
        tempPlayerStatus[0] = hp = playerInfo.getHP();
        tempPlayerStatus[1] = mp = playerInfo.getMP();
        tempPlayerStatus[2] = sp = playerInfo.getfSP();
        tempPlayerStatus[3] = atk = playerInfo.getfATK();
        tempPlayerStatus[4] = df = playerInfo.getfDF();
        tempPlayerStatus[5] = luk = playerInfo.getfLUK();
        //本来はidから生成された敵のステータスだが今回はサンプルボスのステータスを取得
        tempEnemyStatus[0] = enemyHp = sampleBoss.getHp();
        tempEnemyStatus[1] = enemySp = sampleBoss.getSp();
        tempEnemyStatus[2] = enemyAtk = sampleBoss.getAtk();
        tempEnemyStatus[3] = enemyDf = sampleBoss.getDf();
        tempEnemyStatus[4] = enemyLuk = sampleBoss.getLuk();
        //本来はrealmからデータを受け取って表示
        spBar.setProgress(100-60);
        mpBar.setProgress(100-90);
        hpBar.setProgress(80);
        breakGage.setData(90, "%", ContextCompat.getColor(this, R.color.colorAccent), 90, true);
    }

    //PlayerSkillクラスとWeaponクラスからskillを受け取って実行し、tempに処理後のデータを保存
    //引数はnormalAttackなら0,skill1なら1,skill2なら2,playerSkill1なら4...といった感じで数字に対応した技を出す。
    //技はプレイヤーが選んだ際に武器クラス
    //敵のステータスは初期値のみ敵クラスから受け取り変更はすべてこのクラスで行う
    void setPlayerBehavior(int num) {
        switch (num){
            case 0:
                tempEnemyStatus[0] = tempEnemyStatus[0] - tempPlayerStatus[3];
                break;
            case 1:
                weapon.skill1(tempEnemyStatus);
                break;
            case 2:
                weapon.skill2(tempEnemyStatus);
                break;
            case 3:
                weapon.skill3(tempEnemyStatus);
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
        tempPlayerStatus = sampleBoss.setEnemyBehavior(tempPlayerStatus);
    }

    //例外処理を書く必要はない
    void onDecision(){
        hp = tempPlayerStatus[0];
        mp = tempPlayerStatus[1];
        sp = tempPlayerStatus[2];
        atk = tempPlayerStatus[3];
        df = tempPlayerStatus[4];
        luk = tempPlayerStatus[5];
        enemyHp = tempEnemyStatus[0];
        enemySp = tempEnemyStatus[1];
        enemyAtk = tempEnemyStatus[2];
        enemyDf = tempEnemyStatus[3];
        enemyLuk = tempEnemyStatus[4];
    }

    //tempを実際の値に代入する処理
    //どちらかのhpが0以下になったらリザルト画面を表示する処理
    //プログレスバーの値を変更する
    void executeBattle(){
        battleText.setText("自分のHPは" + String.valueOf(hp) + "敵のHPは" + String.valueOf(enemyHp));
        if(hp<=0 ||enemyHp<=0){
            finish();
        }
    }
}

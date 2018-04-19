package com.example.minor.prototype10.Weapons;

/*
* 受け取った味方の配列はhp,mp,sp,atk,df,lukの順
* 受け取った敵の配列はhp,sp,atk,df,lukの順
*/
public class SampleWeapon extends SuperWeapon {
    private int id = 0;
    private String name = "SampleWeapon";
    private int atk = 1;
    private String skill1Info = "2倍アタック、攻撃力の2倍の威力で攻撃";
    private String skill2Info = "3倍アタック、攻撃力の3倍の威力で攻撃";
    private String skill3Info = "4倍アタック、攻撃力の4倍の威力で攻撃";

    public SampleWeapon(int[] tempEnemyStatus, int[] tempPlayerStatus) {
        super(tempEnemyStatus, tempPlayerStatus);
    }

    public int[] skill1(int[] tempEnemyStatus, int[] tempPlayerStatus){
        newEnemyStatus[0] = tempEnemyStatus[0] - (tempPlayerStatus[3]+atk)*2;
        return newEnemyStatus;
    }
    public int[] skill2(int[] tempEnemyStatus, int[] tempPlayerStatus){
        return newEnemyStatus;
    }
    public int[] skill3(int[] tempEnemyStatus, int[] tempPlayerStatus){
        return newEnemyStatus;
    }

    public int getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAtk() {
        return atk;
    }

    public String getSkill1Info() {
        return skill1Info;
    }

    public String getSkill2Info() {
        return skill2Info;
    }

    public String getSkill3Info() {
        return skill3Info;
    }
}

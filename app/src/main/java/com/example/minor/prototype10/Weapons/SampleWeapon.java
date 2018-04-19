package com.example.minor.prototype10.Weapons;

/*
* 受け取った味方の配列はhp,mp,sp,atk,df,lukの順
* 受け取った敵の配列はhp,sp,atk,df,lukの順
*/

public class SampleWeapon extends SuperWeapon {
    private static final int id = 0;
    private static final String name = "SampleWeapon";
    private static final int atk = 1;
    private static final String skill1Info = "2倍アタック、攻撃力の2倍の威力で攻撃";
    private static final String skill2Info = "3倍アタック、攻撃力の3倍の威力で攻撃";
    private static final String skill3Info = "4倍アタック、攻撃力の4倍の威力で攻撃";

    public int[] skill1(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - (playerAtk + atk)*2;
        commitTransaction();
        return newAllStatus;
    }

    public int[] skill2(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        commitTransaction();
        return newAllStatus;
    }

    public int[] skill3(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        commitTransaction();
        return newAllStatus;
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

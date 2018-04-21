package com.example.minor.prototype10.Weapons;

/**
 * 武器を追加したらMakeDataクラスでswitch文に処理を追加してください
 * 武器を取得するイベントを書いてください、取得する際にはPlayerInfoのweaponIdではなくRealmList<WeaponId>のほうにidを追加してください
 * playerAtkにはすでに武器装備時の攻撃力が代入されています
 * skillメソッドの中に処理を書いてください、spを消費させる処理を忘れないでください。
 * skillメソッドの処理はbeginTransactionとcommitTransactionで挟んでください
 * 後で要素を追加するときは先にSuperWeaponにメソッドを追加してください
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
        newEnemyHp = enemyHp - (playerAtk)*2;
        newPlayerSp = playerSp - 3;
        commitTransaction();
        return newAllStatus;
    }

    public int[] skill2(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - (playerAtk)*3;
        newPlayerSp = playerSp - 5;
        commitTransaction();
        return newAllStatus;
    }

    public int[] skill3(int[] tempAllStatus){
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - (playerAtk)*4;
        newPlayerSp = playerSp - 7;
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

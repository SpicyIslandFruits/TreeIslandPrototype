package com.example.minor .prototype10.Weapons;

public class SampleWeapon2 implements WeaponInterface {
    private int id = 1;
    private String name = "SampleWeapon2";
    private int atk = 2;
    private int[] newEnemyStatus;
    private String skill1Info = "2割アタック、攻撃力の2割の威力で攻撃";
    private String skill2Info = "3割アタック、攻撃力の3割の威力で攻撃";
    private String skill3Info = "4割アタック、攻撃力の4割の威力で攻撃";

    public int[] skill1(int[] tempEnemyStatus){
        return newEnemyStatus;
    }
    public int[] skill2(int[] tempEnemyStatus){
        return newEnemyStatus;
    }
    public int[] skill3(int[] tempEnemyStatus){
        return newEnemyStatus;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAtk() {
        return atk;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getSkill1Info() {
        return skill1Info;
    }

    @Override
    public String getSkill2Info() {
        return skill2Info;
    }

    @Override
    public String getSkill3Info() {
        return skill3Info;
    }
}

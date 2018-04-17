package com.example.minor.prototype10.Weapons;

public class SampleWeapon implements WeaponInterface {
    private int id = 0;
    private String name = "SampleWeapon";
    private int atk = 1;
    private String skill1Info = "2倍アタック、攻撃力の2倍の威力で攻撃";
    private String skill2Info = "3倍アタック、攻撃力の3倍の威力で攻撃";
    private String skill3Info = "4倍アタック、攻撃力の4倍の威力で攻撃";

    public void skill1(){

    }
    public void skill2(){

    }
    public void skill3(){

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

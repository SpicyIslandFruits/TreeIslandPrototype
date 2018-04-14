package com.example.minor.prototype10;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PlayerInfo extends RealmObject {
    @PrimaryKey
    private String player;
    private int playerLevel;
    private int experiencePointSum;
    private int position;
    private int money;
    private int maxHP;
    private int mmaxHP;
    private int fmaxHP;
    private int HP;
    private int maxMP;
    private int mmaxMP;
    private int fmaxMP;
    private int MP;
    private int SP;
    private int mSP;
    private int fSP;
    private int ATK;
    private int mATK;
    private int fATK;
    private int DF;
    private int mDF;
    private int fDF;
    private int LUK;
    private int mLUK;
    private int fLUK;
    private RealmList<ArmorId> armorIds;
    private int armor;
    private RealmList<WeaponId> weaponIds;
    private int weapon;

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setPlayerLevel(int playerLevel) {
        this.playerLevel = playerLevel;
    }

    public int getExperiencePointSum() {
        return experiencePointSum;
    }

    public void setExperiencePointSum(int experiencePointSum) {
        this.experiencePointSum = experiencePointSum;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public int getMmaxHP() {
        return mmaxHP;
    }

    public void setMmaxHP(int mmaxHP) {
        this.mmaxHP = mmaxHP;
    }

    public int getFmaxHP() {
        return fmaxHP;
    }

    public void setFmaxHP(int fmaxHP) {
        this.fmaxHP = fmaxHP;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMaxMP() {
        return maxMP;
    }

    public void setMaxMP(int maxMP) {
        this.maxMP = maxMP;
    }

    public int getMmaxMP() {
        return mmaxMP;
    }

    public void setMmaxMP(int mmaxMP) {
        this.mmaxMP = mmaxMP;
    }

    public int getFmaxMP() {
        return fmaxMP;
    }

    public void setFmaxMP(int fmaxMP) {
        this.fmaxMP = fmaxMP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getSP() {
        return SP;
    }

    public void setSP(int SP) {
        this.SP = SP;
    }

    public int getmSP() {
        return mSP;
    }

    public void setmSP(int mSP) {
        this.mSP = mSP;
    }

    public int getfSP() {
        return fSP;
    }

    public void setfSP(int fSP) {
        this.fSP = fSP;
    }

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getmATK() {
        return mATK;
    }

    public void setmATK(int mATK) {
        this.mATK = mATK;
    }

    public int getfATK() {
        return fATK;
    }

    public void setfATK(int fATK) {
        this.fATK = fATK;
    }

    public int getDF() {
        return DF;
    }

    public void setDF(int DF) {
        this.DF = DF;
    }

    public int getmDF() {
        return mDF;
    }

    public void setmDF(int mDF) {
        this.mDF = mDF;
    }

    public int getfDF() {
        return fDF;
    }

    public void setfDF(int fDF) {
        this.fDF = fDF;
    }

    public int getLUK() {
        return LUK;
    }

    public void setLUK(int LUK) {
        this.LUK = LUK;
    }

    public int getmLUK() {
        return mLUK;
    }

    public void setmLUK(int mLUK) {
        this.mLUK = mLUK;
    }

    public int getfLUK() {
        return fLUK;
    }

    public void setfLUK(int fLUK) {
        this.fLUK = fLUK;
    }

    public RealmList<ArmorId> getArmorIds() {
        return armorIds;
    }

    public void setArmorIds(RealmList<ArmorId> armorIds) {
        this.armorIds = armorIds;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public RealmList<WeaponId> getWeaponIds() {
        return weaponIds;
    }

    public void setWeaponIds(RealmList<WeaponId> weaponIds) {
        this.weaponIds = weaponIds;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }
}
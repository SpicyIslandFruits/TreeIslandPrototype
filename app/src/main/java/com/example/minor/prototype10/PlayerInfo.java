package com.example.minor.prototype10;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class PlayerInfo extends RealmObject {
    @PrimaryKey
    private String player;
    private int playerLevel;
    private int position;
    private int money;
    private int maxHP;
    private int maxHPa;
    private int maxHPb;
    private int HP;
    private int HPa;
    private int HPb;
    private int maxMP;
    private int maxMPa;
    private int maxMPb;
    private int MP;
    private int MPa;
    private int MPb;
    private int SP;
    private int SPa;
    private int SPb;
    private int ATK;
    private int ATKa;
    private int ATKb;
    private int DF;
    private int DFa;
    private int DFb;
    private int LUK;
    private int LUKa;
    private int LUKb;
    private RealmList<ArmorId> armorIds;
    private int armor;
    private RealmList<WeaponId> weaponIds;
    private int weapon;

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
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

    public int getATK() {
        return ATK;
    }

    public void setATK(int ATK) {
        this.ATK = ATK;
    }

    public int getDF() {
        return DF;
    }

    public void setDF(int DF) {
        this.DF = DF;
    }

    public int getLUK() {
        return LUK;
    }

    public void setLUK(int LUK) {
        this.LUK = LUK;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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

    public int getMaxHPa() {
        return maxHPa;
    }

    public void setMaxHPa(int maxHPa) {
        this.maxHPa = maxHPa;
    }

    public int getMaxHPb() {
        return maxHPb;
    }

    public void setMaxHPb(int maxHPb) {
        this.maxHPb = maxHPb;
    }

    public int getHPa() {
        return HPa;
    }

    public void setHPa(int HPa) {
        this.HPa = HPa;
    }

    public int getHPb() {
        return HPb;
    }

    public void setHPb(int HPb) {
        this.HPb = HPb;
    }

    public int getMaxMPa() {
        return maxMPa;
    }

    public void setMaxMPa(int maxMPa) {
        this.maxMPa = maxMPa;
    }

    public int getMaxMPb() {
        return maxMPb;
    }

    public void setMaxMPb(int maxMPb) {
        this.maxMPb = maxMPb;
    }

    public int getMPa() {
        return MPa;
    }

    public void setMPa(int MPa) {
        this.MPa = MPa;
    }

    public int getMPb() {
        return MPb;
    }

    public void setMPb(int MPb) {
        this.MPb = MPb;
    }

    public int getSPa() {
        return SPa;
    }

    public void setSPa(int SPa) {
        this.SPa = SPa;
    }

    public int getSPb() {
        return SPb;
    }

    public void setSPb(int SPb) {
        this.SPb = SPb;
    }

    public int getATKa() {
        return ATKa;
    }

    public void setATKa(int ATKa) {
        this.ATKa = ATKa;
    }

    public int getATKb() {
        return ATKb;
    }

    public void setATKb(int ATKb) {
        this.ATKb = ATKb;
    }

    public int getDFa() {
        return DFa;
    }

    public void setDFa(int DFa) {
        this.DFa = DFa;
    }

    public int getDFb() {
        return DFb;
    }

    public void setDFb(int DFb) {
        this.DFb = DFb;
    }

    public int getLUKa() {
        return LUKa;
    }

    public void setLUKa(int LUKa) {
        this.LUKa = LUKa;
    }

    public int getLUKb() {
        return LUKb;
    }

    public void setLUKb(int LUKb) {
        this.LUKb = LUKb;
    }

    public int getWeapon() {
        return weapon;
    }

    public void setWeapon(int weapon) {
        this.weapon = weapon;
    }
}
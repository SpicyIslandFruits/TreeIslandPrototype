package com.example.minor.prototype10.Weapons;

public interface WeaponInterface {
    public int[] skill1(int[] tempEnemyStatus);
    public int[] skill2(int[] tempEnemyStatus);
    public int[] skill3(int[] tempEnemyStatus);
    public int getId();
    public String getName();
    public int getAtk();
    public String getSkill1Info();
    public String getSkill2Info();
    public String getSkill3Info();
}

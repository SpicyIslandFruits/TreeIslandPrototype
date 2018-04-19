package com.example.minor.prototype10.Weapons;

abstract public class SuperWeapon {
    protected int[] newEnemyStatus;
    protected int[] newPlayerStatus;

    public SuperWeapon(int[] tempEnemyStatus, int[] tempPlayerStatus){
        newEnemyStatus = new int[5];
        newEnemyStatus[0] = tempEnemyStatus[0];
        newEnemyStatus[1] = tempEnemyStatus[1];
        newEnemyStatus[2] = tempEnemyStatus[2];
        newEnemyStatus[3] = tempEnemyStatus[3];
        newEnemyStatus[4] = tempEnemyStatus[4];
        newPlayerStatus = new int[6];
        newPlayerStatus[0] = tempEnemyStatus[0];
        newPlayerStatus[1] = tempPlayerStatus[1];
        newPlayerStatus[2] = tempPlayerStatus[2];
        newPlayerStatus[3] = tempPlayerStatus[3];
        newPlayerStatus[4] = tempPlayerStatus[4];
        newPlayerStatus[5] = tempPlayerStatus[5];
    }
    abstract public int[] skill1(int[] tempEnemyStatus, int[] tempPlayerStatus);
    abstract public int[] skill2(int[] tempEnemyStatus, int[] tempPlayerStatus);
    abstract public int[] skill3(int[] tempEnemyStatus, int[] tempPlayerStatus);
    abstract public int getId();
    abstract public String getName();
    abstract public int getAtk();
    abstract public String getSkill1Info();
    abstract public String getSkill2Info();
    abstract public String getSkill3Info();
}

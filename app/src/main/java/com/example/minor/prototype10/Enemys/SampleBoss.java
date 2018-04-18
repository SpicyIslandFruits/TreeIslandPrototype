package com.example.minor.prototype10.Enemys;

//配列playerStatusの要素の順番はhp,mp,sp,atk,df,luk
public class SampleBoss implements EnemyInterface {
    private int hp = 100, sp = 10, atk = 10, df = 100, luk = 100;
    private int[] tempPlayerStatus, newTempPlayerStatus;

    public int getHp() {
        return hp;
    }

    public int getSp() {
        return sp;
    }

    public int getAtk() {
        return atk;
    }

    public int getDf() {
        return df;
    }

    public int getLuk() {
        return luk;
    }

    @Override
    public void skill1() {
        tempPlayerStatus[0] = tempPlayerStatus[0] - atk;
    }

    @Override
    public void skill2() {

    }

    @Override
    public void skill3() {

    }

    @Override
    public void skill4() {

    }

    @Override
    public int[] setEnemyBehavior(int[] tempPlayerStatus) {
        this.tempPlayerStatus = tempPlayerStatus;
        skill1();
        newTempPlayerStatus = tempPlayerStatus;
        return newTempPlayerStatus;
    }
}

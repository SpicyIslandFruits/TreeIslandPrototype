package com.example.minor.prototype10.Enemys;

public interface EnemyInterface {
    public int getHp();
    public int getSp();
    public int getAtk();
    public int getDf();
    public int getLuk();
    public void skill1();
    public void skill2();
    public void skill3();
    public void skill4();
    public int[] setEnemyBehavior(int[] tempPlayerStatus);
}

package com.example.minor.prototype10.Enemys;

abstract class SuperEnemy {
    abstract int getHp();
    abstract int getSp();
    abstract int getAtk();
    abstract int getDf();
    abstract int getLuk();
    abstract void skill1();
    abstract void skill2();
    abstract void skill3();
    abstract void skill4();
    abstract int[] setEnemyBehavior(int[] tempPlayerStatus);
}

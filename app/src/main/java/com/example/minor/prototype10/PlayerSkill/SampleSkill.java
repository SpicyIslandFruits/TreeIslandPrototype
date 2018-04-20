package com.example.minor.prototype10.PlayerSkill;

/**
 * 消費spのほかに消費mpも書かなければいけないことに注意
 */
public class SampleSkill extends SuperSkill {
    private static final int id = 0;
    private static final String name = "SampleWeapon";
    private static final String skillInfo = "切り裂く、攻撃力の2倍の威力";

    @Override
    public int[] skill(int[] tempAllStatus) {
        beginTransaction(tempAllStatus);
        newEnemyHp = enemyHp - playerAtk*2;
        newPlayerSp = playerSp - 3;
        newPlayerMp = playerMp - 3;
        commitTransaction();
        return newAllStatus;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getSkillInfo() {
        return skillInfo;
    }
}

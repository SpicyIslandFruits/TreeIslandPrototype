package com.example.minor.prototype10.Models;

import io.realm.annotations.PrimaryKey;

public class PlayerSkillId {
    @PrimaryKey
    private String name;

    private int skillId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }
}

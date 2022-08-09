package com.jm.demo.warframes;

public enum Role {
    fighter("Fighter"),
    mage("Mage"),
    tank("Tank"),
    bot("Bot"),
    support("Support");

    public final String label;

    Role(String label) {
        this.label = label;
    }
}

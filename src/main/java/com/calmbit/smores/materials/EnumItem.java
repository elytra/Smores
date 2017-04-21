package com.calmbit.smores.materials;

public enum EnumItem {
    INGOT("Ingot"),
    GEM("Gem"),
    ORE("Ore"),
    DUST("Dust"),
    PLATE("Plate"),
    GEAR("Gear");

    public String name;

    EnumItem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package com.calmbit.smores.materials;

public enum EnumItemType {
    INGOT("Ingot"),
    GEM("Gem"),
    ORE("Ore"),
    DUST("Dust"),
    PLATE("Plate"),
    GEAR("Gear");

    public String name;

    EnumItemType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

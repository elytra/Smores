package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

public enum EnumGemType implements IStringSerializable {
    RUBY("Ruby", 0),
    SAPPHIRE("Sapphire", 1),
    PERIDOT("Peridot", 2);

    private String materialName;
    private int id;

    EnumGemType(String materialName, int id) {
        this.materialName = materialName;
        this.id = id;
    }

    public String getName() {
        return materialName.toLowerCase();
    }

    public int getId() {
        return id;
    }

    public EnumItemType[] getTypes() {
        return new EnumItemType[]{EnumItemType.GEM, EnumItemType.ORE};
    }
}

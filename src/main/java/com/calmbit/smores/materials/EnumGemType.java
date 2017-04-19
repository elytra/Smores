package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

public enum EnumGemType implements IGemProducing, IOreGenerating, IStringSerializable {
    RUBY("Ruby", 0),
    SAPPHIRE("Sapphire", 1),
    PERIDOT("Peridot", 2);

    private String materialName;
    private int id;

    EnumGemType(String materialName, int id) {
        this.materialName = materialName;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return materialName.toLowerCase();
    }

    @Override
    public String getGemDictEntry() {
        return "gem" + this.materialName;
    }

    @Override
    public String getOreDictEntry() {
        return "ore" + this.materialName;
    }
}

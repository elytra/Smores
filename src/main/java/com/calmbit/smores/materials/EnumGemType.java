package com.calmbit.smores.materials;

public enum EnumGemType implements IGemProducing, IOreGenerating {
    RUBY("Ruby"),
    SAPPHIRE("Sapphire"),
    PERIDOT("Peridot");

    private String materialName;

    EnumGemType(String materialName) {
        this.materialName = materialName;
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

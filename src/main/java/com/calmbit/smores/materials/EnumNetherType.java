package com.calmbit.smores.materials;

public enum EnumNetherType implements IOreGenerating, IDustProducing {
    SULFUR("Sulfur"),
    NITRE("Nitre");

    private String materialName;

    EnumNetherType(String materialName) {
        this.materialName =  materialName;
    }

    @Override
    public String getOreDictEntry() {
        return "ore"+this.materialName;
    }

    @Override
    public String getDustDictEntry() {
        return "dust"+this.materialName;
    }
}

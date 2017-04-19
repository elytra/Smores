package com.calmbit.smores.materials;


public enum EnumMiscType implements IIngotProducing, IOreGenerating {
    MERCURY("Mercury");

    private String materialName;

    EnumMiscType(String materialName) {
        this.materialName = materialName;
    }

    public String getIngotDictEntry() {
        return materialName;
    }

    public String getOreDictEntry() {
        return "ore"+materialName;
    }
}

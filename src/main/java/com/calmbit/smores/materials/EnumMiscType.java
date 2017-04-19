package com.calmbit.smores.materials;


public enum EnumMiscType implements IIngotProducing, IOreGenerating {
    MERCURY("Mercury", 0);

    private String materialName;
    private int id;

    EnumMiscType(String materialName, int id) {
        this.materialName = materialName;
        this.id = id;
    }

    public String getIngotDictEntry() {
        return materialName;
    }

    public String getOreDictEntry() {
        return "ore"+materialName;
    }

    @Override
    public int getId() {
        return id;
    }
}

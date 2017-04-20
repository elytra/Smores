package com.calmbit.smores.materials;


import java.util.ArrayList;

public enum EnumMiscType implements IMaterialEnum, IIngotProducing, IOreGenerating {
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

    public ArrayList<String> getAllOreDictEntries() {
        ArrayList<String> entries = new ArrayList<>();

        entries.add(getIngotDictEntry());
        entries.add(getOreDictEntry());

        return entries;
    }
}

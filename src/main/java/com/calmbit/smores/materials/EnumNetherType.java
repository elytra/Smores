package com.calmbit.smores.materials;

import java.util.ArrayList;

public enum EnumNetherType implements IOreGenerating, IDustProducing {
    SULFUR("Sulfur", 0),
    NITRE("Nitre", 1);

    private String materialName;
    private int id;

    EnumNetherType(String materialName, int id) {
        this.materialName =  materialName;
        this.id = id;
    }

    @Override
    public String getOreDictEntry() {
        return "ore"+this.materialName;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getDustDictEntry() {
        return "dust"+this.materialName;
    }

    public ArrayList<String> getAllOreDictEntries() {
        ArrayList<String> entries = new ArrayList<>();

        entries.add(getDustDictEntry());
        entries.add(getOreDictEntry());

        return entries;
    }
}

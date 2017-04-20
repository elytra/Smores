package com.calmbit.smores.materials;

import java.util.ArrayList;

public enum EnumAlloyType implements IMaterialEnum, IIngotProducing, IDustProducing, IPlateProducing, IGearProducing{

    ELECTRUM("Electrum"),
    INVAR("Invar"),
    STEEL("Steel"),
    BRONZE("Bronze"),
    BRASS("Brass");

    private String materialName;


    EnumAlloyType(String materialName) {
       this.materialName = materialName;
    }

    @Override
    public String getIngotDictEntry() {
        return "ingot"+this.materialName;
    }

    @Override
    public String getDustDictEntry() {
        return "dust"+this.materialName;
    }

    @Override
    public String getPlateDictEntry() {
        return "plate"+this.materialName;
    }


    @Override
    public String getGearDictEntry() {
        return "gear"+this.materialName;
    }

    public ArrayList<String> getAllOreDictEntries() {
        ArrayList<String> entries = new ArrayList<>();

        entries.add(getIngotDictEntry());
        entries.add(getDustDictEntry());
        entries.add(getPlateDictEntry());
        entries.add(getGearDictEntry());

        return entries;
    }


}

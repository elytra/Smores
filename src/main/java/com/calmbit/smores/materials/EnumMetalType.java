package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

import java.util.ArrayList;

public enum  EnumMetalType implements IMaterialEnum, IIngotProducing, IOreGenerating,
    IDustProducing, IPlateProducing, IStringSerializable, IGearProducing {

    COPPER("Copper", 0),
    TIN("Tin", 1),
    LEAD("Lead", 2),
    SILVER("Silver", 3),
    NICKEL("Nickel", 4),
    PLATINUM("Platinum", 5),
    MITHRIL("Mithril", 6),
    ZINC("Zinc", 7);

    private String materialName;
    public int id;
    public String getName() {
        return materialName.toLowerCase();
    }

    EnumMetalType(String materialName, int id) {
        this.id = id;
        this.materialName = materialName;
    }


    public int getId() {
        return this.id;
    }

    @Override
    public String getIngotDictEntry() {
        return "ingot"+ this.materialName;
    }

    @Override
    public String getOreDictEntry() {
        return "ore" + this.materialName;
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
        entries.add(getOreDictEntry());
        entries.add(getDustDictEntry());
        entries.add(getPlateDictEntry());
        entries.add(getGearDictEntry());

        return entries;
    }
}

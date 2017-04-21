package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumAlloy implements IStringSerializable {

    ELECTRUM("Electrum", 0),
    INVAR("Invar", 1),
    STEEL("Steel", 2),
    BRONZE("Bronze", 3),
    BRASS("Brass", 4);

    private String materialName;
    private int id;

    EnumAlloy(String materialName, int id) {
       this.materialName = materialName;
       this.id = id;
    }

    public String getName() {
        return this.materialName.toLowerCase(Locale.ROOT);
    }

    public String getMaterialName() {
        return this.materialName;
    }

    public int getId() {
        return id;
    }

    public EnumItem[] getTypes() {
        return new EnumItem[]{EnumItem.INGOT, EnumItem.DUST, EnumItem.PLATE, EnumItem.GEAR};
    }



}

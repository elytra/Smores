package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumAlloyType implements IStringSerializable {

    ELECTRUM("Electrum", 0),
    INVAR("Invar", 1),
    STEEL("Steel", 2),
    BRONZE("Bronze", 3),
    BRASS("Brass", 4);

    private String materialName;
    private int id;

    EnumAlloyType(String materialName, int id) {
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

    public EnumItemType[] getTypes() {
        return new EnumItemType[]{EnumItemType.INGOT, EnumItemType.DUST, EnumItemType.PLATE, EnumItemType.GEAR};
    }



}

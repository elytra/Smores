package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumAlloyType implements IStringSerializable {

    ELECTRUM("Electrum"),
    INVAR("Invar"),
    STEEL("Steel"),
    BRONZE("Bronze"),
    BRASS("Brass");

    private String materialName;

    EnumAlloyType(String materialName) {
       this.materialName = materialName;
    }

    public String getName() {
        return this.materialName.toLowerCase(Locale.ROOT);
    }

    public String getMaterialName() {
        return this.materialName;
    }

    public EnumItemType[] getTypes() {
        return new EnumItemType[]{EnumItemType.INGOT, EnumItemType.DUST, EnumItemType.PLATE, EnumItemType.GEAR};
    }



}

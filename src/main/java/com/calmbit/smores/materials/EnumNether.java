package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumNether implements IStringSerializable{
    SULFUR("Sulfur", 0),
    NITRE("Nitre", 1);

    private String materialName;
    private int id;

    EnumNether(String materialName, int id) {
        this.materialName =  materialName;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.materialName.toLowerCase(Locale.ROOT);
    }

    public String getMaterialName() {
        return this.materialName;
    }


    public EnumItem[] getTypes() {
        return new EnumItem[]{EnumItem.DUST, EnumItem.ORE};
    }

}

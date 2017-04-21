package com.calmbit.smores.materials;


import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumMisc implements IStringSerializable {
    MERCURY("Mercury", 0);

    private String materialName;
    private int id;

    EnumMisc(String materialName, int id) {
        this.materialName = materialName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return this.materialName.toLowerCase(Locale.ROOT);
    }

    public String getMaterialName() {
        return this.materialName;
    }

    public EnumItem[] getTypes() {
        return new EnumItem[]{EnumItem.INGOT, EnumItem.ORE};
    }

}

package com.calmbit.smores.materials;

import java.util.ArrayList;

public enum EnumNetherType {
    SULFUR("Sulfur", 0),
    NITRE("Nitre", 1);

    private String materialName;
    private int id;

    EnumNetherType(String materialName, int id) {
        this.materialName =  materialName;
        this.id = id;
    }

    public String getName() {
        return materialName;
    }

    public EnumItemType[] getTypes() {
        return new EnumItemType[]{EnumItemType.DUST, EnumItemType.ORE};
    }

}

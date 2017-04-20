package com.calmbit.smores.materials;


import java.util.ArrayList;

public enum EnumMiscType implements IOrderedEnum {
    MERCURY("Mercury", 0);

    private String materialName;
    private int id;

    EnumMiscType(String materialName, int id) {
        this.materialName = materialName;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    public String getName() {
        return this.materialName;
    }

    public EnumItemType[] getTypes() {
        return new EnumItemType[]{EnumItemType.INGOT, EnumItemType.ORE};
    }

}

package com.calmbit.smores.materials;

public enum EnumAlloyType{

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
        return this.materialName;
    }

    public EnumItemType[] getTypes() {
        return new EnumItemType[]{EnumItemType.INGOT, EnumItemType.DUST, EnumItemType.PLATE, EnumItemType.GEAR};
    }



}

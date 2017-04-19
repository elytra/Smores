package com.calmbit.smores.materials;

public enum EnumAlloyType implements IIngotProducing, IDustProducing, IPlateProducing, IGearProducing{

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
}

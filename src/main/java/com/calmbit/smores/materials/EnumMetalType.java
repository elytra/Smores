package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public enum  EnumMetalType implements IStringSerializable {

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

    EnumMetalType(String materialName, int id) {
        this.id = id;
        this.materialName = materialName;
    }

    public String getName() {
        return this.materialName.toLowerCase(Locale.ROOT);
    }

    public String getMaterialName() {
        return this.materialName;
    }


    public int getId() {
        return this.id;
    }

    public EnumItemType[] getTypes() {
        return new EnumItemType[]{EnumItemType.INGOT, EnumItemType.ORE, EnumItemType.DUST, EnumItemType.PLATE, EnumItemType.GEAR};
    }
}

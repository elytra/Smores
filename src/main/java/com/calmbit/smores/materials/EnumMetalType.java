package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

import java.util.ArrayList;
import java.util.List;

public enum  EnumMetalType implements IOrderedEnum, IStringSerializable {

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
    public String getName() {
        return materialName.toLowerCase();
    }

    EnumMetalType(String materialName, int id) {
        this.id = id;
        this.materialName = materialName;
    }

    public int getId() {
        return this.id;
    }

}

package com.calmbit.smores.materials;

import net.minecraft.util.IStringSerializable;

import java.util.Locale;

public enum EnumMetal implements IStringSerializable {

    COPPER("Copper", 0),
    TIN("Tin", 1),
    LEAD("Lead", 2),
    SILVER("Silver", 3),
    NICKEL("Nickel", 4),
    PLATINUM("Platinum", 5),
    MITHRIL("Mithril", 6),
    ZINC("Zinc", 7),
	IRON("Iron", 8),
	GOLD("Gold", 9),
	;
	
    private String materialName;
    public int id;

    EnumMetal(String materialName, int id) {
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

    public EnumItem[] getTypes() {
        return new EnumItem[]{EnumItem.INGOT, EnumItem.ORE, EnumItem.DUST, EnumItem.PLATE, EnumItem.GEAR};
    }
}

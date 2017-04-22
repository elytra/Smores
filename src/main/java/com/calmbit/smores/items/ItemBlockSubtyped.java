package com.calmbit.smores.items;


import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.Locale;

public class ItemBlockSubtyped<T extends Enum<T>> extends ItemBlock {

    private T[] typedEnumConstants;

    public ItemBlockSubtyped(Block block, Class<T> enumClass) {
        super(block);
        this.setRegistryName(block.getRegistryName());
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        typedEnumConstants = enumClass.getEnumConstants();
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + typedEnumConstants[stack.getItemDamage()].toString().toLowerCase(Locale.ROOT);
    }

    @Override
    public int getMetadata(int damage) {
        return damage;
    }
}

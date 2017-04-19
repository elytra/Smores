package com.calmbit.smores.generic;


import com.calmbit.smores.registries.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class SmoresCreativeTab extends CreativeTabs {
    public SmoresCreativeTab(String label) {
        super(label);
    }

    @Override
    public ItemStack getTabIconItem() {
        return new ItemStack(ItemRegistry.itemIngot, 1, 0);
    }
}

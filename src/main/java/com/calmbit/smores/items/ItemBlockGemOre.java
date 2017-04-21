package com.calmbit.smores.items;


import com.calmbit.smores.materials.EnumGem;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.Locale;

public class ItemBlockGemOre extends ItemBlock {
    public ItemBlockGemOre(Block block) {
        super(block);
        this.setRegistryName(block.getRegistryName());
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + EnumGem.values()[stack.getItemDamage()].toString().toLowerCase(Locale.ROOT);
    }


}

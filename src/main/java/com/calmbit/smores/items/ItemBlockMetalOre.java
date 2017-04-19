package com.calmbit.smores.items;


import com.calmbit.smores.materials.EnumMetalType;
import com.calmbit.smores.materials.IOreGenerating;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMetalOre extends ItemBlock {
    public ItemBlockMetalOre(Block block) {
        super(block);
        this.setRegistryName(block.getRegistryName());
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return this.getUnlocalizedName() + "_" + EnumMetalType.values()[stack.getItemDamage()].toString().toLowerCase();
    }


}

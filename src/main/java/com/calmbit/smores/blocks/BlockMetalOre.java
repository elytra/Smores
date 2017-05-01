package com.calmbit.smores.blocks;

import com.calmbit.smores.Smores;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.materials.EnumMetal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

import javax.annotation.Nullable;
import java.util.Locale;

public class BlockMetalOre extends BlockBase implements IOreDict {

    public static PropertyEnum<EnumMetal> METAL = BlockMetal.METAL;

    public BlockMetalOre() {
        super(Material.ROCK, "metal_ore");
        this.setHardness(3.0f);
        this.setDefaultState(this.getDefaultState().withProperty(METAL, EnumMetal.COPPER));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, METAL);
    }

    @Override
    public int getHarvestLevel(IBlockState state) {
        return (state.getValue(METAL) == EnumMetal.COPPER || state.getValue(METAL) == EnumMetal.TIN) ? 1 : 2;
    }

    @Nullable
    @Override
    public String getHarvestTool(IBlockState state) {
        return "pickaxe";
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(METAL).getId();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(METAL, EnumMetal.values()[meta]);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
        for(EnumMetal metal : METAL.getAllowedValues()) {
            list.add(new ItemStack(itemIn, 1, metal.getId()));
        }
    }

    @Override
    public void registerItemModel(ItemBlock block)
    {
        int iterator = 0;
        for(EnumMetal metal : METAL.getAllowedValues()) {
            Smores.proxy.registerItemRenderer(block,iterator, super.getUnlocalizedName() + "_" + metal.toString().toLowerCase(Locale.ROOT));
            iterator++;
        }
    }

    @Override
    public void registerOreDict() {
    	for(EnumMetal metal : METAL.getAllowedValues()) {
            OreDictionary.registerOre("ore"+metal.getMaterialName(), new ItemStack(this, 1, metal.getId()));
        }
    }
}

package com.calmbit.smores.blocks;

import com.calmbit.smores.Smores;
import com.calmbit.smores.materials.EnumNether;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;

import java.util.Locale;

public class BlockNetherOre extends BlockBase {

    public static PropertyEnum<EnumNether> MATERIAL = PropertyEnum.create("metal", EnumNether.class);

    public BlockNetherOre() {
        super(Material.ROCK, "nether_ore");
        this.setDefaultState(this.getDefaultState().withProperty(MATERIAL, EnumNether.SULFUR));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, MATERIAL);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(MATERIAL).getId();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(MATERIAL, EnumNether.values()[meta]);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
        int iterator = 0;
        for(EnumNether material : EnumNether.values()) {
            list.add(new ItemStack(itemIn, 1, iterator));
            iterator++;
        }
    }

    @Override
    public void registerItemModel(ItemBlock block)
    {
        int iterator = 0;
        for(EnumNether material : EnumNether.values()) {
            Smores.proxy.registerItemRenderer(block,iterator, super.getUnlocalizedName() + "_" + material.toString().toLowerCase(Locale.ROOT));
            iterator++;
        }
    }
}

package com.calmbit.smores.blocks;

import com.calmbit.smores.Smores;
import com.calmbit.smores.materials.EnumMetalType;
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

public class BlockMetalOre extends BlockBase {

    public static PropertyEnum<EnumMetalType> METAL_TYPE = PropertyEnum.create("metal_type", EnumMetalType.class);

    public BlockMetalOre() {
        super(Material.ROCK, "metal_ore");
        this.setDefaultState(this.getDefaultState().withProperty(METAL_TYPE, EnumMetalType.COPPER));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, METAL_TYPE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(METAL_TYPE).getId();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(METAL_TYPE, EnumMetalType.values()[meta]);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
        int iterator = 0;
        for(EnumMetalType metalType : EnumMetalType.values()) {
            list.add(new ItemStack(itemIn, 1, iterator));
            iterator++;
        }
    }

    @Override
    public void registerItemModel(ItemBlock block)
    {
        int iterator = 0;
        for(EnumMetalType material : EnumMetalType.values()) {
            Smores.proxy.registerItemRenderer(block,iterator, super.getUnlocalizedName() + "_" + material.toString().toLowerCase(Locale.ROOT));
            iterator++;
        }
    }
}

package com.calmbit.smores.blocks;

import com.calmbit.smores.Smores;
import com.calmbit.smores.materials.EnumGem;
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

public class BlockGem extends BlockBase {

    public static PropertyEnum<EnumGem> GEM = PropertyEnum.create("gem", EnumGem.class);

    public BlockGem() {
        super(Material.IRON, "gem_block");
        this.setDefaultState(this.getDefaultState().withProperty(GEM, EnumGem.RUBY));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, GEM);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(GEM).getId();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(GEM, EnumGem.values()[meta]);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
        int iterator = 0;
        for(EnumGem gem : EnumGem.values()) {
            list.add(new ItemStack(itemIn, 1, iterator));
            iterator++;
        }
    }

    @Override
    public void registerItemModel(ItemBlock block)
    {
        int iterator = 0;
        for(EnumGem material : EnumGem.values()) {
            Smores.proxy.registerItemRenderer(block,iterator, super.getUnlocalizedName() + "_" + material.toString().toLowerCase(Locale.ROOT));
            iterator++;
        }
    }
}

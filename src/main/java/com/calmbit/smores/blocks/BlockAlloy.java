package com.calmbit.smores.blocks;

import com.calmbit.smores.Smores;
import com.calmbit.smores.materials.EnumAlloyType;
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

public class BlockAlloy extends BlockBase {

    public static PropertyEnum<EnumAlloyType> ALLOY_TYPE = PropertyEnum.create("alloy_type", EnumAlloyType.class);

    public BlockAlloy() {
        super(Material.IRON, "alloy_block");
        this.setDefaultState(this.getDefaultState().withProperty(ALLOY_TYPE, EnumAlloyType.ELECTRUM));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, ALLOY_TYPE);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(ALLOY_TYPE).getId();
    }

    @Override
    public int damageDropped(IBlockState state) {
        return getMetaFromState(state);
    }

    @Override
    @SuppressWarnings("deprecation")
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(ALLOY_TYPE, EnumAlloyType.values()[meta]);
    }

    @Override
    public void getSubBlocks(Item itemIn, CreativeTabs tab, NonNullList<ItemStack> list) {
        int iterator = 0;
        for(EnumAlloyType alloyType : EnumAlloyType.values()) {
            list.add(new ItemStack(itemIn, 1, iterator));
            iterator++;
        }
    }

    @Override
    public void registerItemModel(ItemBlock block)
    {
        int iterator = 0;
        for(EnumAlloyType material : EnumAlloyType.values()) {
            Smores.proxy.registerItemRenderer(block,iterator, super.getUnlocalizedName() + "_" + material.toString().toLowerCase(Locale.ROOT));
            iterator++;
        }
    }
}

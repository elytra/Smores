package com.calmbit.smores.blocks;

import com.calmbit.smores.Smores;
import com.calmbit.smores.generic.IOreDict;
import com.calmbit.smores.materials.EnumGem;
import com.calmbit.smores.registries.ItemRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class BlockGemOre extends BlockBase implements IOreDict {

    public static PropertyEnum<EnumGem> GEM = PropertyEnum.create("gem", EnumGem.class);

    public BlockGemOre() {
        super(Material.ROCK, "gem_ore");
        this.setHardness(3.0f);
        this.setHarvestLevel("pickaxe", 2);
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
    public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        List<ItemStack> drops = new ArrayList<>();
        drops.add(new ItemStack(ItemRegistry.itemGem, 1, this.getMetaFromState(state)));
        return drops;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        return 2 + RANDOM.nextInt(4);
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

    @Override
    public void registerOreDict() {
        for(EnumGem material : EnumGem.values()) {
                OreDictionary.registerOre("ore"+material.getMaterialName(), new ItemStack(this, 1, material.getId()));
        }
    }
}

package com.elytradev.smores.block;

import com.elytradev.smores.init.SmoresItems;
import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockGemOre extends BlockOre {

	public static PropertyEnum<EnumMaterial> GEM = PropertyEnum.create("gem", EnumMaterial.class,
			(material) -> material.hasProduct(EnumProduct.GEM_ORE));

	public BlockGemOre() {
		super("gem_ore", GEM, EnumMaterial.RUBY);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, GEM);
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		drops.add(new ItemStack(SmoresItems.gem, 1,  getIndexOfMaterial(state.getValue(GEM))));
	}
}

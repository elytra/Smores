package com.elytradev.smores.block;

import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;

public class BlockGem extends BlockSubtyped {

	public static PropertyEnum<EnumMaterial> GEM = PropertyEnum.create("gem", EnumMaterial.class,
			(material) -> material.hasProduct(EnumProduct.GEM_BLOCK));

	public BlockGem() {
		super("gem_block", GEM, EnumMaterial.RUBY);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, GEM);
	}
}

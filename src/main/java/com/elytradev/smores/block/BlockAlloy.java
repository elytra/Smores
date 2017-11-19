package com.elytradev.smores.block;

import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;

public class BlockAlloy extends BlockSubtyped {

	public static PropertyEnum<EnumMaterial> ALLOY = PropertyEnum.create("alloy", EnumMaterial.class,
			(material) -> material.hasProduct(EnumProduct.ALLOY_BLOCK));

	public BlockAlloy() {
		super("alloy_block", ALLOY, EnumMaterial.ELECTRUM);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, ALLOY);
	}
}

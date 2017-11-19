package com.elytradev.smores.block;

import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;

public class BlockMetal extends BlockSubtyped {

	public static PropertyEnum<EnumMaterial> METAL = PropertyEnum.create("metal", EnumMaterial.class,
			(material) -> material.hasProduct(EnumProduct.METAL_BLOCK));

	public BlockMetal() {
		super("metal_block", METAL, EnumMaterial.COPPER);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, METAL);
	}
}

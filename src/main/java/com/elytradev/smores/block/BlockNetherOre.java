package com.elytradev.smores.block;

import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;

public class BlockNetherOre extends BlockOre {

	public static PropertyEnum<EnumMaterial> MINERAL = PropertyEnum.create("mineral", EnumMaterial.class,
			(material) -> material.hasProduct(EnumProduct.NETHER_ORE));

	public BlockNetherOre() {
		super("nether_ore", MINERAL, EnumMaterial.SULFUR);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, MINERAL);
	}
}

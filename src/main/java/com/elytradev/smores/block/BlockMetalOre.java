package com.elytradev.smores.block;

import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;
import net.minecraft.block.Block;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;

import java.util.function.Function;

public class BlockMetalOre extends BlockOre {

	public static PropertyEnum<EnumMaterial> METAL = PropertyEnum.create("metal", EnumMaterial.class,
			(material) -> material.hasProduct(EnumProduct.METAL_ORE));

	public static final Function<EnumMaterial, Integer> METAL_HARVEST_FUNCTION =
			(material -> (material == EnumMaterial.COPPER || material == EnumMaterial.TIN) ? 1 : 2);

	public BlockMetalOre() {
		super("metal_ore", METAL, EnumMaterial.COPPER);
		this.setHarvestLevelFunction(METAL_HARVEST_FUNCTION);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, METAL);
	}
}

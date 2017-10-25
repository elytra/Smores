package com.elytradev.smores.block;

import com.elytradev.smores.Smores;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public abstract class BlockFluidBase extends BlockFluidClassic {
	protected String name;

	public BlockFluidBase(Fluid fluid, Material material, String name) {
		super(fluid, material);
		this.name = name;

		this.setUnlocalizedName(Smores.MOD_ID + "." + name);
		this.setRegistryName(name);
	}

	public void registerItemModel(ItemBlock itemBlock) {
		Smores.PROXY.registerItemRenderer(itemBlock, 0, name);
	}

	@Override
	public BlockFluidBase setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}
}

/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017-2018
 *     Ethan Brooks (CalmBit),
 *     Isaac Ellingson (Falkreon),
 *     Una Thompson (unascribed),
 *     and contributors
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is furnished to do
 * so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.elytradev.smores.block;

import com.elytradev.smores.Smores;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

public abstract class BlockFluidSmores extends BlockFluidClassic {
	protected String name;

	public BlockFluidSmores(Fluid fluid, Material material, String name) {
		super(fluid, material);
		this.name = name;

		this.setUnlocalizedName(Smores.MOD_ID + "." + name);
		this.setRegistryName(name);
		this.setQuantaPerBlock(4);
		this.setMaxScaledLight(0);
		this.setLightLevel(1.0f);
	}

	public void registerItemModel(ItemBlock itemBlock) {
		ModelResourceLocation fluidLocation = new ModelResourceLocation(Smores.MOD_ID + ":fluid", name);
		ModelLoader.registerItemVariants(itemBlock);
		ModelLoader.setCustomMeshDefinition(itemBlock, stack -> fluidLocation);
		ModelLoader.setCustomStateMapper(itemBlock.getBlock(), new StateMapperBase()
		{
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state)
			{
				return fluidLocation;
			}
		});
	}

	@Override
	public BlockFluidSmores setCreativeTab(CreativeTabs tab) {
		super.setCreativeTab(tab);
		return this;
	}

	protected Vec3d convertToFogColor(int color) {
		double r, g, b;

		int hR = (color & 0x00FF0000) >> 16;
		int hG = (color & 0x0000FF00) >> 8;
		int hB = (color & 0x000000FF);

		r = hR/((double)0xFF);
		g = hG/((double)0xFF);
		b = hB/((double)0xFF);

		return new Vec3d(r,g,b);
	}
}

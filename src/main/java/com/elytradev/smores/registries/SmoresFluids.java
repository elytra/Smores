/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017:
 *     Ethan Brooks (CalmBit),
 *     Isaac Ellingson (Falkreon),
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

package com.elytradev.smores.registries;

import com.elytradev.smores.Smores;
import com.elytradev.smores.block.BlockFluidSmores;
import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import java.util.ArrayList;
import java.util.List;

public class SmoresFluids {

	public static List<Fluid> molten_metals;
	public static List<BlockFluidSmores> molten_metal_blocks;

	public static List<Fluid> molten_alloys;
	public static List<BlockFluidSmores> molten_alloy_blocks;

	public static void init() {
		molten_metals = new ArrayList<>();
		molten_metal_blocks = new ArrayList<>();
		molten_alloys = new ArrayList<>();
		molten_alloy_blocks = new ArrayList<>();

		int metalFluidIterator = 0, alloyFluidIterator = 0;

		for (EnumMaterial material : EnumMaterial.values()) {
			if (EnumProduct.METAL_FLUID.hasMaterial(material)) {
				molten_metals.add(metalFluidIterator, new Fluid(Smores.MOD_ID + ".molten_" + material.getName(),
						new ResourceLocation("smores",
								"blocks/fluid_molten_" + material.getName() + "_still"),
						new ResourceLocation("smores",
								"blocks/fluid_molten_" + material.getName() + "_flowing"))
						.setLuminosity(15).setDensity(material.getDensity()).setViscosity(6000)
						.setTemperature(material.getMeltingPoint()));

				registerFluid(molten_metals.get(metalFluidIterator));
				metalFluidIterator++;
			} else if (EnumProduct.ALLOY_FLUID.hasMaterial(material)) {
				molten_alloys.add(alloyFluidIterator, new Fluid(Smores.MOD_ID+".molten_"+material.getName(),
						new ResourceLocation("smores",
								"blocks/fluid_molten_"+material.getName()+"_still"),
						new ResourceLocation("smores",
								"blocks/fluid_molten_"+material.getName()+"_flowing"))
						.setLuminosity(15).setDensity(material.getDensity()).setViscosity(6000)
						.setTemperature(material.getMeltingPoint()));

				registerFluid(molten_alloys.get(alloyFluidIterator));
				alloyFluidIterator++;
			}
		}

	}

	private static void registerFluid(Fluid fluid) {
		net.minecraftforge.fluids.FluidRegistry.registerFluid(fluid);
		net.minecraftforge.fluids.FluidRegistry.addBucketForFluid(fluid);
	}

}

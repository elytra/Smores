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
import com.elytradev.smores.materials.EnumAlloy;
import com.elytradev.smores.materials.EnumMetal;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;

import java.util.ArrayList;
import java.util.List;

public class FluidRegistry {

	private static final int[] MOLTEN_METAL_DENSITIES = {
			8020,
			6990,
			10660,
			9320,
			7810,
			19770,
			4110,
			6570,
			6980,
			17310
	};

	private static final int[] MOLTEN_METAL_MP = {
			1357,
			505,
			600,
			1234,
			1728,
			2041,
			1941,
			692,
			1811,
			1337
	};

	private static final int[] MOLTEN_ALLOY_DENSITIES = {
			13750,
			8055,
			7800,
			8800,
			8520
	};

	private static final int[] MOLTEN_ALLOY_MP = {
			1336,
			1700,
			1644,
			1186,
			1200
	};

	public static List<Fluid> molten_metals;
	public static List<BlockFluidSmores> molten_metal_blocks;

	public static List<Fluid> molten_alloys;
	public static List<BlockFluidSmores> molten_alloy_blocks;

	public static void init() {
		molten_metals = new ArrayList<>();
		molten_metal_blocks = new ArrayList<>();
		molten_alloys = new ArrayList<>();
		molten_alloy_blocks = new ArrayList<>();

		for(EnumMetal metal : EnumMetal.values()) {
			molten_metals.add(metal.getId(), new Fluid(Smores.MOD_ID+".molten_"+metal.getName(),
					new ResourceLocation("smores",
							"blocks/fluid_molten_"+metal.getName()+"_still"),
					new ResourceLocation("smores",
							"blocks/fluid_molten_"+metal.getName()+"_flowing"))
					.setLuminosity(15).setDensity(MOLTEN_METAL_DENSITIES[metal.getId()]).setViscosity(6000)
					.setTemperature(MOLTEN_METAL_MP[metal.getId()]));

			registerFluid(molten_metals.get(metal.getId()));
		}

		for(EnumAlloy alloy : EnumAlloy.values()) {
			molten_alloys.add(alloy.getId(), new Fluid(Smores.MOD_ID+".molten_"+alloy.getName(),
					new ResourceLocation("smores",
							"blocks/fluid_molten_"+alloy.getName()+"_still"),
					new ResourceLocation("smores",
							"blocks/fluid_molten_"+alloy.getName()+"_flowing"))
					.setLuminosity(15).setDensity(MOLTEN_ALLOY_DENSITIES[alloy.getId()]).setViscosity(6000)
					.setTemperature(MOLTEN_ALLOY_MP[alloy.getId()]));

			registerFluid(molten_alloys.get(alloy.getId()));
		}

	}

	private static void registerFluid(Fluid fluid) {
		net.minecraftforge.fluids.FluidRegistry.registerFluid(fluid);
		net.minecraftforge.fluids.FluidRegistry.addBucketForFluid(fluid);
	}

}

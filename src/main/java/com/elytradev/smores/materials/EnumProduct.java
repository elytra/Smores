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

package com.elytradev.smores.materials;

import java.util.EnumSet;
import java.util.Locale;

public enum EnumProduct {

	// Why (n) definitions?
	// Blocks still only have 16 metadata values, so we're stuck making at least (n). Fuck.
	METAL_BLOCK("Metal_Block", EnumMaterial.SMORES_ELEMENTAL_METALS, EnumProductType.BLOCK),
	ALLOY_BLOCK("Alloy_Block", EnumMaterial.SMORES_ALLOYS, EnumProductType.BLOCK),
	GEM_BLOCK("Gem_Block", EnumMaterial.SMORES_GEMS, EnumProductType.BLOCK),
	METAL_ORE("Metal_Ore", EnumMaterial.SMORES_METALS, EnumProductType.BLOCK),
	GEM_ORE("Gem_Ore", EnumMaterial.SMORES_GEMS, EnumProductType.BLOCK),
	NETHER_ORE("Nether_Ore", EnumSet.of(EnumMaterial.SULFUR, EnumMaterial.NITRE,
			EnumMaterial.URANIUM, EnumMaterial.PLUTONIUM), EnumProductType.BLOCK),
	METAL_FLUID("Metal_Fluid", EnumMaterial.SMORES_METALS_WITH_VANILLA, EnumProductType.FLUID),
	ALLOY_FLUID("Alloy_Fluid", EnumMaterial.SMORES_ALLOYS, EnumProductType.FLUID),
	INGOT("Ingot", EnumMaterial.SMORES_METALLIC, EnumProductType.ITEM),
	GEM("Gem", EnumMaterial.SMORES_GEMS, EnumProductType.ITEM),
	DUST("Dust", EnumMaterial.SMORES_DUSTABLE, EnumProductType.ITEM),
	NUGGET("Nugget", EnumMaterial.SMORES_METALLIC, EnumProductType.ITEM),
	PLATE("Plate", EnumMaterial.SMORES_METALLIC_WITH_VANILLA, EnumProductType.ITEM),
	GLOB("Glob", EnumSet.of(EnumMaterial.MERCURY), EnumProductType.ITEM), // For mercury, because not technically an ingot?
	GEAR("Gear", EnumMaterial.SMORES_METALLIC_WITH_VANILLA, EnumProductType.ITEM),
	ROD("Rod", EnumSet.of(EnumMaterial.URANIUM, EnumMaterial.PLUTONIUM), EnumProductType.ITEM);

	public enum EnumProductType {
		BLOCK,
		FLUID,
		ITEM
	}

	public String name;
	public EnumSet<EnumMaterial> materials;
	public EnumProductType type;

	EnumProduct(String name, EnumSet<EnumMaterial> materials, EnumProductType type) {
		this.name = name;
		this.materials = materials.clone();
		this.type = type;
	}

	public String getName() {
		return name.toLowerCase(Locale.ROOT);
	}

	public String getProductName() {
		return name;
	}

	public boolean hasMaterial(EnumMaterial material) {
		return materials.contains(material);
	}

}

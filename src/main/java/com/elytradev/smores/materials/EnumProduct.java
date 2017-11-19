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

package com.elytradev.smores.materials;

import java.util.EnumSet;
import java.util.Locale;

public enum EnumProduct {

	// Why (n) definitions?
	// Blocks still only have 16 metadata values, so we're stuck making at least (n). Fuck.
	METAL_BLOCK("Metal_Block"),
	ALLOY_BLOCK("Alloy_Block"),
	GEM_BLOCK("Gem_Block"),
	METAL_ORE("Metal_Ore"),
	GEM_ORE("Gem_Ore"),
	NETHER_ORE("Nether_Ore"),
	METAL_FLUID("Metal_Fluid"),
	ALLOY_FLUID("Alloy_Fluid"),
	INGOT("Ingot"),
	GEM("Gem"),
	DUST("Dust"),
	NUGGET("Nugget"),
	PLATE("Plate"),
	GLOB("Glob"), // For mercury, because not technically an ingot?
	GEAR("Gear"),
	ROD("Rod");

	public String name;

	public static final EnumSet<EnumProduct> DEFAULT_METAL =
			EnumSet.of(EnumProduct.METAL_BLOCK, EnumProduct.METAL_ORE, EnumProduct.METAL_FLUID, EnumProduct.INGOT, EnumProduct.DUST,
					EnumProduct.NUGGET, EnumProduct.PLATE, EnumProduct.GEAR);

	public static final EnumSet<EnumProduct> VANILLA_METAL =
			EnumSet.of(EnumProduct.METAL_FLUID, EnumProduct.DUST, EnumProduct.PLATE, EnumProduct.GEAR);

	public static final EnumSet<EnumProduct> DEFAULT_ALLOY =
			EnumSet.of(EnumProduct.ALLOY_BLOCK, EnumProduct.ALLOY_FLUID, EnumProduct.INGOT, EnumProduct.DUST, EnumProduct.NUGGET,
					EnumProduct.PLATE, EnumProduct.GEAR);

	public static final EnumSet<EnumProduct> DEFAULT_NETHER =
			EnumSet.of(EnumProduct.NETHER_ORE, EnumProduct.DUST);

	public static final EnumSet<EnumProduct> DEFAULT_GEM =
			EnumSet.of(EnumProduct.GEM_BLOCK, EnumProduct.GEM_ORE, EnumProduct.GEM);

	EnumProduct(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String getProductName() {
		return name.toLowerCase(Locale.ROOT);
	}



}

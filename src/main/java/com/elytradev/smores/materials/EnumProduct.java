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

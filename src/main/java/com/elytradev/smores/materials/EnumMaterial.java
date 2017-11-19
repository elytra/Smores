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

import net.minecraft.util.IStringSerializable;

import java.util.EnumSet;
import java.util.Locale;

public enum EnumMaterial implements IStringSerializable {

	COPPER("Copper", 		0, 	0xFFB47129, 8020, 	1357,	EnumProduct.DEFAULT_METAL),
	TIN("Tin", 				1, 	0xFFCACACA, 6990, 	505,	EnumProduct.DEFAULT_METAL),
	LEAD("Lead", 			2, 	0xFF55557B, 10660, 	600,	EnumProduct.DEFAULT_METAL),
	SILVER("Silver", 		3, 	0xFFC9C9E6, 9320, 	1234,	EnumProduct.DEFAULT_METAL),
	NICKEL("Nickel", 		4, 	0xFF9F9285, 7810, 	1728,	EnumProduct.DEFAULT_METAL),
	PLATINUM("Platinum", 	5, 	0xFF6FA9DD, 19770, 	2041,	EnumProduct.DEFAULT_METAL),
	MITHRIL("Mithril", 		6, 	0xFFBE94B2, 4110, 	1941,	EnumProduct.DEFAULT_METAL),
	ZINC("Zinc", 			7, 	0xFFC5D098, 6570, 	692,	EnumProduct.DEFAULT_METAL),
	URANIUM("Uranium", 		8, 	0xFF95FF4F, 17300, 	1405,	EnumSet.of(EnumProduct.METAL_BLOCK, EnumProduct.NETHER_ORE,
			EnumProduct.DUST, EnumProduct.GEAR, EnumProduct.INGOT, EnumProduct.ROD)),
	IRON("Iron", 			9, 	0xFF969696, 6980, 	1811,	EnumProduct.VANILLA_METAL),
	GOLD("Gold", 			10, 0xFFFFFF0B, 17310, 	1337,	EnumProduct.VANILLA_METAL),
	ELECTRUM("Electrum", 	11, 0xFFFCFE3A, 13750, 	1336,	EnumProduct.DEFAULT_ALLOY),
	INVAR("Invar", 			12, 0xFFC3BAA9, 8055, 	1700, 	EnumProduct.DEFAULT_ALLOY),
	STEEL("Steel", 			13, 0xFFA4B6BD, 7800, 	1644,	EnumProduct.DEFAULT_ALLOY),
	BRONZE("Bronze", 		14, 0xFFFC8E00, 8800, 	1186,	EnumProduct.DEFAULT_ALLOY),
	BRASS("Brass", 			15, 0xFFFCC400, 8520, 	1200,	EnumProduct.DEFAULT_ALLOY),
	RUBY("Ruby", 			16, 0xFF000000, -1,     -1,		EnumProduct.DEFAULT_GEM),
	SAPPHIRE("Sapphire", 	17, 0xFF000000, -1,     -1,		EnumProduct.DEFAULT_GEM),
	PERIDOT("Peridot", 		18, 0xFF000000, -1,     -1,		EnumProduct.DEFAULT_GEM),
	SULFUR("Sulfur", 		19, 0xFF000000, -1, 	-1,		EnumProduct.DEFAULT_NETHER),
	NITRE("Nitre", 			20, 0xFF000000, -1,		-1,		EnumProduct.DEFAULT_NETHER),
	MERCURY("Mercury", 		21, 0xFF000000, -1,		-1,		EnumSet.of(EnumProduct.GLOB)),
	LAPIS("Lapis", 			22, 0xFF000000, -1,		-1,		EnumSet.of(EnumProduct.DUST));


	private String materialName;
	private int id;
	private int color;
	private int density;
	private int meltingPoint;
	private EnumSet<EnumProduct> productSet;

	EnumMaterial(String materialName,
				 int id,
				 int color,
				 int density,
				 int meltingPoint,
				 EnumSet<EnumProduct> productSet) {
		this.id = id;
		this.materialName = materialName;
		this.color = color;
		this.density = density;
		this.meltingPoint = meltingPoint;
		this.productSet = productSet.clone();
	}

	public String getName() {
		return this.materialName.toLowerCase(Locale.ROOT);
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public int getId() {
		return this.id;
	}

	public int getColor() {
		return this.color;
	}

	public int getDensity() {
		return density;
	}

	public int getMeltingPoint() {
		return meltingPoint;
	}

	public boolean hasProduct(EnumProduct product) {
		return this.productSet.contains(product);
	}
}

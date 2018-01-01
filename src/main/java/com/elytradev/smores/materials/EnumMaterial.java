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

import net.minecraft.util.IStringSerializable;

import java.util.EnumSet;
import java.util.Locale;

public enum EnumMaterial implements IStringSerializable {

	// Hey there person in the future!
	// Quick note about how this sytem works -
	// if you put new enums anywhere other than at the
	// end of this list, you're going to break saves.
	// Don't do that! Thank you.
	// | Name             | ID | Colour   | Density | Melting Point |
	COPPER("Copper",        0,  0xFFB47129, 8020,   1357),
	TIN("Tin",              1,  0xFFCACACA, 6990,   505),
	LEAD("Lead",            2,  0xFF55557B, 10660,  600),
	SILVER("Silver",        3,  0xFFC9C9E6, 9320,   1234),
	NICKEL("Nickel",        4,  0xFF9F9285, 7810,   1728),
	PLATINUM("Platinum",    5,  0xFF6FA9DD, 19770,  2041),
	MITHRIL("Mithril",      6,  0xFFBE94B2, 4110,   1941),
	ZINC("Zinc",            7,  0xFFC5D098, 6570,   692),
	URANIUM("Uranium",      8,  0xFF95FF4F, 17300,  1405),
	IRON("Iron",            9,  0xFF969696, 6980,   1811),
	GOLD("Gold",            10, 0xFFFFFF0B, 17310,  1337),
	ELECTRUM("Electrum",    11, 0xFFFCFE3A, 13750,  1336),
	INVAR("Invar",          12, 0xFFC3BAA9, 8055,   1700),
	STEEL("Steel",          13, 0xFFA4B6BD, 7800,   1644),
	BRONZE("Bronze",        14, 0xFFFC8E00, 8800,   1186),
	BRASS("Brass",          15, 0xFFFCC400, 8520,   1200),
	RUBY("Ruby",            16, 0xFFFF1C1C, -1,     -1),
	SAPPHIRE("Sapphire",    17, 0xFF194FFF, -1,     -1),
	PERIDOT("Peridot",      18, 0xFF5EAE1E, -1,     -1),
	SULFUR("Sulfur",        19, 0xFF000000, -1,     -1),
	NITRE("Nitre",          20, 0xFF000000, -1,     -1),
	MERCURY("Mercury",      21, 0xFF000000, -1,     -1),
	LAPIS("Lapis",          22, 0xFF3030EF, -1,     -1),
	PLUTONIUM("Plutonium",	23, 0xFF6849DB, -1,		-1);

	public static EnumSet<EnumMaterial> SMORES_METALS = EnumSet.of(COPPER, TIN, LEAD, SILVER, NICKEL, PLATINUM,
			MITHRIL, ZINC);

	// Smores Metals + Vanilla
	public static EnumSet<EnumMaterial> SMORES_METALS_WITH_VANILLA = EnumSet.of(COPPER, TIN, LEAD, SILVER, NICKEL,
			PLATINUM, MITHRIL, ZINC, IRON, GOLD);

	public static EnumSet<EnumMaterial> SMORES_ALLOYS = EnumSet.of(ELECTRUM, INVAR, STEEL, BRONZE, BRASS);

	public static EnumSet<EnumMaterial> SMORES_GEMS = EnumSet.of(RUBY, SAPPHIRE, PERIDOT);

	// Smores Metals + Irregular Metals
	public static EnumSet<EnumMaterial> SMORES_ELEMENTAL_METALS = EnumSet.of(COPPER, TIN, LEAD, SILVER, NICKEL,
			PLATINUM, MITHRIL, ZINC, URANIUM, PLUTONIUM);

	// Smores Elemental Metals + Alloys
	public static EnumSet<EnumMaterial> SMORES_METALLIC = EnumSet.of(COPPER, TIN, LEAD, SILVER, NICKEL, PLATINUM,
			MITHRIL, ZINC, URANIUM, PLUTONIUM, ELECTRUM, INVAR, STEEL, BRONZE, BRASS);

	// Smores Metallic + Vanilla
	public static EnumSet<EnumMaterial> SMORES_METALLIC_WITH_VANILLA = EnumSet.of(COPPER, TIN, LEAD, SILVER, NICKEL,
			PLATINUM, MITHRIL, ZINC, URANIUM, PLUTONIUM, ELECTRUM, INVAR, STEEL, BRONZE, BRASS, IRON, GOLD);

	public static EnumSet<EnumMaterial> SMORES_DUSTABLE = EnumSet.of(COPPER, TIN, LEAD, SILVER, NICKEL,
			PLATINUM, MITHRIL, ZINC, URANIUM, PLUTONIUM, ELECTRUM, INVAR, STEEL, BRONZE, BRASS, IRON, GOLD, LAPIS,
			SULFUR, NITRE);

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
				 int meltingPoint) {
		this.id = id;
		this.materialName = materialName;
		this.color = color;
		this.density = density;
		this.meltingPoint = meltingPoint;
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
}

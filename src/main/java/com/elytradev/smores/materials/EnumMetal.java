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

import java.util.Locale;

public enum EnumMetal implements IStringSerializable {

	COPPER("Copper", 0, 0xFFB47129, 8020, 1357),
	TIN("Tin", 1, 0xFFCACACA, 6990, 505),
	LEAD("Lead", 2, 0xF55557B, 10660, 600),
	SILVER("Silver", 3, 0xFFC9C9E6, 9320, 1234),
	NICKEL("Nickel", 4, 0xFF9F9285, 7810, 1728),
	PLATINUM("Platinum", 5, 0xFF6FA9DD, 19770, 2041),
	MITHRIL("Mithril", 6, 0xFFBE94B2, 4110, 1941),
	ZINC("Zinc", 7, 0xFFC5D098, 6570, 692),
	IRON("Iron", 8, 0xF969696, 6980, 1811),
	GOLD("Gold", 9, 0xFFFFFF0B, 17310, 1337);

	private String materialName;
	private int id;
	private int color;
	private int density;
	private int meltingPoint;

	EnumMetal(String materialName, int id, int color, int density, int meltingPoint) {
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

	public EnumItem[] getTypes() {
		return new EnumItem[]{EnumItem.INGOT, EnumItem.ORE, EnumItem.DUST, EnumItem.PLATE, EnumItem.GEAR};
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

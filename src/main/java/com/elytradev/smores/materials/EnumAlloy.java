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

public enum EnumAlloy implements IStringSerializable {

	ELECTRUM("Electrum", 0, 0xFFFCFE3A, 13750, 1336),
	INVAR("Invar", 1, 0xFFC3BAA9, 8055, 1700),
	STEEL("Steel", 2, 0xFFA4B6BD, 7800, 1644),
	BRONZE("Bronze", 3, 0xFFFC8E00, 8800, 1186),
	BRASS("Brass", 4, 0xFFFCC400, 8520, 1200);

	private String materialName;
	private int id;
	private int color;
	private int density;
	private int meltingPoint;

	EnumAlloy(String materialName, int id, int color, int density, int meltingPoint) {
		this.materialName = materialName;
		this.id = id;
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
		return id;
	}

	public EnumItem[] getTypes() {
		return new EnumItem[]{EnumItem.INGOT, EnumItem.DUST, EnumItem.PLATE, EnumItem.GEAR};
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

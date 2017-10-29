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

	COPPER("Copper", 0, 0xFFB47129),
	TIN("Tin", 1, 0xFFCACACA),
	LEAD("Lead", 2, 0xF55557B),
	SILVER("Silver", 3, 0xFFC9C9E6),
	NICKEL("Nickel", 4, 0xFF9F9285),
	PLATINUM("Platinum", 5, 0xFF6FA9DD),
	MITHRIL("Mithril", 6, 0xFFBE94B2),
	ZINC("Zinc", 7, 0xFFC5D098),
	IRON("Iron", 8, 0xF969696),
	GOLD("Gold", 9, 0xFFFFFF0B),;

	private String materialName;
	private int id;
	private int color;

	EnumMetal(String materialName, int id, int color) {
		this.id = id;
		this.materialName = materialName;
		this.color = color;
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

}

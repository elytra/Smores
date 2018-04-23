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

package com.elytradev.smores.item;

import com.elytradev.smores.Smores;
import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class ItemProduct extends ItemBase implements IOreDict {
	private EnumProduct productType;
	private EnumMaterial material;

	public ItemProduct(EnumProduct productType, EnumMaterial material) {
		super(material.getName() + "_" + productType.getName());
		this.productType = productType;
		this.material = material;
		this.setCreativeTab(Smores.CREATIVE_TAB);
	}

	@Override
	public void registerOreDict() {
		OreDictionary.registerOre(productType.getName()+material.getMaterialName(), new ItemStack(this, 1));
	}

	@Override
	public void registerItemModel(Item item) {
		Smores.PROXY.registerItemRenderer(item, 0, this.name);
	}
}

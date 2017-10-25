/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2017:
 *	 Ethan Brooks (CalmBit),
 *	 Isaac Ellingson (Falkreon),
 *	 and contributors
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
import com.elytradev.smores.generic.SmoresCreativeTab;
import com.elytradev.smores.materials.EnumAlloy;
import com.elytradev.smores.materials.EnumMetal;
import com.elytradev.smores.materials.EnumNether;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

import java.util.ArrayList;
import java.util.Locale;

public class ItemDust extends ItemBase implements IOreDict {

	private static ArrayList<String> materials;

	public ItemDust() {
		super("dust");
		this.setMaxDamage(0);
		this.setHasSubtypes(true);

		if (materials == null) {
			materials = new ArrayList<>();
			for (EnumMetal metal : EnumMetal.values()) {
				materials.add(metal.getMaterialName());
			}
			for (EnumAlloy alloy : EnumAlloy.values()) {
				materials.add(alloy.getMaterialName());
			}
			for (EnumNether nether : EnumNether.values()) {
				materials.add(nether.getMaterialName());
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> subItems) {
		if (isInCreativeTab(tab)) {
			for (String material : materials) {
				subItems.add(new ItemStack(this, 1, materials.indexOf(material)));
			}
		}
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return super.getUnlocalizedName(stack) + "_" + materials.get(stack.getItemDamage()).toLowerCase(Locale.ROOT);
	}

	@Override
	public void registerOreDict() {
		for (String material : materials) {
			OreDictionary.registerOre("dust" + material, new ItemStack(this, 1, materials.indexOf(material)));
		}
	}

	@Override
	public void registerItemModel() {
		for (String material : materials) {
			Smores.PROXY.registerItemRenderer(this, materials.indexOf(material), "dust_" + material.toLowerCase(Locale.ROOT));
		}
	}

	public static int getMaterialIndex(String materialName) {
		return materials.indexOf(materialName);
	}

}

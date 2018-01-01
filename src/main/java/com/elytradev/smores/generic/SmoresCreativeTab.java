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

package com.elytradev.smores.generic;

import com.elytradev.smores.init.SmoresItems;
import com.elytradev.smores.item.ItemProduct;
import com.elytradev.smores.materials.EnumMaterial;
import com.elytradev.smores.materials.EnumProduct;
import com.elytradev.smores.registries.SmoresFluids;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.oredict.OreDictionary;

import java.util.List;

public class SmoresCreativeTab extends CreativeTabs {

	public SmoresCreativeTab(String label) {
		super(label);
	}

	@Override
	public ItemStack getTabIconItem() {
		return new ItemStack(SmoresItems.getItemList(EnumProduct.INGOT).get(0), 1);
	}

	@Override
	public void displayAllRelevantItems(NonNullList<ItemStack> itemList) {
		int metalFluidIterator = 0, alloyFluidIterator = 0;

		for (EnumMaterial material : EnumProduct.METAL_FLUID.materials) {
			itemList.add(FluidUtil.getFilledBucket(
					new FluidStack(SmoresFluids.molten_metals.get(metalFluidIterator), 1000)));
			metalFluidIterator++;
		}

		for (EnumMaterial material : EnumProduct.ALLOY_FLUID.materials) {
			itemList.add(FluidUtil.getFilledBucket(
					new FluidStack(SmoresFluids.molten_alloys.get(alloyFluidIterator), 1000)));
			alloyFluidIterator++;
		}

		for (EnumProduct product : EnumProduct.values()) {
			if (product.type != EnumProduct.EnumProductType.ITEM)
				continue;

			List<ItemProduct> list = SmoresItems.getItemList(product);
			for (ItemProduct item : list) {
				itemList.add(new ItemStack(item, 1));
			}
		}



		super.displayAllRelevantItems(itemList);
	}
}

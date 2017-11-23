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

package com.elytradev.smores.block;

import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.materials.EnumMaterial;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

import java.util.function.Function;

import javax.annotation.Nullable;

public class BlockOre extends BlockSubtyped implements IOreDict {

	public Function<EnumMaterial, Integer> harvestLevelFunction;

	public BlockOre(String name, PropertyEnum<EnumMaterial> materialProperty, EnumMaterial defaultMaterial) {
		super(name, materialProperty, defaultMaterial);
		this.setHardness(3.0f);
		this.harvestLevelFunction = material -> 2;
	}

	public BlockOre setHarvestLevelFunction(Function<EnumMaterial, Integer> harvestLevelFunction) {
		this.harvestLevelFunction = harvestLevelFunction;
		return this;
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return harvestLevelFunction.apply(state.getValue(materialProperty));
	}

	@Nullable
	@Override
	public String getHarvestTool(IBlockState state) {
		return "pickaxe";
	}

	@Override
	public void registerOreDict() {
		for (EnumMaterial material : materialProperty.getAllowedValues()) {
			OreDictionary.registerOre("ore" + material.getMaterialName(),
					new ItemStack(this, 1, getIndexOfMaterial(material)));
		}
	}
}

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

import com.elytradev.smores.Smores;
import com.elytradev.smores.generic.IOreDict;
import com.elytradev.smores.materials.EnumMaterial;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.oredict.OreDictionary;

public class BlockSubtyped extends BlockBase implements IOreDict {

	public PropertyEnum<EnumMaterial> materialProperty;

	public BlockSubtyped(String name, PropertyEnum<EnumMaterial> materialProperty, EnumMaterial defaultMaterial) {
		super(Material.IRON, name);
		this.materialProperty = materialProperty;
		this.setDefaultState(this.getDefaultState().withProperty(this.materialProperty, defaultMaterial));
		this.setHardness(5.0f);
		this.setHarvestLevel("pickaxe", 2);
	}

	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return getIndexOfMaterial(state.getValue(materialProperty));
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(materialProperty,
				getMaterialFromIndex(meta));
	}

	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) {
		int iterator = 0;
		for (EnumMaterial material : materialProperty.getAllowedValues()) {
			items.add(new ItemStack(this, 1, iterator));
			iterator++;
		}
	}

	@Override
	public void registerItemModel(ItemBlock block) {
		int iterator = 0;
		for (EnumMaterial material : materialProperty.getAllowedValues()) {
			Smores.PROXY.registerItemRenderer(block, iterator, super.getUnlocalizedName() + "_" + material.getName());
			iterator++;
		}
	}

	@Override
	public void registerOreDict() {
		for (EnumMaterial material : materialProperty.getAllowedValues()) {
			OreDictionary.registerOre("block" + material.getMaterialName(),
					new ItemStack(this, 1, getIndexOfMaterial(material)));
		}
	}

	public int getIndexOfMaterial(EnumMaterial material) {
		int index = 0;
		for (EnumMaterial mat : materialProperty.getAllowedValues()) {
			if (mat == material)
				return index;
			index++;
		}
		return -1;
	}

	public EnumMaterial getMaterialFromIndex(int index) {
		return ((EnumMaterial) materialProperty.getAllowedValues().toArray()[index]);
	}
}